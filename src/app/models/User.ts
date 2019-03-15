import { Client } from './Client';

import { Task } from './Task';
import { Project } from './Project';
import { ProjectTemplate } from './ProjectTemplate';
export class User {
    userId: number;
    userUser: string;
    userPass: string;
    userType: string;
    tasksDTO: Task [];
    clientsDTO: Client [];
    projectsDTO: Project [];
    projectTemplatesDTO: ProjectTemplate [];


    // tslint:disable-next-line:max-line-length
    constructor(userId: number, userUser: string, userPass: string, userType: string, tasksDTO: Task [], clientsDTO: Client [], projectsDTO: Project [], projectTemplatesDTO: ProjectTemplate []) {
        this.userId = userId;
        this.userUser = userUser;
        this.userPass = userPass;
        this.userType = userType;
        this.tasksDTO = tasksDTO;
        this.clientsDTO = clientsDTO;
        this.projectsDTO = projectsDTO;
        this.projectTemplatesDTO = projectTemplatesDTO;
    }

}
