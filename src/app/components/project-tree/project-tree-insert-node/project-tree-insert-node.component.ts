import { Component, OnInit } from '@angular/core';
import { TaskModelService } from '../../../services/taskModel.service';
import { TaskModel } from '../../../models/TaskModel';
import { NgForm } from '@angular/forms';
import { ProjectService } from '../../../services/project.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-project-tree-insert-node',
    templateUrl: './project-tree-insert-node.component.html',
    styleUrls: ['./project-tree-insert-node.component.css']
})
export class ProjectTreeInsertNodeComponent implements OnInit {
    public taskModelList: Array<TaskModel>;
    public taskFatherId: string = null;
    public projectId: string;
    constructor(private taskModelService: TaskModelService, private projectService: ProjectService, private route: ActivatedRoute) { }

    ngOnInit() {
        this.projectId = this.route.snapshot.paramMap.get('projectId');

        if (this.route.snapshot.paramMap.get('taskFatherId') !== '0') {
            this.taskFatherId = this.route.snapshot.paramMap.get('taskFatherId');
        }

        console.log('Id project: ' + this.projectId);
        console.log('taskFatherId: ' + this.taskFatherId);
        this.taskModelService.taskModelList().subscribe((response) => {
            this.taskModelList = response;
            console.log('Lista model caricarita');
        });
    }

    insertNodeTask(projectTreeInsertTask: NgForm) {
        if (projectTreeInsertTask.value.taskFatherId !== 0) {
            this.taskFatherId = projectTreeInsertTask.value.taskFatherId;
        }

        this.projectService.insertTaskNode(this.projectId,
            projectTreeInsertTask.value.taskModelIdSelected,
            this.taskFatherId);
    }
}
