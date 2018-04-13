import { Component } from '@angular/core';
import { PurchaseService } from '../../service/purchase.service';
import { User } from '../../models/user.model';
import { Product } from '../../models/product.model';
import { Purchase } from '../../models/purchase.model';
import { ClientMessage } from '../../models/client-message.model';
import { timestamp } from 'rxjs/operators';

@Component({
  selector: 'app-purchase',
    templateUrl: './purchase.component.html',
    styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent{

  constructor(private purchaseService:PurchaseService) {}
  public user:User= new User(  0,
    "jdoe",
 "jdoe@gmail.com",
 "John",
  "Doe",
"hashed",
0,
 "12 Main St.",
 "Princeton",
"NJ",
"08540");

public currentTime: Date;
  public product:Product= new Product(0,"this is an iphone","iphone","iphone-x-silver-select-2017.jpeg");
  public purchase:Purchase= new Purchase(0,this.currentTime = new Date(),0,this.user,this.product)
  public clientMessage:ClientMessage = new ClientMessage("");
 
  public purchaseProduct():void{
 
    this.purchaseService.purchaseProduct(this.purchase).subscribe(
      data => this.clientMessage = data,
      error => this.clientMessage.message = "something went wrong"
    );

  }
}
