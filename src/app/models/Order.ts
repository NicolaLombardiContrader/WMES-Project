import { User } from './User';
import { Client } from './Client';
export class Order {
    orderId: number;
    orderDescription: string;
    userDTO: User;
    clientDTO: Client;



    constructor(orderId: number, orderDescription: string, userDTO: User, clientDTO: Client) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.userDTO = userDTO;
        this.clientDTO = clientDTO;

    }

}
