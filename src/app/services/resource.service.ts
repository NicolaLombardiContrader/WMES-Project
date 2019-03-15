import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Resource } from '../models/Resource';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { User } from '../models/User';
import { Task } from '../models/Task';




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


    // tslint:disable-next-line:max-line-length
    insertResource(resource: Resource): void {
        this.http.post('http://localhost:8080/Resource/insert', resource).subscribe(() => console.log('Resource inserted'));
    }

    readResource(resourceId: number): Observable<Resource> {
        return this.http.get<any>('http://localhost:8080/Resource/read?resourceId=' + resourceId)
            .pipe(tap((response) => console.log('Resource'), catchError(this.handleError('error', {})))
            );
    }

    deleteResource(resourceId: number) {
        // this.http.get<any>('http://localhost:8080/Resource/delete?resourceId=' + resourceId)
        //    .pipe(tap((response) => console.log('Resource'), catchError(this.handleError('delete Resource error', {}))));
        this.http.delete('http://localhost:8080/Resource/delete?resourceId=' + resourceId).subscribe(() => console.log('Resource deleted'));
    }

    updateResource(resource: Resource): void {
        this.http.put('http://localhost:8080/Resource/update', resource).subscribe(() => console.log('Resource updated'));
    }



}




