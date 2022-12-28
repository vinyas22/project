import { Component, Inject, OnInit } from '@angular/core';
import { User } from '../user';
import { TestserviceService } from '../testservice.service';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  implements OnInit{
  user: User;
  users:User[]=[];
  navigate: any;

  
  

  constructor(
    private userserv: TestserviceService, private route:Router) {
      this.user = new User;
  }
  ngOnInit(): void {
  }

 categorydata(user:User){
  console.log('categorydata',user.category);
  this.userserv.findAll(user).subscribe(data => {this.users=data;});

 }
getCategory(){
  console.log('getCategory' ,this.user.category);
 this.categorydata(this.user);
}

  }


