import { User } from './user.model';
import { Product } from './product.model';

export class Purchase {
    id: number;
    time: Date;
    quantity: number;
    buyer: User;
    product: Product;

    constructor(id: number, time: Date, quantity: number, buyer: User, product: Product){
        this.id = id;
        this.time = time;
        this.quantity = quantity;
        this.buyer = buyer;
        this.product = product;
    }
}