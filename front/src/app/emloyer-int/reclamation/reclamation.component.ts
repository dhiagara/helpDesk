import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AddUserService } from 'src/app/services/add-user.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-reclamation',
  templateUrl: './reclamation.component.html',
  styleUrls: ['./reclamation.component.css']
})
export class ReclamationComponent implements OnInit {

  constructor(private fb: FormBuilder,private addUserSrv:AddUserService,private authServ:AuthService) { }
  addUser = this.fb.group({
    service: ['',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
    etat: ['',],
    contenue: [''],
   

   
  });

  blog=null;
  imgURL: any=[];
  userFile :any=[] ;
  public message: string;
  public imagePath;
  ngOnInit() {
    this.authServ.getUserInfo().subscribe(r=>{
      
    })
  }
  onSelectFile(event) {
    
    if (event.target.files.length > 0)
    {
      console.log(event.target.files);
      const files = event.target.files ; 
      [...files].forEach(file => {
        
      
      
      this.userFile.push(file) ;
     // this.f['profile'].setValue(file);
 
    var mimeType = file.type;
    if (mimeType.match(/image\/*/) == null) {
      this.message = "Only images are supported.";
      return;
    }
 
    var reader = new FileReader();
    
    this.imagePath = file;
    reader.readAsDataURL(file); 
    reader.onload = (_event) => { 
      this.imgURL.push(reader.result)  ; 
    }
  });
  }}
  onSubmit(blog){
    console.log(this.addUser.value);
    console.log("first",this.userFile)
    const user ={id:2}
    const data={...this.addUser.value,user}
    const formData = new  FormData();

    formData.append('reclamation',JSON.stringify(data));
    
    this.userFile.forEach((element,i) => {
      formData.append('file[]',element);
    });
  
    console.log(formData.get("blog"));
    
    console.log('file[] : ',formData.get("file[]"));
    this.addUserSrv.addReclamation(formData).subscribe((r)=>{
      console.log(r);
      this.ngOnInit();
          })
  
    


  }
  logout(){
    this.authServ.doLogoutUser();
  }

}
