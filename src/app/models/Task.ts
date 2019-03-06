import { User } from './User';
import { Resource } from './Resource';
export class Task {
    taskId: number;
    taskAction: string;
    taskDescription: string;
    taskInput: string;
    taskOutput: string;
    taskState: number;
    taskTime: number;
    user: User;
    resource: Resource;
    resources: Resource [];


// tslint:disable-next-line:max-line-length
constructor(taskId: number, taskAction: string, taskDescription: string, taskInput: string, taskOutput: string, taskState: number, taskTime: number, user: User, resource: Resource, resources: Resource []) {

      this.taskId = taskId;
      this.taskAction = taskAction;
      this.taskDescription = taskDescription;
      this.taskInput = taskInput;
      this.taskOutput = taskOutput;
      this.taskState = taskState;
      this.taskTime = taskTime;
      this.user = user;
      this.resource = resource;
      this.resources = resources;
 }

 }

