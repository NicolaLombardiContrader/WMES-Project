import { User } from './User';
import { Order } from './Order';
export class Client {
    clientId: number;
    clientName: string;
    user: User;
    orders: Order [];


    constructor(clientId: number, clientName: string, user: User,  orders: Order [] ) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.user = user;
        this.orders = orders;

    }

}
