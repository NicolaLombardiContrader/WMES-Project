import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { User } from '../../../models/User';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../models/Client';


@Component({
  selector: 'app-client-update',
  templateUrl: './client-update.component.html',
  styleUrls: ['./client-update.component.css']
})
export class ClientUpdateComponent implements OnInit {

    clientId: number;
    clientName: string;
    public client: Client;

  constructor(private clientService: ClientService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
      this.clientId = Number(this.route.snapshot.paramMap.get('clientId'));
      console.log('Resource id in update:' + this.clientId);
      this.clientService.readClient(this.clientId).subscribe((response) => {
          this.client = response;
          console.log('Client caricato: ' + this.client.clientName);
      });
    }

   update(f: NgForm) {
        console.log(f.value);
        const userUpdate: User = JSON.parse(sessionStorage.getItem('user'));
        this.client.userDTO = userUpdate;
        this.clientService.updateClient(this.client);
     //   this.router.navigateByUrl('/Client/clientManagement');
    }

}
