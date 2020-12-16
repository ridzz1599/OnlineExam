import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../Services/api.service';

@Component({
  selector: 'app-addexam',
  templateUrl: './addexam.component.html',
  styleUrls: ['./addexam.component.css']
})
export class AddexamComponent implements OnInit {
  addExamForm:FormGroup;
  examName:FormControl;
  duration:FormControl;
  question:FormControl;
  passingmarks:FormControl;
  error:boolean;
  
  constructor(private _apiservice: ApiService,formbuilder: FormBuilder) {
    this.examName = new FormControl("",Validators.required);
    this.duration=new FormControl("",Validators.required);
    this.question=new FormControl("",Validators.required);
    this.passingmarks=new FormControl("",Validators.required);
    this.addExamForm=formbuilder.group({"exam_name":this.examName, "duration":this.duration, "passingmarks":this.passingmarks, "question":this.question,"duration1":this.duration});
  }
  // validPassingMarks(passingmarks:FormControl){
  //     let val=parseInt(this.duration.value);
  //     if(parseInt(passingmarks.value)>val){
  //         return{
  //           "passerror":true
  //         }
  //     }

  // }
  ngOnInit(): void {
  }
  addExam(){
    this.error=false;
    if(!this.addExamForm.value){
        this.error=true;
        console.log(this.error);
        return;
    }
    let examname=this.examName.value;
    let duration=parseInt(this.duration.value);
    let question=parseInt(this.question.value);
    let passingmarks=parseInt(this.passingmarks.value);
    console.log(examname,duration,question,passingmarks);

    this.addExamForm.reset();

  }
}
