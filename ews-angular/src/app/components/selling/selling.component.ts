import { Component, OnInit, EventEmitter } from '@angular/core';
import { SellingService } from '../../services/selling.service';
import { User } from '../../models/user.model';
import { Product } from '../../models/product.model';
import { Selling } from '../../models/selling.model';
import { ClientMessage } from '../../models/client-message.model';
import { UploadService } from '../../services/upload.service';

@Component({
  selector: 'app-selling',
  templateUrl: './selling.component.html',
  styleUrls: ['./selling.component.css']
})
export class SellingComponent {
  constructor(private sellingService:SellingService, private uploadService:UploadService) {}
  public user:User=JSON.parse(sessionStorage.getItem("loggedUser"));
  public currentTime: Date;
  public product:Product= new Product(0,"","","");
  public selling:Selling= new Selling(0,0,0,this.user,this.product)
  public clientMessage:ClientMessage = new ClientMessage("");
  public sellingProduct():void{
    this.sellingService.sellingProduct(this.selling).subscribe(
      data => this.clientMessage = data,
      error => this.clientMessage.message = "something went wrong"
    );

  }
  //Uploads image to S3
  public onChange(event){
    let file =event.target.files[0];
    this.product.image = file.name;
    this.uploadService.uploadfile(file);
  }

}
