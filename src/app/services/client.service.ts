import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/Client';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { User } from '../models/User';
import { Order } from '../models/Order';



@Injectable({
    providedIn: 'root'
})
export class ClientService {
    feedback: string;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    clientList(): Observable<Array<Client>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/Client/clientManagement?userId=' + user.userId)
            .pipe(tap((response) => console.log('Client'), catchError(this.handleError('error', {})))
            );
    }

 //   insertClient(clientId: number, user: User, clientName: string, order: Order[]): Observable<Client> {
 //       const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
//        const newClient = new Client(0, user, clientName, order);
 //       return this.http.post<Client>('http://localhost:8080/Client/insert', newClient)
 //           .pipe(tap((response) => console.log('insertClient'), catchError(this.handleError('insertClient error', {})))
 //
 //   }

    readClient(clientId: number): Observable<Client> {
        return this.http.get<any>('http://localhost:8080/Client/read?clientId=' + clientId)
            .pipe(tap((response) => console.log('Task'), catchError(this.handleError('error', {})))
            );
    }

    deleteClient(clientId: number) {
       this.http.delete('http://localhost:8080/Client/delete?clientId=' + clientId).subscribe(() =>  console.log('Client delete'));
    }

        updateClient(client: Client) {
        this.http.put('http://localhost:8080/Client/update', client).subscribe(() => console.log('Client update'));
    }
}




