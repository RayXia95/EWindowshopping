import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule }  from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { ModalModule } from 'ngx-bootstrap/modal'; 

import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { HttpClientModule } from '@angular/common/http';
import { SellingComponent } from './components/selling/selling.component';
import { SellingService } from './services/selling.service';
import { ImageUploadModule } from "angular2-image-upload";
import { UploadService } from './services/upload.service';
import { PurchaseComponent } from './components/purchase/purchase.component';
import { PurchaseService } from './services/purchase.service';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    SellingComponent,
    PurchaseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ImageUploadModule.forRoot(),
  ],
  providers: [LoginService, SellingService, UploadService,PurchaseService],
    //ModalModule.forRoot(),
  bootstrap: [AppComponent]
})
export class AppModule { }
