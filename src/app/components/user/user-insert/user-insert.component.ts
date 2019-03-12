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
    public user: User;
    constructor(private userService: UserService, private router: Router) { }

    ngOnInit() {

        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        this.user = new User(null, null, null, null, null, null, null, null);
    }
    userInsert(f: NgForm) {
        this.userService.insertUser(this.user);

    }

}
