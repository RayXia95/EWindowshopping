import { User } from './user.model';
import { Product } from './product.model';

export class Selling {
    id: number;
    cost: number;
    quantity: number;
    seller: User;
    product: Product;

    constructor(id: number, cost: number, quantity: number, seller: User, product: Product){
        this.id = id;
        this.cost = cost;
        this.quantity = quantity;
        this.seller = seller;
        this.product = product;
    }
}