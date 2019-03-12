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


@Injectable({
    providedIn: 'root'
})
export class TaskService {
    feedback: string;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    taskList(): Observable<Array<Task>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/Task/taskManagement?userId=' + user.userId)
            .pipe(tap((response) => console.log('Task'), catchError(this.handleError('error', {})))
            );
    }


    // tslint:disable-next-line:max-line-length
   insertTask(task: Task): void {
        this.http.post('http://localhost:8080/Resource/insert', task).subscribe(() => console.log('Task inserted'));
    }

    readTask(taskId: number): Observable<Task> {
        return this.http.get<any>('http://localhost:8080/Task/read?taskId=' + taskId)
            .pipe(tap((response) => console.log('Task'), catchError(this.handleError('error', {})))
            );
    }

    deleteTask(taskId: number) {

        this.http.delete('http://localhost:8080/Task/delete?taskId=' + taskId).subscribe(() => console.log('Task deleted'));
    }

    updateTask(task: Task): void {
        this.http.put('http://localhost:8080/Task/update', task).subscribe(() => console.log('Task updated'));
    }

}







