import { Component, OnInit, EventEmitter } from '@angular/core';
import { SellingService } from '../../services/selling.service';
import { User } from '../../models/user.model';
import { Product } from '../../models/product.model';
import { Selling } from '../../models/selling.model';
import { ClientMessage } from '../../models/client-message.model';
import { UploadService } from '../../services/upload.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-selling',
  templateUrl: './selling.component.html',
  styleUrls: ['./selling.component.css']
})
export class SellingComponent implements OnInit {
  ngOnInit(){
    if(sessionStorage.getItem("loggedUser")==="{}"){
      this.router.navigate(["login"]);
    }
  }
  constructor(private sellingService:SellingService, private uploadService:UploadService, private router:Router) {}
  public user:User=JSON.parse(sessionStorage.getItem("loggedUser"));
  public currentTime: Date;
  public product:Product= new Product(0,"","","");
  public selling:Selling= new Selling(0,0,0,this.user,this.product)
  public clientMessage:ClientMessage = new ClientMessage("");
  public sellingProduct():void{
    if(sessionStorage.getItem("loggedUser")==="{}"){
      this.router.navigate(["login"]);
    }
    else{
      this.sellingService.sellingProduct(this.selling).subscribe(
        data => this.clientMessage = data,
        error => this.clientMessage.message = "Failed to post product. Please contact customer support!@ (888)679-2978"
      );}
      // if(this.clientMessage.message!=="Failed to post product. Please contact customer support!@ (888)679-2978"){
      //   this.router.navigate(["all"]);
      // }
    }

  
  //Uploads image to S3
  public onChange(event){
    let file =event.target.files[0];
    this.product.image = file.name;
    this.uploadService.uploadfile(file);
  }

}
