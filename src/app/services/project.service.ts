import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Project } from '../models/Project';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { User } from '../models/User';
import { Task } from '../models/Task';



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

    insertProject(projectId: number, projectName: string, projectStatus: number,  user: User, task: Task[]): Observable<Project> {

        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        const newProject = new Project(0, projectName, projectStatus, user, task);
        return this.http.post<Project>('http://localhost:8080/Project/insert', newProject)
        .pipe(tap((response) => console.log('insertProject'), catchError(this.handleError('insertProject error', {})))
        );
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

}


