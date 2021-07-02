import { Component, OnInit } from '@angular/core';
import { AddUserService } from '../services/add-user.service';

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {
  listUsers ; 
  constructor(private srv:AddUserService) { }

  ngOnInit() {
    this.srv.getAllUsers(2).subscribe(r=>{
      this.listUsers=r;
    })
  }

}
