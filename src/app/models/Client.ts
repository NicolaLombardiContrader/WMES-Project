import { User } from './User';
import { Order } from './Order';
export class Client {
    clientId: number;
    clientName: string;
    userDTO: User;
    ordersDTO: Order[];


    constructor(clientId: number, clientName: string, userDTO: User, ordersDTO: Order[]) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.userDTO = userDTO;
        this.ordersDTO = ordersDTO;
    }
}
