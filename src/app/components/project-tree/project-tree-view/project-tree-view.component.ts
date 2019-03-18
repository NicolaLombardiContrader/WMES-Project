import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../../services/task.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from '../../../services/project.service';
import { Task } from '../../../models/Task';
import { Project } from '../../../models/Project';

@Component({
    selector: 'app-project-tree-view',
    templateUrl: './project-tree-view.component.html',
    styleUrls: ['./project-tree-view.component.css']
})
export class ProjectTreeViewComponent implements OnInit {

    projectId: number;
    public projectUpdate: Project;

    public taskRoot: Task;
    public list: Array<Task>;

    constructor(private projectService: ProjectService, private router: Router, private route: ActivatedRoute) { }

    ngOnInit() {

        this.projectId = Number(this.route.snapshot.paramMap.get('projectId'));
        console.log('Project id in update:' + this.projectId);
        this.projectService.findRootNode(String(this.projectId)).subscribe((data: any) => {
            if (data != null) {
                this.taskRoot = data;
                this.list = this.taskRoot.childsListDTO;
                console.log(this.taskRoot);
                console.log(this.taskRoot.childsListDTO.length);
            }
        });
    }

    insertTaskNode(taskFatherId: string) {
        // this.projectId = Number(this.route.snapshot.paramMap.get('projectId'));
        this.router.navigateByUrl('/ProjectTree/insert/' + this.projectId + '/' + taskFatherId + '/');
    }

    deleteTaskNode(taskId: number) {
        this.projectService.deleteTaskNode(taskId);
    }

}
