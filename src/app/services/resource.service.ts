import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Resource } from '../models/Resource';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { User } from '../models/User';




@Injectable({
    providedIn: 'root'
})
export class ResourceService {
    feedback: string;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    resourceList(): Observable<Array<Resource>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/Resource/resourceManagement?userId=' + user.userId)
            .pipe(tap((response) => console.log('Resource'), catchError(this.handleError('error', {})))
            );
    }

}




