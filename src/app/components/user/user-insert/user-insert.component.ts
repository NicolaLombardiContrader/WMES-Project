import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../../../services/user.service';
import { Router } from '@angular/router';
import { User } from '../../../models/User';

@Component({
    selector: 'app-user-insert',
    templateUrl: './user-insert.component.html',
    styleUrls: ['./user-insert.component.css']
})
export class UserInsertComponent implements OnInit {
    public insertUser: User;

    public userTypes = [];
    constructor(private userService: UserService, private router: Router) { }

    ngOnInit() {
        this.insertUser = new User(0, null, null, 'admin', null, null, null, null);
        this.userTypes = ['admin', 'bo'];
    }
    userInsert(f: NgForm) {
        this.userService.insertUser(this.insertUser);
    }

}
