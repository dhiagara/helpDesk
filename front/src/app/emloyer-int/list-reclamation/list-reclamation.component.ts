import { Component, OnInit } from '@angular/core';
import { AddUserService } from 'src/app/services/add-user.service';

@Component({
  selector: 'app-list-reclamation',
  templateUrl: './list-reclamation.component.html',
  styleUrls: ['./list-reclamation.component.css']
})
export class ListReclamationComponent implements OnInit {

  listReclamation ; 
  constructor( private svc:AddUserService) { }

  ngOnInit() {
    this.svc.findReclamationByUser(2).subscribe(r=>{
      this.listReclamation=r;
    })
  }

}
