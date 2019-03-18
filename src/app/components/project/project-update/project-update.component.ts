import { Component, OnInit } from '@angular/core';
import { Project } from '../../../models/Project';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from '../../../services/project.service';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';
import { Task } from '../../../models/Task';
import { TaskService } from '../../../services/task.service';

@Component({
    selector: 'app-project-update',
    templateUrl: './project-update.component.html',
    styleUrls: ['./project-update.component.css']
})
export class ProjectUpdateComponent implements OnInit {

    projectId: number;
    public projectUpdate: Project;

    public taskRoot: Task;
    public list: Array<Task>;

    // tslint:disable-next-line:max-line-length
    constructor(private projectService: ProjectService, private taskService: TaskService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.projectId = Number(this.route.snapshot.paramMap.get('projectId'));
        console.log('Project id in update:' + this.projectId);
        /*
         this.projectService.readProject(this.projectId).subscribe((response) => {
             this.projectUpdate = response;
             console.log('Project caricarito: ' + this.projectUpdate.projectName);
         });
 */

        this.projectService.readProject(this.projectId).subscribe((data: any) => {
            if (data != null) {
                this.projectUpdate = data;
                console.log('Project caricarito: ' + this.projectUpdate.projectName);
            }
        });

        // Find the task root
        this.projectService.findRootNode(String(this.projectId)).subscribe((data: any) => {
            if (data != null) {
                this.taskRoot = data;
                this.list = this.taskRoot.childsList;
            }
        });

        console.log('lunghezza lista: ' + this.taskRoot.childsList.length);

        /*
        this.taskService.taskList().subscribe((response) => {
            this.tasks = response;
            console.log('Lista task caricarita');
        });
        */
    }

    update(projectUpdateForm: NgForm) {

        const userUpdateProject: User = JSON.parse(sessionStorage.getItem('user'));

        console.log('Nome progetto selezionato: ' + projectUpdateForm.value.tasksSelected);
        console.log('Id Utente' + String(userUpdateProject.userId));
        console.log('TaskModel id: ' + projectUpdateForm.value.taskModelIdSelected);


        this.projectUpdate.userDTO = userUpdateProject;
        this.projectService.updateProject(this.projectUpdate);
    }

    insertTaskNode(taskFatherId: string) {
        // this.projectId = Number(this.route.snapshot.paramMap.get('projectId'));
        this.router.navigateByUrl('/ProjectTree/insert/' + this.projectId + '/' + taskFatherId + '/');
    }

    deleteTaskNode(taskId: number) {
        this.projectService.deleteTaskNode(taskId);
    }

}


