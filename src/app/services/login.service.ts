import { Injectable } from '@angular/core';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable, of } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService {

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    login(username: string, password: string): Observable<User> {
        return this.http.get<User>('http://localhost:8080/User/login?username=' + username + '&password=' + password)
            .pipe(tap((response) => console.log('User'), catchError(this.handleError('login error', {})))
            );
    }

    logOut() {
        if (typeof (Storage) !== 'undefined') {
            sessionStorage.removeItem('user');
        }
    }
}
