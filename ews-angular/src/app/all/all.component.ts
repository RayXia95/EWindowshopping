import { Component, OnInit, TemplateRef } from '@angular/core';
import { ClientMessage } from '../models/client-message.model';
import { SellingService } from '../services/selling.service';
import { Selling } from '../models/selling.model';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
 
@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {
    title = 'All Products for Sale';
    modalRef: BsModalRef;
    selling: any;

    ngOnInit() {
      this.findAllSelling();
    }

    public sellings: Selling[] = [];

    public clientMessage: ClientMessage = new ClientMessage('No products to display.');

    constructor(private sellingService: SellingService, private modalService: BsModalService) {}
    
    openModal(selling: any, sellingModal: TemplateRef<any>){
      this.selling = selling;
      this.modalRef = this.modalService.show(sellingModal);
    }

    public findAllSelling(): void {
      this.sellingService.findAllProducts()
        .subscribe(
          data => this.sellings = data,
          error => this.clientMessage.message = 'Something went wrong.'
        );
    }
}