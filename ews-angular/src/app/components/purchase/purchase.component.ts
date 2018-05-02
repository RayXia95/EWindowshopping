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
    if(sessionStorage.getItem("loggedUser")==="{}"){
      this.router.navigate(["login"]);
    }
  }
    
  public currentTime: Date;
  public buyer:User=JSON.parse(sessionStorage.getItem("loggedUser"));
  public product:Product= JSON.parse(sessionStorage.getItem(""));
  public selling:Selling= JSON.parse(sessionStorage.getItem("selling"));
  public purchase:Purchase= new Purchase(0,this.currentTime = new Date(),1,this.buyer,this.selling);
  
  public clientMessage:ClientMessage = new ClientMessage("");
 
  public purchaseProduct():void{
       console.log(this.buyer);
      this.purchaseService.purchaseProduct(this.purchase).subscribe(
      data => this.clientMessage = data,
      error => this.clientMessage.message = "something went wrong"
    );
    

  }
}
