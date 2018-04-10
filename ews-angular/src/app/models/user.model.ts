export class User {
    id: number;
    username: string;
    email: string;
    firstName: string;
    lastName: string;
    password: string;
    balance: number;
    street: string;
    town: string;
    state: string;
    zipCode: string;

    constructor(id: number, username: string, email: string,
                firstName: string, lastName: string, password: string, balance: number,
                street: string, town: string, state: string, zipCode: string) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.balance = balance;
        this.street = street;
        this.town = town;
        this.state = state;
        this.zipCode = zipCode;
    }
}