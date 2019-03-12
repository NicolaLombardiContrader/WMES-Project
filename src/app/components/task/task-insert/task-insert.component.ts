import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../../services/task.service';
import { Router } from '@angular/router';
import { Task } from '../../../models/Task';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';
import { Resource } from '../../../models/Resource';
import { ResourceService } from '../../../services/resource.service';

@Component({

  selector: 'app-task-insert',
  templateUrl: './task-insert.component.html',
  styleUrls: ['./task-insert.component.css']
})
export class TaskInsertComponent implements OnInit {

    public task: Task;
    public resources: Array<Resource>;
  constructor(private taskService: TaskService, private resourceService: ResourceService,  private router: Router) { }

  ngOnInit() {
       const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
       this.task = new Task(null, null, null, null, null, null, null, userInsert, null);

       this.resourceService.resourceList().subscribe((response) => {
            this.resources = response;
            console.log('Lista caricarita');
        });
  }

  insertTask(f: NgForm) {
        // const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        // const taskArray: Task[] = [];
        // tslint:disable-next-line:max-line-length
        // const insertResource: Resource = new Resource(null, f.value.resourceName, f.value.resourceUsername, f.value.resourcePass, userInsert, taskArray);
        this.taskService.insertTask(this.task);
        // this.router.navigateByUrl('/Resource/resourceManagement');
    }
}
