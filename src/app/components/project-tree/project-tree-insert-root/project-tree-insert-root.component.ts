import { Component, OnInit } from '@angular/core';
import { TaskModelService } from '../../../services/taskModel.service';
import { TaskModel } from '../../../models/TaskModel';
import { NgForm } from '@angular/forms';

@Component({
    selector: 'app-project-tree-insert-root',
    templateUrl: './project-tree-insert-root.component.html',
    styleUrls: ['./project-tree-insert-root.component.css']
})
export class ProjectTreeInsertRootComponent implements OnInit {

    public taskModelList: Array<TaskModel>;
    constructor(private taskModelService: TaskModelService) { }

    ngOnInit() {

        this.taskModelService.taskModelList().subscribe((response) => {
            this.taskModelList = response;
            console.log('Lista model caricarita');
        });

    }

    insertRootTask(projectTreeInsertTask: NgForm) {

    }

}
