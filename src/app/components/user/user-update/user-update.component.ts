import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../../../services/user.service';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

    userId: number;
    public updateUser: User;

    public userTypes = [];

    // tslint:disable-next-line:max-line-length
    constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.userId = Number(this.route.snapshot.paramMap.get('userId'));
        console.log('User id in update:' + this.userId);
        this.userService.readUser(this.userId).subscribe((response) => {
            this.updateUser = response;
            console.log('User caricarito: ' + this.updateUser.userUser);
        });

        this.userTypes = ['admin', 'bo'];
    }

    update(f: NgForm) {
        console.log('User id: ' + f.value.userId + ' ' + f.value.userName);
        this.userService.updateUser(this.updateUser);

    }
}
