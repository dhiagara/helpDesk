import { Component, OnInit } from '@angular/core';
import { User } from '../auth/user';
import { NgForm } from '@angular/forms';

import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { AddUserService } from '../services/add-user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  message = '';
  user = new User();
  constructor(private service: AuthService, private router: Router, private srv: AddUserService) { }

  ngOnInit() {
  }
  loginUser() {


    this.service.login(this.user.emailId, this.user.password).subscribe(
      DataCue => {
        if (this.user.emailId == 'admin@mail.com') {
          this.router.navigate(['tablesusers'])
        }
        else this.router.navigate(['reclamation'])
      },
      error => {
        console.log("exeception occured", error),
          this.message = "please enter valid email and password "
      },
    )

  }
  GoToRegister() {
    this.router.navigate(['register'])
  }
  reclamation() {
    this.srv.addReclamation(this.user.emailId, this.user.password).subscribe(
      DataCue => {

      },
      error => {
        console.log("exeception occured", error),
          this.message = " exeception occured"
      },
    )

  }
}
