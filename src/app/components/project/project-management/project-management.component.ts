import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectService } from '../../../services/project.service';
import { Project } from '../../../models/Project';

@Component({
    selector: 'app-project-management',
    templateUrl: './project-management.component.html',
    styleUrls: ['./project-management.component.css']
})
export class ProjectManagementComponent implements OnInit {

    public projects: Array<Project>;
    constructor(private projectService: ProjectService, private router: Router) { }

    ngOnInit() {
        this.projectService.projectList().subscribe((response) => {
            this.projects = response;
            console.log('La grandezza e\'' + this.projects.length);
        });
    }

    removeLink(projectId: number) {
        this.projectService.deleteProject(projectId);
    }

    updateLink(projectId: number) {
        this.router.navigateByUrl('/Project/update/' + projectId);
    }

    insertLink() {
        this.router.navigateByUrl('/Project/insert');
    }
}

