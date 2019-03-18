import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Project } from '../models/Project';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { User } from '../models/User';
import { Task } from '../models/Task';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { TaskService } from './task.service';



@Injectable({
    providedIn: 'root'
})
export class ProjectService {
    feedback: string;

    constructor(private http: HttpClient) { }

    
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    projectList(): Observable<Array<Project>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/Project/projectManagement?userId=' + user.userId)
            .pipe(tap((response) => console.log('Project'), catchError(this.handleError('error', {})))
            );
    }

    insertProject(project: Project): void {
        this.http.post('http://localhost:8080/Project/insert', project).subscribe(() => console.log('Project inserted'));
    }

    readProject(projectId: number): Observable<Project> {
        return this.http.get<any>('http://localhost:8080/Project/read?projectId=' + projectId)
            .pipe(tap((response) => console.log('Project'), catchError(this.handleError('error', {})))
            );
    }

    deleteProject(projectId: number) {

        this.http.delete('http://localhost:8080/Project/delete?projectId=' + projectId).subscribe(() => console.log('Project deleted'));
    }

    updateProject(project: Project): void {
        this.http.put('http://localhost:8080/Project/update', project).subscribe(() => console.log('Project updated'));
    }

    // Tree methods
    insertTaskNode(projectId: string, taskModelId: string, taskFatherId: string) {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        console.log('Project Id: ' + projectId);
        console.log('userId: ' + String(user.userId));
        console.log('taskModelId: ' + taskModelId);
        console.log('taskFatherId: ' + taskFatherId);
        const params: HttpParams = new HttpParams()
            .set('userId', String(user.userId))
            .set('projectId', projectId)
            .set('taskModelId', taskModelId)
            .set('taskFatherId', taskFatherId);
        console.log('Params: ' + params);
        this.http.post('http://localhost:8080/Project/insertTaskNode', params).subscribe(() => console.log('Task Node inserted'));
    }

    findRootNode(projectId: string): Observable<Task> {
            return  this.http.get<any>('http://localhost:8080/Project/findRootNode?projectId=' + projectId)
            .pipe(tap((response) => console.log('Project'), catchError(this.handleError('error', {})))
            );
    }

    deleteTaskNode(taskId: number): void {
        this.http.delete('http://localhost:8080/Task/delete?taskId=' + taskId).subscribe(() => console.log('Task deleted'));
    }

}


