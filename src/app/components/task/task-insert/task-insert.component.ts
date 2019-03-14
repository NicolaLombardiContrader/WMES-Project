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

    public firstResourceId: number;
    public resourcesInsert: Array<Resource>;
    constructor(private taskService: TaskService, private resourceServiceInsert: ResourceService) { }

    ngOnInit() {
        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        this.taskInsert = new Task(0, null, null, null, null, null, null, userInsert, null);
        // this.task.resourceDTO.resourceId = 0;

        this.resourceServiceInsert.resourceList().subscribe((response) => {
            this.resourcesInsert = response;
            console.log('Lista caricata ' + this.resourcesInsert[0].resourceId);
        });

        // Used for presetting menu
        console.log('test prova');
        console.log('The first resource id is: ' + this.resourcesInsert[0].resourceName);
        this.taskInsert.resourceDTO.resourceId = this.resourcesInsert[0].resourceId;
        this.firstResourceId = this.resourcesInsert[0].resourceId;
    }

    insertTask(f: NgForm) {
        this.taskService.insertTask(this.taskInsert);
    }
}
