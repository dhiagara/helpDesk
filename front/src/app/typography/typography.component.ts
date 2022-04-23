import { Component, OnInit } from '@angular/core';
import { AddUserService } from '../services/add-user.service';

@Component({
  selector: 'app-typography',
  templateUrl: './typography.component.html',
  styleUrls: ['./typography.component.css']
})
export class TypographyComponent implements OnInit {
  listReclamation ;
  constructor(private srv:AddUserService) { }

  ngOnInit() {
    this.srv.getAllReclamation().subscribe(r=>{
      this.listReclamation=r;
    })
  }
  accpteReclamation( reclamation){
    this.srv.accepterReclamation(reclamation.emailId,reclamation.password).subscribe(r=>{
      console.log(r)
    })  }

}
