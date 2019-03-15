import { Component, OnInit } from '@angular/core';
import { TaskModel } from '../../../models/TaskModel';
import { Router } from '@angular/router';
import { TaskModelService } from '../../../services/taskModel.service';

@Component({
    selector: 'app-task-model-management',
    templateUrl: './task-model-management.component.html',
    styleUrls: ['./task-model-management.component.css']
})
export class TaskModelManagementComponent implements OnInit {
    public tasksModel: Array<TaskModel>;

    constructor(private taskModelService: TaskModelService, private router: Router) { }


    ngOnInit() {

        this.taskModelService.taskModelList().subscribe((response) => {
            this.tasksModel = response;
            console.log('La grandezza e\'' + this.tasksModel.length);
        });
    }

    removeLink(taskModelId: number) {
        this.taskModelService.deleteTaskModel(taskModelId);
    }

    updateLink(taskModelId: number) {
        this.router.navigateByUrl('/TaskModel/update/' + taskModelId);
    }

    insertLink() {
        this.router.navigateByUrl('/TaskModel/insert');
    }



}
