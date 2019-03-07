import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../../../services/user.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-user-insert',
    templateUrl: './user-insert.component.html',
    styleUrls: ['./user-insert.component.css']
})
export class UserInsertComponent implements OnInit {

    constructor(private userService: UserService, private router: Router) { }

    ngOnInit() {
    }
    userInsert(f: NgForm): void {

    }

}
