import { Component, OnInit } from '@angular/core';
import { ClientMessage } from '../models/client-message.model';
import { SellingService } from '../services/selling.service';
import { Selling } from '../models/selling.model';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {
    title = 'All Products for Sale';

    ngOnInit() {
      this.findAllSelling();
    }

    public sellings: Selling[] = [];

    public clientMessage: ClientMessage = new ClientMessage('No products to display.');

    constructor(private sellingService: SellingService) {}

    public findAllSelling(): void {
      this.sellingService.findAllProducts()
        .subscribe(
          data => this.sellings = data,
          error => this.clientMessage.message = 'Something went wrong.'
        );
    }
}