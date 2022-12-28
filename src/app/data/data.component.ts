import { Component,OnInit } from '@angular/core';
import { TestserviceService } from '../testservice.service';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css']
})
export class DataComponent implements OnInit {
  // users: User[]=[];

  constructor(private userserv:TestserviceService) { }

  ngOnInit(): void {
   
  }

//  nextpage(){
//   if()
//  }
  
}
