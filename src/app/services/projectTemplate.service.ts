import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../../environments/environment.prod';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { ProjectTemplate } from '../models/ProjectTemplate';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { User } from '../models/User';
import { Task } from '../models/Task';



@Injectable({
    providedIn: 'root'
})
export class ProjectTemplateService {
    feedback: string;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    projectTemplateList(): Observable<Array<ProjectTemplate>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/ProjectTemplate/projectTemplateManagement?userId=' + user.userId)
            .pipe(tap((response) => console.log('ProjectTemplate'), catchError(this.handleError('error', {})))
            );
    }

    insertProjectTemplate(projectTemplate: ProjectTemplate): void {
        this.http.post('http://localhost:8080/ProjectTemplate/insert', projectTemplate).subscribe(() => console.log('ProjectTemplate'));
    }

    readProjectTemplate(projectTemplateId: number): Observable<ProjectTemplate> {
        return this.http.get<any>('http://localhost:8080/ProjectTemplate/read?projectTemplateId=' + projectTemplateId)
            .pipe(tap((response) => console.log('ProjectTemplate'), catchError(this.handleError('error', {})))
            );
    }

    deleteProjectTemplate(projectTemplateId: number) {
        this.http.delete('http://localhost:8080/ProjectTemplate/delete?projectTemplateId=' + projectTemplateId).subscribe(() =>
            console.log('ProjectTemplate deleted'));
    }

    updateProjectTemplate(projectTemplate: ProjectTemplate): void {
        this.http.put('http://localhost:8080/ProjectTemplate/update', projectTemplate).subscribe(() =>
            console.log('ProjectTemplate updated'));
    }




}
