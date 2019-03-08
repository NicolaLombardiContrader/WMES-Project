import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../models/Client';


@Component({
  selector: 'app-client-management',
  templateUrl: './client-management.component.html',
  styleUrls: ['./client-management.component.css']
})
export class ClientManagementComponent implements OnInit {

        public clients: Array<Client>;

  constructor(private clientService: ClientService, private router: Router) { }

  ngOnInit() {
      this.clientService.clientList().subscribe((response) => {
          this.clients = response;
          console.log('La grandezza e\'' + this.clients.length);
      });
  }

    removeLink(clientId: number) {
        this.clientService.deleteClient(clientId);
     /**   this.router.navigateByUrl('/Client/clientManagement'); */
    }
    updateLink(clientId: number) {
        this.router.navigateByUrl('/Client/update/' + clientId);
    }

    insertLink() {
        this.router.navigateByUrl('/Client/insert');
    }
}
