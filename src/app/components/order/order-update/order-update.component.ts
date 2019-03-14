import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { OrderService } from '../../../services/order.service';
import { Client } from '../../../models/Client';
import { Order } from '../../../models/Order';
import { NgForm } from '@angular/forms';
import { User } from '../../../models/User';
import { ClientService } from '../../../services/client.service';


@Component({
    selector: 'app-order-update',
    templateUrl: './order-update.component.html',
    styleUrls: ['./order-update.component.css']
})
export class OrderUpdateComponent implements OnInit {
    public orderUpdate: Order;
    orderId: number;
    clientName: string;
    orderDescription: string;
    public clientsUpdate: Array<Client>;
    // tslint:disable-next-line:max-line-length
    constructor(private orderService: OrderService, private clientService: ClientService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {

        this.clientService.clientList().subscribe((response) => {
            this.clientsUpdate = response;
            console.log('Lista clienti caricarita');
        });

        /** Convert String to number */
        this.orderId = Number(this.route.snapshot.paramMap.get('orderId'));
        console.log('Order id in update:' + this.orderId);
        this.orderService.readOrder(this.orderId).subscribe((response) => {
            this.orderUpdate = response;
            console.log('Order caricarito: ' + this.orderUpdate.orderId);
        });

    }

    update(f: NgForm) {
        console.log(f.value);
        const userUpdate: User = JSON.parse(sessionStorage.getItem('user'));
        this.orderUpdate.userDTO = userUpdate;
        this.orderService.updateOrder(this.orderUpdate);
    }

}
