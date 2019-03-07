import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaskService } from '../../../services/task.service';
import { Task } from '../../../models/Task';

@Component({
    selector: 'app-task-management',
    templateUrl: './task-management.component.html',
    styleUrls: ['./task-management.component.css']
})
export class TaskManagementComponent implements OnInit {
    public tasks: Array<Task>;

    constructor(private taskService: TaskService, private router: Router) { }

    ngOnInit() {
        this.taskService.taskList().subscribe((response) => {
            this.tasks = response;
            console.log('La grandezza e\'' + this.tasks.length);
        });
    }

    removeLink(taskId: number) {
        /** this.router.navigateByUrl('/delete?taskId=' + taskId); */
        this.taskService.deleteTask(taskId);
        this.router.navigateByUrl('/Task/taskManagement');
    }

    updateLink(taskId: string) {
        this.router.navigateByUrl('/Task/update?taskId=' + taskId);
    }

    insertLink() {
        this.router.navigateByUrl('/Task/insert');
    }
}

