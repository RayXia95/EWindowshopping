import { Component, OnInit, TemplateRef } from '@angular/core';
import { ClientMessage } from '../models/client-message.model';
import { SellingService } from '../services/selling.service';
import { Selling } from '../models/selling.model';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { IMAGE } from '../../environments/environment';
import { User } from '../models/user.model';
import { Purchase } from '../models/purchase.model';
import { PurchaseService } from '../services/purchase.service';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {
    title = 'All Products for Sale';
    image = `${IMAGE}`
    modalRef: BsModalRef;
    selling: any;

    ngOnInit() {
      this.findAllSelling();
    }

    public sellings: Selling[] = [];

    public clientMessage: ClientMessage = new ClientMessage('No products to display.');

    constructor(private sellingService: SellingService, private modalService: BsModalService, private purchaseService: PurchaseService, private router:Router) {}
    
    openModal(selling: any, sellingModal: TemplateRef<any>){
      this.selling = selling;
      sessionStorage.setItem("buyProduct",JSON.stringify(this.selling));
      this.modalRef = this.modalService.show(sellingModal);
    }

    public findAllSelling(): void {
      this.sellingService.findAllProducts()
        .subscribe(
          data => this.sellings = data,
          error => this.clientMessage.message = 'Something went wrong.'
        );
    }
    public currentTime: Date;
  public buyer:User=JSON.parse(sessionStorage.getItem("loggedUser"));
  //public product:Product= JSON.parse(sessionStorage.getItem(""));
  public sell:Selling= JSON.parse(sessionStorage.getItem("buyProduct"));
  public purchase:Purchase= new Purchase(0,this.currentTime = new Date(),2,this.buyer,this.sell);
  
  public clientMessage2:ClientMessage = new ClientMessage("");
  public clientMessage3:ClientMessage = new ClientMessage("");
 
  public purchaseProduct():void{
    if(sessionStorage.getItem("loggedUser")!=="{}"){
            this.purchaseService.purchaseProduct(this.purchase).subscribe(
      data => this.clientMessage2 = data,
      error => this.clientMessage2.message = "something went wrong");

    }
    else{
    this.router.navigate(["login"]);
    this.clientMessage2.message="Unable to purchase please close this window!";
    }
    }
}