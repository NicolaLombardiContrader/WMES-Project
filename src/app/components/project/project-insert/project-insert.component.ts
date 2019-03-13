import { Component, OnInit } from '@angular/core';
import { Project } from '../../../models/Project';
import { ProjectService } from '../../../services/project.service';
import { User } from '../../../models/User';
import { Task } from '../../../models/Task';
import { TaskService } from '../../../services/task.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-project-insert',
  templateUrl: './project-insert.component.html',
  styleUrls: ['./project-insert.component.css']
})
export class ProjectInsertComponent implements OnInit {

    public project: Project;

    public firstTaskId: number;
    public taskInsert: Array<Task>;
    constructor(private projectService: ProjectService, private taskServiceInsert: TaskService) { }

    ngOnInit() {
        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        this.project = new Project(0, null, null, userInsert, null);

        this.taskServiceInsert.taskList().subscribe((response) => {
            this.taskInsert = response;
            console.log('Lista caricarita');
        });

        // Used for presetting menu
        console.log('The first task id is: ' + this.taskInsert[0].taskDescription);
        this.project.tasksDTO[0].taskId = this.taskInsert[0].taskId;
        this.firstTaskId = this.taskInsert[0].taskId;
    }

    insertProject(f: NgForm) {
        this.projectService.insertProject(this.project);
    }
  }


