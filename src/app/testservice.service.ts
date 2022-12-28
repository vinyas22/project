import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient, HttpParams,  } from '@angular/common/http';
import { Observable } from 'rxjs';
import { query } from '@angular/animations';

@Injectable({providedIn: 'root'})
export class TestserviceService {
  
  private Userslsturl:string;

  constructor(private http:HttpClient , httpparams : HttpParams) {
    this.Userslsturl='http://localhost:8091/getdoctcat';
  
   }
   
   findAll(user:User){
    console.log(this.Userslsturl);
    let params = new HttpParams();
    params=params.append("category",user.category);
    return this.http.get<User[]>(this.Userslsturl,{params:params});
 
    }
   
    // saveuser(user:User){
    //   return this.http.get<User>(this.Userslsturl,{params:user.category});
    //  }

 
  }

