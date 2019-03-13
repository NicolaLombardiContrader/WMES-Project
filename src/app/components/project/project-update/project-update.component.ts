import { Component, OnInit } from '@angular/core';
import { Project } from '../../../models/Project';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from '../../../services/project.service';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-project-update',
  templateUrl: './project-update.component.html',
  styleUrls: ['./project-update.component.css']
})
export class ProjectUpdateComponent implements OnInit {

  projectId: number;
    public project: Project;

    // tslint:disable-next-line:max-line-length
    constructor(private projectService: ProjectService, private route: ActivatedRoute, private router: Router) { }


  ngOnInit() {

     /** Convert String to number */
        this.project.projectId = Number(this.route.snapshot.paramMap.get('projectId'));
        console.log('Project id in update:' + this.projectId);
        this.projectService.readProject(this.projectId).subscribe((response) => {
            this.project = response;

        });

    }

    update(f: NgForm) {
        const userUpdate: User = JSON.parse(sessionStorage.getItem('user'));
        this.project.userDTO = userUpdate;
        this.projectService.updateProject(this.project);
    }
  }


