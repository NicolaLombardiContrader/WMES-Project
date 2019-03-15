import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from '../models/User';
import { Item } from '../models/Item';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class ItemService {

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    itemList(): Observable<Array<Item>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/Item/listItem?userId=' + user.userId)
            .pipe(tap((response) => console.log('Item'), catchError(this.handleError('error', {})))
            );
    }

    itemListByItemType(itemType: string): Observable<Array<Item>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/Item/listItemByItemType?userId=' + user.userId + '&itemType=' + itemType)
            .pipe(tap((response) => console.log('Item'), catchError(this.handleError('error', {})))
            );
    }

}
