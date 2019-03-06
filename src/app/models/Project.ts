import { User } from './User';
import { Task } from './Task';

export class Project {
    projectId: number;
    projectName: string;
    projectStatus: number;
    user: User;
    tasks: Task [];



    constructor(projectId: number, projectName: string, projectStatus: number, user: User, tasks: Task [] ) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.user = user;
        this.tasks = tasks;
    }

}
