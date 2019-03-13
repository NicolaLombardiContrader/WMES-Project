import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { OrderService } from '../../../services/order.service';
import { Client } from '../../../models/Client';
import { Order } from '../../../models/Order';
import { NgForm } from '@angular/forms';
import { User } from '../../../models/User';


@Component({
  selector: 'app-order-update',
  templateUrl: './order-update.component.html',
  styleUrls: ['./order-update.component.css']
})
export class OrderUpdateComponent implements OnInit {
    orderId: number;
    clientName: string;
    orderDescription: string;
    public order: Order;

    // tslint:disable-next-line:max-line-length
    constructor(private orderService: OrderService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.orderId = Number(this.route.snapshot.paramMap.get('orderId'));
        console.log('Order id in update:' + this.orderId);
        this.orderService.readOrder(this.orderId).subscribe((response) => {
            this.order = response;
            console.log('Order caricarito: ' + this.order.orderId);
        });
    }

    update(f: NgForm) {
        console.log(f.value);
        const userUpdate: User = JSON.parse(sessionStorage.getItem('user'));
        this.order.userDTO = userUpdate;
        this.orderService.updateOrder(this.order);
    }

}
