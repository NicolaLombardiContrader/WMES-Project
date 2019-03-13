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
    public project: Project;
    public tasks: Array<Task>;
    // tslint:disable-next-line:max-line-length
    constructor(private projectService: ProjectService, private taskService: TaskService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.projectId = Number(this.route.snapshot.paramMap.get('projectId'));
        console.log('Project id in update:' + this.projectId);
        this.projectService.readProject(this.projectId).subscribe((response) => {
            this.project = response;
            console.log('Project caricarito: ' + this.project.projectName);
        });

        this.taskService.taskList().subscribe((response) => {
            this.tasks = response;
            console.log('Lista caricarita');
        });
    }

    update(f: NgForm) {
        const userUpdate: User = JSON.parse(sessionStorage.getItem('user'));
        this.project.userDTO = userUpdate;
        this.projectService.updateProject(this.project);
    }


  }


