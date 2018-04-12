import { Component } from '@angular/core';
import { PurchaseService } from '../../service/purchase.service';
import { User } from '../../models/user.model'; 
import { ClientMessage } from '../../models/client-message.model'; 
import { Product } from '../../models/product.model';
import { Purchase } from '../../models/purchase.model';


@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class purchaseComponent{

  constructor(private purchaseService:PurchaseService) {}
 public user:User= new User(0,"","","","","",0,"","","","");
 public product:Product= new Product(0,"","","");
 public purchase:Purchase= new Purchase(0,null,0,this.user,this.product)
 public clientMessage:ClientMessage = new ClientMessage("");

 public purchaseProduct():void{
   this.purchaseService.purchaseProduct(this.purchase).subscribe(
     data => this.clientMessage = data,
     error => this.clientMessage.message = "something went wrong"
   );
 }



}
