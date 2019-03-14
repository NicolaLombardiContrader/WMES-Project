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

    public projectInsert: Project;

    public firstTaskId: number;
    public tasksInsert: Array<Task>;
    constructor(private projectService: ProjectService, private taskServiceInsert: TaskService) { }

    ngOnInit() {
        this.taskServiceInsert.taskList().subscribe((response) => {
            this.tasksInsert = response;
            console.log('Lista caricarita');
        });

    }

    insertProject(projectInsertForm: NgForm) {
        console.log(projectInsertForm.value.tasksSelected);
        const userInsertProject: User = JSON.parse(sessionStorage.getItem('user'));
        const tasksSelectedArray: Array<Task> = new Array<Task>();
        for (const taskIdSelected of projectInsertForm.value.tasksSelected) {
            tasksSelectedArray.push(new Task(taskIdSelected, null, null, null, null, null, null, userInsertProject, null));
        }
        this.projectInsert = new Project(0, projectInsertForm.value.projectName, 0, userInsertProject, tasksSelectedArray);
        // this.projectInsert = new Project(0, projectInsertForm.value.projectName, userInsert);
        this.projectService.insertProject(this.projectInsert);
    }
  }


