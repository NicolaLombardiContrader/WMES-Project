import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../../services/order.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../../models/User';
import { Order } from '../../../models/Order';
import { Client } from '../../../models/Client';
import { NgForm } from '@angular/forms';

@Component({
    selector: 'app-order-insert',
    templateUrl: './order-insert.component.html',
    styleUrls: ['./order-insert.component.css']
})
export class OrderInsertComponent implements OnInit {

    public order: Order;
    constructor(private orderService: OrderService, private router: Router) { }

    ngOnInit() {
        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        
        /*COVERTER ENTITY->DTO ?? (UserDTO)*/
        this.order = new Order(null, null, userInsert, null);
    }

    insertOrder(f: NgForm) {
        console.log('Order id: ' + f.value.orderId + ' ' + f.value.orderDescription);
        this.orderService.insertOrder(this.order);
    }

}
