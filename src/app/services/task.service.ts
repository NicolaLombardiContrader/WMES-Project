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
    taskList(): Observable<any> {
        return this.http.get<any>('http://localhost:8080/task/taskManagement')
            .pipe(tap((response) => console.log('Task'), catchError(this.handleError('error', {})))
            );
    }


    // tslint:disable-next-line:max-line-length
    insertTask(taskId: number, taskAction: string, taskDescription: string, taskInput: string, taskOutput: string, taskTime: number, taskState: number, user: User, resoruce: Resource, project: Project[], projectTemplate: ProjectTemplate[]): Observable<Task> {
        // tslint:disable-next-line:prefer-const
        // tslint:disable-next-line:max-line-length
        const newTask = new Task(0, taskAction, taskDescription, taskInput, taskOutput, taskTime, taskState, user, resoruce, project, projectTemplate);
        return this.http.post<Task>('http://localhost:8080/task/insert', newTask)
            .pipe(tap((response) => console.log('insertTask'), catchError(this.handleError('insertTask error', {})))
            );
    }

    deleteTask(idDelete: number): Observable<any> {
        return this.http.get<any>('http://localhost:8080/task/delete?id=' + idDelete)
            .pipe(tap((response) => console.log('deleteTask'), catchError(this.handleError('deleteTask error', {})))
            );
    }

}







