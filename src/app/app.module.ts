import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HttpParams,  } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { TestserviceService } from './testservice.service';
import { User } from './user';
// import { InsertComponent } from './insert/insert.component';
// import { UpdateComponent } from './update/update.component';
import { DataComponent } from './data/data.component';
import { LoginComponent } from './login/login.component';
import { Router } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    // InsertComponent,
    //UpdateComponent,
    DataComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TestserviceService,HttpParams],
  bootstrap: [AppComponent]
})
export class AppModule { }
