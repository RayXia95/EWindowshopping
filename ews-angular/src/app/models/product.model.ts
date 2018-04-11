export class Product{
    id: number;
    description: string;
    productName: string;
    image: string;

    constructor(id: number, description: string, productName: string, image: string){
        this.id = id;
        this.description = description;
        this.productName = productName;
        this.image = image;
    }
}