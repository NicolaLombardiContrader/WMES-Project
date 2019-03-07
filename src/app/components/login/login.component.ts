import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
/** import { UserService } from '../../services/user.service'; */
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { LoginService } from '../../services/login.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    user: User;

    constructor(private loginService: LoginService, private router: Router) {

    }
    ngOnInit() {
        console.log('arrivato');
    }

    login(f: NgForm): void {
        console.log('mi arrivano username=' + f.value.user_user + ' password= ' + f.value.user_pass);
        this.loginService.login(f.value.user_user, f.value.user_pass).subscribe((response) => {
            if (response != null) {
                this.user = response;
                sessionStorage.setItem('user', JSON.stringify(this.user));
                if (response.usertype === 1) {
                    this.router.navigateByUrl('/homeAdmin');
                } else if (response.usertype === 2) {
                    this.router.navigateByUrl('/homeBO');
                } else if (response.usertype === 3) {
                    this.router.navigateByUrl('/installer');
                }
            }
        });
    }

}
