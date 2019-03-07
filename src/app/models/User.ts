import { Client } from './Client';
import { Order } from './Order';
import { Task } from './Task';
import { Project } from './Project';
import { ProjectTemplate } from './ProjectTemplate';
export class User {
    userUser: string;
    userPass: string;
    userType: string;
    tasksDTO: Task [];
    clientsDTO: Client [];
    projectsDTO: Project [];
    projectTemplatesDTO: ProjectTemplate [];


    // tslint:disable-next-line:max-line-length
    constructor(userUser: string, userPass: string, userType: string, tasksDTO: Task [], clientsDTO: Client [], projectsDTO: Project [], projectTemplatesDTO: ProjectTemplate []) {
        this.userUser = userUser;
        this.userPass = userPass;
        this.userType = userType;
        this.tasksDTO = tasksDTO;
        this.clientsDTO = clientsDTO;
        this.projectsDTO = projectsDTO;
        this.projectTemplatesDTO = projectTemplatesDTO;
    }

}
