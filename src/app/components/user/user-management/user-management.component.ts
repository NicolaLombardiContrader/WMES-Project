import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user.service';
import { User } from '../../../models/User';

@Component({
    selector: 'app-user-management',
    templateUrl: './user-management.component.html',
    styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {
    public users: Array<User>;

    constructor(private userService: UserService) { }

    ngOnInit() {
        this.userService.userList().subscribe((response) => {
            this.users = response;
            console.log('La grandezza e\'' + this.users.length);
        });
    }

}
