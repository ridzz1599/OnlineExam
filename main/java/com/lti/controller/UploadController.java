package com.lti.controller;

import com.lti.pojo.Questions;
import com.lti.service.*;
import com.lti.ResponseMessage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class UploadController {

	@Autowired
	QuestionService fileService;
	
	/*
	 * @GetMapping("/") public String index() { return "index"; }
	 */
	
	@PostMapping("/Upload")	
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("examname") String examname,@RequestParam("duration") int duration,@RequestParam("noofques") int noodques,@RequestParam("passscore") int passscore) {
	    String message = "";
	    System.out.print(file);
	    System.out.println(CSVHelper.hasCSVFormat(file));
	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	    	fileService.save(file,examname,duration,noodques,passscore,file.getOriginalFilename());
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }
        //return "file-upload-status";
    }