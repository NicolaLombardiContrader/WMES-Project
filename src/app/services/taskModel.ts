import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TaskModel } from '../models/TaskModel';
import { User } from '../models/User';
import { tap, catchError } from 'rxjs/operators';





@Injectable({
    providedIn: 'root'
})
export class TaskModelService {
    feedback: string;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    taskModelList(): Observable<Array<TaskModel>> {
        const user: User = JSON.parse(sessionStorage.getItem('user'));
        return this.http.get<any>('http://localhost:8080/TaskModel/taskModelManagement?userId=' + user.userId)
            .pipe(tap((response) => console.log('TaskModel'), catchError(this.handleError('error', {})))
            );
    }


    // tslint:disable-next-line:max-line-length
   insertTaskModel(taskModel: TaskModel): void {
        this.http.post('http://localhost:8080/TaskModel/insert', taskModel).subscribe(() => console.log('Task Model inserted'));
    }

    readTask(taskModelId: number): Observable<TaskModel> {
        return this.http.get<any>('http://localhost:8080/TaskModel/read?taskModelId=' + taskModelId)
            .pipe(tap((response) => console.log('TaskModel'), catchError(this.handleError('error', {})))
            );
    }

    deleteTaskModel(taskModelId: number) {

        this.http.delete('http://localhost:8080/TaskModel/delete?taskModelId=' + taskModelId).subscribe(() =>
        console.log('Task Model deleted'));
    }

    updateTaskModel(taskModel: TaskModel): void {
        this.http.put('http://localhost:8080/TaskModel/update', taskModel).subscribe(() => console.log('Task Model updated'));
    }

}



