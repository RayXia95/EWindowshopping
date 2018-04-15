import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule }  from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { HttpClientModule } from '@angular/common/http';
import { PurchaseComponent } from './components/purchase/purchase.component';
import { PurchaseService } from './services/purchase.service';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    PurchaseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [LoginService,PurchaseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
