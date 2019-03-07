import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Order } from '../models/Order';
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


    changeFeedback(message: string) {
        this.feedback = message;
    }

    deleteFeedback() {
        this.feedback = '';
    }

}




