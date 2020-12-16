package com.lti.controller;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lti.pojo.Student;
import com.lti.service.EmailService;
import com.lti.service.RegistrationService;
import com.lti.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/")
@RestController
//@ResponseBody
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/registerStudent")
	public Student registerUser(@RequestBody Student student) throws Exception {
		String tempEmail = student.getEmailId();
		if (tempEmail != null && !"".equals(tempEmail)) {
			Student userObj = service.fetchUserByemailId(tempEmail);
			if (userObj != null) {
				throw new Exception("user with this id is already exsist");
			}
		}
		Student userObj = null;
		userObj = service.saveUser(student);
		return userObj;
	}
	 @PostMapping("/login")
	 public ResponseEntity<Student> loginStudent(@RequestBody Student student)
	 throws Exception {
	 String tempEmailId = student.getEmailId();
	 String temppwd = student.getPassword();
	 Student userObj1 = null;
	 if (tempEmailId != null && temppwd != null) {
	 userObj1 = service.fetchUserByemailIdAndPassword(tempEmailId, temppwd);
	
	 if(userObj1 == null){
	 throw new Exception("User does not exist");
	 }
	 }
	 return new ResponseEntity<Student>((Student)userObj1, HttpStatus.OK);
	 }
	 
	//Reset API
	/*
	 * @GetMapping(value = "/forgot") public ModelAndView
	 * displayForgotPasswordPage() { return new ModelAndView("forgotPassword"); }
	 */
	    
	 @RequestMapping(path ="/forgetpassword/{emailId}/", produces = "text/plain")
		//@RequestMapping(path = "/forgetpassword", produces = "text/plain")
		public String forgetPassword(@PathVariable("emailId") String emailId) {
			Optional<Student> stu =userService.findUserByEmailId(emailId);
			Student student=stu.get();
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("wdl.kjs@gmail.com");
			passwordResetEmail.setTo(student.getEmailId());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("Your password is " + student.getPassword());

			emailService.sendEmailId(passwordResetEmail);
			return student.getEmailId();
		}
		@GetMapping(value = "/reset")
		public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
			
			Optional<Student> student = userService.findUserByResetToken(token);

			if (student.isPresent()) { 
				modelAndView.addObject("resetToken", token);
			} else { 
				modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
			}
			modelAndView.setViewName("resetPassword");
			return modelAndView;
		}

		//Process reset password form
		@PostMapping(value = "/reset")
		public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

			//Find the user emailid associated with the reset token
			Optional<Student> user = userService.findUserByResetToken(requestParams.get("token"));

			if (user.isPresent()) {
				
				Student resetUser = user.get();             
	            resetUser.setPassword(requestParams.get("password"));            
				resetUser.setResetToken(null);
				userService.save(resetUser);
				
				//Redirect to login page
				redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

				modelAndView.setViewName("redirect:login");
				return modelAndView;
				
			} else {
				modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
				modelAndView.setViewName("resetPassword");	
			}
			
			return modelAndView;
	   }
	   
		@ExceptionHandler(MissingServletRequestParameterException.class)
		public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
			return new ModelAndView("redirect:login");
		}
		  
		 
	 
}