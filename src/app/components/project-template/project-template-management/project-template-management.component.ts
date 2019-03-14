import { Component, OnInit } from '@angular/core';
import { ProjectTemplate } from '../../../models/ProjectTemplate';
import { ProjectTemplateService } from '../../../services/projectTemplate.service';
import { Router } from '@angular/router';
import { subscribeOn } from 'rxjs/operators';



@Component({
    selector: 'app-project-template-management',
    templateUrl: './project-template-management.component.html',
    styleUrls: ['./project-template-management.component.css']
})
export class ProjectTemplateManagementComponent implements OnInit {

        public projectsTemplate: Array<ProjectTemplate>;

    constructor(private projectTemplateService: ProjectTemplateService, private router: Router) { }

    ngOnInit() {
        this.projectTemplateService.projectTemplateList().subscribe((response) => {
            this.projectsTemplate = response;
            console.log('La grandezza e\'' + this.projectsTemplate.length);
        });
    }

    removeLink(projectTemplateId: number) {
        this.projectTemplateService.deleteProjectTemplate(projectTemplateId);
    }

    updateLink(projectTemplateId: number) {
        this.router.navigateByUrl('/ProjectTemplate/update/' + projectTemplateId);
    }

    insertLink() {
        this.router.navigateByUrl('/ProjectTemplate/insert');
    }
    cloneLink() {
        this.router.navigateByUrl('/ProjectTemplate/clone');
    }

}
