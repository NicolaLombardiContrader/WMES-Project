import { Component, OnInit } from '@angular/core';
import { TaskModelService } from '../../../services/taskModel.service';
import { TaskModel } from '../../../models/TaskModel';
import { NgForm } from '@angular/forms';
import { ProjectService } from '../../../services/project.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-project-tree-insert-node',
    templateUrl: './project-tree-insert-node.component.html',
    styleUrls: ['./project-tree-insert-node.component.css']
})
export class ProjectTreeInsertNodeComponent implements OnInit {
    public taskModelList: Array<TaskModel>;
    public taskFatherId = '0';
    public projectId: string;
    // tslint:disable-next-line:max-line-length
    constructor(private taskModelService: TaskModelService, private projectService: ProjectService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        this.projectId = this.route.snapshot.paramMap.get('projectId');
        this.taskFatherId = this.route.snapshot.paramMap.get('taskFatherId');


        console.log('Id project: ' + this.projectId);
        console.log('taskFatherId: ' + this.taskFatherId);
        this.taskModelService.taskModelList().subscribe((response) => {
            this.taskModelList = response;
            console.log('Lista model caricarita');
        });
    }

    insertNodeTask(projectTreeInsertTask: NgForm) {
        this.projectService.insertTaskNode(this.projectId,
            projectTreeInsertTask.value.taskModelIdSelected,
            this.taskFatherId);
        this.router.navigateByUrl('/Project/update/' + this.projectId);
    }
}
