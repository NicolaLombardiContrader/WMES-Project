import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Task } from '../models/Task';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { Resource } from '../models/Resource';
import { Project } from '../models/Project';
import { ProjectTemplate } from '../models/ProjectTemplate';
import { User } from '../models/User';
import { Order } from '../models/Order';
import { Client } from '../models/Client';

@Injectable({
    providedIn: 'root'
})
export class OrderService {
    feedback: string;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    orderList(): Observable<Array<Order>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/Order/orderManagement?userId=' + user.userId)
            .pipe(tap((response) => console.log('Order'), catchError(this.handleError('error', {})))
            );
    }


    // tslint:disable-next-line:max-line-length
    insertOrder(orderId: number, orderDescription: string , user: User, client: Client): Observable<Order> {
        // tslint:disable-next-line:prefer-const
        // tslint:disable-next-line:max-line-length
        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        const resourceInsert: Resource = JSON.parse(sessionStorage.getItem('resource'));
        // tslint:disable-next-line:max-line-length
        const newOrder = new Order(0, orderDescription, user, client);
        return this.http.post<Order>('http://localhost:8080/Order/insert', newOrder)
            .pipe(tap((response) => console.log('insertOrder'), catchError(this.handleError('insertOrder error', {})))
            );
    }

    deleteOrder(orderId: number) {
        // this.http.get<any>('http://localhost:8080/Order/delete?orderId=' + orderId)
        //    .pipe(tap((response) => console.log('Order'), catchError(this.handleError('delete Order error', {}))));
       this.http.get('http://localhost:8080/Order/delete?orderId=' + orderId);
    }

}
