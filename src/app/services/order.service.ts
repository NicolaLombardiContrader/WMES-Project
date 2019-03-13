import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Observable, of, BehaviorSubject } from 'rxjs';
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
    insertOrder(order: Order): void {
         this.http.post('http://localhost:8080/Order/insert', order).subscribe(() => console.log('Order inserted'));
    }

   readOrder(orderId: number): Observable<Order> {
        return this.http.get<any>('http://localhost:8080/Order/read?orderId=' + orderId)
            .pipe(tap((response) => console.log('Order'), catchError(this.handleError('error', {})))
            );
    }

    deleteOrder(orderId: number) {
        this.http.delete('http://localhost:8080/Order/delete?orderId=' + orderId).subscribe(() => console.log('Order deleted'));
    }

    updateOrder(order: Order): void {
        this.http.put('http://localhost:8080/Order/update', order).subscribe(() => console.log('Order updated'));
    }


}
