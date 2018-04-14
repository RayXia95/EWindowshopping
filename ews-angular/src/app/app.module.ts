import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule }  from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { HttpClientModule } from '@angular/common/http';
import { SellingComponent } from './components/selling/selling.component';
import { SellingService } from './services/selling.service';
import { ImageUploadModule } from "angular2-image-upload";
import { UploadService } from './services/upload.service';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    SellingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ImageUploadModule.forRoot(),
  ],
  providers: [LoginService, SellingService, UploadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
