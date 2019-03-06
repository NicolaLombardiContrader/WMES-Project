import { User } from './User';
import { Client } from './Client';
export class Order {
    orderId: number;
    orderDescription: string;
    user: User;
    client: Client;



    constructor(orderId: number, orderDescription: string, user: User, client: Client) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.user = user;
        this.client = client;

    }

}
