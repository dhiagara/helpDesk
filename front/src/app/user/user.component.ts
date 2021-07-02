import { Component, OnInit } from '@angular/core';
import { FormBuilder,Validators } from '@angular/forms';
import { AddUserService } from '../services/add-user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private fb: FormBuilder,private addUserSrv:AddUserService) { }
  addUser = this.fb.group({
    nom: ['',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
    prenom: ['',],
    numSerie: [''],
    tel: ['',],
    emailId: ['',],
    password: ['',],

   
  });

  ngOnInit() {
  }
  onSubmit(){
    const formData = new  FormData();
    formData.append('user',JSON.stringify(this.addUser.value));
    console.log("dwawawwwwwwwwwwwwwww",formData.get('user'))
    this.addUserSrv.registerUser(this.addUser.value).subscribe(res=>{
      
      console.log("wawa"); 

    })
  }

}
