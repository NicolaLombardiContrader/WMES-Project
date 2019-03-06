import { User } from './User';
import { Task } from './Task';
export class ProjectTemplate {
   projectId: number;
   projectName: string;
   user: User;
   tasks: Task [];


    constructor(projectId: number, projectName: string, user: User, tasks: Task []) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.user = user;
        this.tasks = tasks;

    }

}
