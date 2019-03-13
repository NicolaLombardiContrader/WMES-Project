import { Component, OnInit } from '@angular/core';
import { Client } from '../../../models/Client';
import { ClientService } from '../../../services/client.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { User } from '../../../models/User';
import { Order } from '../../../models/Order';

@Component({
    selector: 'app-client-insert',
    templateUrl: './client-insert.component.html',
    styleUrls: ['./client-insert.component.css']
})
export class ClientInsertComponent implements OnInit {

    public client: Client;
    constructor(private clientService: ClientService, private router: Router) { }

    ngOnInit() {
        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        this.client = new Client(null, null, userInsert, null);
    }
    insertClient(f: NgForm) {
        console.log('Client Id: ' + f.value.clientId + ' ' + f.value.clientName);
        this.clientService.insertClient(this.client);
    }
}
