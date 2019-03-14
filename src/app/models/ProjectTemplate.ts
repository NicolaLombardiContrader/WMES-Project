import { User } from './User';
import { Task } from './Task';
export class ProjectTemplate {
   projectTemplateId: number;
   projectName: string;
   userDTO: User;
   tasksDTO: Task [];


    constructor(projectTemplateId: number, projectName: string, userDTO: User, tasksDTO: Task []) {
        this.projectTemplateId = projectTemplateId;
        this.projectName = projectName;
        this.userDTO = userDTO;
        this.tasksDTO = tasksDTO;

    }

}
