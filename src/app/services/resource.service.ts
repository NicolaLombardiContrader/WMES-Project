import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Resource } from '../models/Resource';
import { Observable, of, BehaviorSubject } from 'rxjs';




@Injectable({
    providedIn: 'root'
})
export class UserService {
    feedback: string;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    login(username: string, password: string): Observable<Resource> {
        return this.http.get<Resource>('http://localhost:58708/api/login?username=' + username + '&password=' + password)
            .pipe(tap((response) => console.log('Resource'), catchError(this.handleError('login error', {})))
            );
    }

    signup(resource: Resource): Observable<boolean> {
        return this.http.post<boolean>('http://localhost:58708/api/signupUser', resource)
            .pipe(tap((response) => console.log('Resource'), catchError(this.handleError('login error', {})))
            );
    }

    changeFeedback(message: string) {
        this.feedback = message;
    }

    deleteFeedback() {
        this.feedback = '';
    }

}




