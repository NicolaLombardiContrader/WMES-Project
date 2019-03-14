import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../../services/task.service';
import { Router } from '@angular/router';
import { Task } from '../../../models/Task';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';
import { Resource } from '../../../models/Resource';
import { ResourceService } from '../../../services/resource.service';

@Component({

    selector: 'app-task-insert',
    templateUrl: './task-insert.component.html',
    styleUrls: ['./task-insert.component.css']
})
export class TaskInsertComponent implements OnInit {

    public taskInsert: Task;
    public task: Task;
    resourceSelected: number;
    public resourcesInsert: Array<Resource>;
    constructor(private taskService: TaskService, private resourceService: ResourceService) { }

    ngOnInit() {


        // this.task.resourceDTO.resourceId = 0;

        this.resourceService.resourceList().subscribe((response) => {
            this.resourcesInsert = response;
            console.log('Lista clienti caricarita');
        });

    }

    insertTask(taskInsertForm) {

        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        const resourceInsert: Resource = new Resource(Number(taskInsertForm.value.resourceSelected), null, null, null);
        this.task = new Task(0, taskInsertForm.value.orderDescription, userInsert, resourceInsert);
        this.taskService.insertTask(this.task);
    }
}
