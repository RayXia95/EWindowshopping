import { Component, OnInit } from '@angular/core';
import { PurchaseService } from '../../services/purchase.service';
import { User } from '../../models/user.model';
import { Product } from '../../models/product.model';
import { Purchase } from '../../models/purchase.model';
import { ClientMessage } from '../../models/client-message.model';
import { timestamp } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Selling } from '../../models/selling.model';

@Component({
  selector: 'app-purchase',
    templateUrl: './purchase.component.html',
    styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit{
  constructor(private purchaseService:PurchaseService, private router:Router) {}
  ngOnInit(){
    if(sessionStorage.getItem("loggedUser")===""){
      this.router.navigate(["login"]);
    }
  }
    
public product2:Product = new Product(0,"this is an email test","Email","image.com");
  public currentTime: Date;
  public buyer:User=JSON.parse(sessionStorage.getItem("loggedUser"));
  public seller:User = new User(0,"JoelD","whatever@gmail.com","joe","de","meh",0,"street","ef","ny","12023");
  public product:Product= JSON.parse(sessionStorage.getItem(""));
  public selling:Selling= new Selling(0,400,1,this.seller,this.product2);
  public purchase:Purchase= new Purchase(0,this.currentTime = new Date(),2,this.buyer,this.selling);
  
  public clientMessage:ClientMessage = new ClientMessage("");
 
  public purchaseProduct():void{
       this.buyer.email="joeldejesus95@gmail.com";
       console.log(this.buyer);
      // this.selling.seller=this.seller;
      // this.product=JSON.parse(sessionStorage.getItem("product"));
      this.purchaseService.purchaseProduct(this.purchase).subscribe(
      data => this.clientMessage = data,
      error => this.clientMessage.message = "something went wrong"
    );
    

  }
}
