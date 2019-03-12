import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../../services/task.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Task } from '../../../models/Task';
import { NgForm } from '@angular/forms';
import { Resource } from '../../../models/Resource';
import { ResourceService } from '../../../services/resource.service';
import { User } from '../../../models/User';

@Component({
    selector: 'app-task-update',
    templateUrl: './task-update.component.html',
    styleUrls: ['./task-update.component.css']
})
export class TaskUpdateComponent implements OnInit {

    taskId: number;
    public task: Task;
    public resources: Array<Resource>;
    // tslint:disable-next-line:max-line-length
    constructor(private taskService: TaskService, private resourceService: ResourceService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.taskId = Number(this.route.snapshot.paramMap.get('taskId'));
        console.log('Task id in update:' + this.taskId);
        this.taskService.readTask(this.taskId).subscribe((response) => {
            this.task = response;
            console.log('Task caricarito: ' + this.task.taskDescription);
        });

        this.resourceService.resourceList().subscribe((response) => {
            this.resources = response;
            console.log('Lista caricarita');
        });
    }

    update(f: NgForm) {
        console.log(f.value);
        console.log('Task id: ' + f.value.taskId + ' ' + f.value.taskAction + ' ' + f.value.taskDescription);
        const userUpdate: User = JSON.parse(sessionStorage.getItem('user'));
        // tslint:disable-next-line:max-line-length
        const updateTask: Task = new Task(f.value.taskId, f.value.taskAction, f.value.taskDescription,
            f.value.taskInput, f.value.taskOutput, f.value.taskState, f.value.taskTime, userUpdate,
            f.value.resourceDTO);
    }

}
