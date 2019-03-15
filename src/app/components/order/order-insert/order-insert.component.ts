import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../../services/order.service';
import { User } from '../../../models/User';
import { Order } from '../../../models/Order';
import { Client } from '../../../models/Client';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
import { ClientService } from '../../../services/client.service';

@Component({
    selector: 'app-order-insert',
    templateUrl: './order-insert.component.html',
    styleUrls: ['./order-insert.component.css']
})
export class OrderInsertComponent implements OnInit {

    public order: Order;
    public clientsInsert: Array<Client>;
    clientSelected: number;
    constructor(private orderService: OrderService, private clientService: ClientService) {
    }

    ngOnInit() {
        // this.order = new Order(0, null, userInsert, null);

        this.clientService.clientList().subscribe((response) => {
            this.clientsInsert = response;
            console.log('Lista clienti caricarita');
        });

    }

    insertOrder(orderInsertForm) {
        console.log('Id cliente selezionato: ' + orderInsertForm.value.clientSelected);
        console.log('Descrizione inserita: ' + orderInsertForm.value.orderDescription);
        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        const clientInsert: Client = new Client(Number(orderInsertForm.value.clientSelected), null, null, null);
        this.order = new Order(0, orderInsertForm.value.orderDescription, userInsert, clientInsert);
        this.orderService.insertOrder(this.order);
    }

}
