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
    public userService: UserService;
    public user: User;

    // tslint:disable-next-line:max-line-length
    constructor(private resourceService: UserService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.userId = Number(this.route.snapshot.paramMap.get('userId'));
        console.log('User id in update:' + this.userId);
        this.userService.readUser(this.userId).subscribe((response) => {
            this.user = response;
            console.log('User caricarito: ' + this.user.userUser);
        });

        this.userService.userList().subscribe((response) => {
            console.log('Lista caricarita');
        });
    }

    update(f: NgForm) {
        console.log(f.value);
        console.log('User id: ' + f.value.userId + ' ' + f.value.userName);
        const updateUser: User = new User(f.value.userId, f.value.userUser, f.value.userPass, f.value.userType, null, null, null, null);
        this.userService.updateUser(updateUser);

    }
}
