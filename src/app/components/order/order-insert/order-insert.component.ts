import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../../services/order.service';
import { User } from '../../../models/User';
import { Order } from '../../../models/Order';
import { Client } from '../../../models/Client';
import { NgForm } from '@angular/forms';
import { ClientService } from '../../../services/client.service';

@Component({
    selector: 'app-order-insert',
    templateUrl: './order-insert.component.html',
    styleUrls: ['./order-insert.component.css']
})
export class OrderInsertComponent implements OnInit {

    public order: Order;

    public clientsInsert: Array<Client>;
    constructor(private orderService: OrderService, private clientService: ClientService) { }

    ngOnInit() {
        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));

        /*COVERTER ENTITY->DTO ?? (UserDTO)*/
        this.order = new Order(0, null, userInsert, null);

        this.clientService.clientList().subscribe((response) => {
            this.clientsInsert = response;
            console.log('Lista clienti caricarita');
        });

        this.order.clientDTO = this.clientsInsert[0];
    }

    insertOrder(f: NgForm) {
        console.log('Order id: ' + f.value.orderId + ' ' + f.value.orderDescription);
        this.orderService.insertOrder(this.order);
    }

}
