import { Component, OnInit } from '@angular/core';
import { ProjectTemplate } from '../../../models/ProjectTemplate';
import { ProjectTemplateService } from '../../../services/projectTemplate.service';
import { Router } from '@angular/router';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';
import { Task } from '../../../models/Task';
import { TaskService } from '../../../services/task.service';


@Component({
  selector: 'app-project-template-insert',
  templateUrl: './project-template-insert.component.html',
  styleUrls: ['./project-template-insert.component.css']
})
export class ProjectTemplateInsertComponent implements OnInit {

    public projectTemplateInsert: ProjectTemplate;
    public tasksInsert: Array<Task>;

        public firstTaskId: number;

  constructor(private projectTemplateService: ProjectTemplateService, private taskServiceInsert: TaskService) { }

  ngOnInit() {
        this.taskServiceInsert.taskList().subscribe((response) => {
            this.tasksInsert = response;
            console.log('Lista caricarita');
        });
    }
  insertProjectTemplate(projectTemplateInsertForm: NgForm) {
      console.log(projectTemplateInsertForm.value.tasksSelected);
      const userInsertProjectTemplate: User = JSON.parse(sessionStorage.getItem('user'));
      const tasksSelectedArray: Array<Task> = new Array<Task>();
      for (const taskIdSelected of projectTemplateInsertForm.value.tasksSelected) {
          tasksSelectedArray.push(new Task(taskIdSelected, null, null, null, null, null, null, userInsertProjectTemplate, null));
      }
      this.projectTemplateInsert = new ProjectTemplate(0, projectTemplateInsertForm.value.projectName,
        userInsertProjectTemplate, tasksSelectedArray);
      this.projectTemplateService.insertProjectTemplate(this.projectTemplateInsert);
}

}
