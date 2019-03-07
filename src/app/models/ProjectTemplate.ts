import { User } from './User';
import { Task } from './Task';
export class ProjectTemplate {
   projectId: number;
   projectName: string;
   userDTO: User;
   tasksDTO: Task [];


    constructor(projectId: number, projectName: string, userDTO: User, tasksDTO: Task []) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.userDTO = userDTO;
        this.tasksDTO = tasksDTO;

    }

}
