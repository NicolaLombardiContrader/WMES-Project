import { User } from './User';
import { Task } from './Task';

export class Project {
    projectId: number;
    projectName: string;
    projectStatus: number;
    userDTO: User;
    tasksDTO: Task [];



    constructor(projectId: number, projectName: string, projectStatus: number, userDTO: User, tasksDTO: Task [] ) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.userDTO = userDTO;
        this.tasksDTO = tasksDTO;
    }




}





