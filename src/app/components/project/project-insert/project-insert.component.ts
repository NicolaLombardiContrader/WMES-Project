import { Component, OnInit } from '@angular/core';
import { Project } from '../../../models/Project';
import { ProjectService } from '../../../services/project.service';
import { User } from '../../../models/User';

@Component({
  selector: 'app-project-insert',
  templateUrl: './project-insert.component.html',
  styleUrls: ['./project-insert.component.css']
})
export class ProjectInsertComponent implements OnInit {

  public project: Project;

    constructor(private projectService: ProjectService) { }


  ngOnInit() {

    }
  }


