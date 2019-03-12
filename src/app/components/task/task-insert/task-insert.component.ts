import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../../services/task.service';

@Component({
  selector: 'app-task-insert',
  templateUrl: './task-insert.component.html',
  styleUrls: ['./task-insert.component.css']
})
export class TaskInsertComponent implements OnInit {

  constructor(private taskService: TaskService) { }

  ngOnInit() {
  }

}
