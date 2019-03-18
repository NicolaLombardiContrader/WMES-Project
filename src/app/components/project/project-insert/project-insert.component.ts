import { Component, OnInit } from '@angular/core';
import { Project } from '../../../models/Project';
import { ProjectService } from '../../../services/project.service';
import { User } from '../../../models/User';
import { Task } from '../../../models/Task';
import { NgForm } from '@angular/forms';
import { TaskModelService } from '../../../services/taskModel.service';
import { TaskModel } from '../../../models/TaskModel';
import { Resource } from '../../../models/Resource';

@Component({
    selector: 'app-project-insert',
    templateUrl: './project-insert.component.html',
    styleUrls: ['./project-insert.component.css']
})
export class ProjectInsertComponent implements OnInit {

    public projectInsert: Project;

    public firstTaskId: number;

    public taskRootSelected: string;
    constructor(private projectService: ProjectService, private taskModelServiceInsert: TaskModelService) { }

    ngOnInit() {

    }

    insertProject(projectInsertForm: NgForm) {
        const userInsertProject: User = JSON.parse(sessionStorage.getItem('user'));
        const project: Project = new Project(0, projectInsertForm.value.projectName, null, userInsertProject, null);
        // tslint:disable-next-line:max-line-length
        this.projectService.insertProject(project);
    }
}


