import { Component, OnInit } from '@angular/core';
import { Project } from '../../../models/Project';
import { ProjectService } from '../../../services/project.service';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';

@Component({
    selector: 'app-project-insert',
    templateUrl: './project-insert.component.html',
    styleUrls: ['./project-insert.component.css']
})
export class ProjectInsertComponent implements OnInit {

    constructor(private projectService: ProjectService) { }

    ngOnInit() {
    }

    insertProject(projectInsertForm: NgForm) {
        const userInsertProject: User = JSON.parse(sessionStorage.getItem('user'));
        const project: Project = new Project(0, projectInsertForm.value.projectName, null, userInsertProject, null);
        // tslint:disable-next-line:max-line-length
        this.projectService.insertProject(project);
    }
}

