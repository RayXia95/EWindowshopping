import { User } from './user.model';
import { Product } from './product.model';
import { Selling } from './selling.model';

export class Purchase {
    id: number;
    time: Date;
    quantity: number;
    buyer: User;
    selling:Selling;

    constructor(id: number, time: Date, quantity: number, buyer: User,selling:Selling){
        this.id = id;
        this.time = time;
        this.quantity = quantity;
        this.buyer = buyer;
        this.selling=selling;
    }
}