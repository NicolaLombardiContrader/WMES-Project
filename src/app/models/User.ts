import { Client } from './Client';
import { Order } from './Order';
import { Task } from './Task';
import { Project } from './Project';
import { ProjectTemplate } from './ProjectTemplate';
export class User {
    userUser: string;
    userPass: string;
    userType: string;
    tasks: Task [];
    clients: Client [];
    projects: Project [];
    projectTemplates: ProjectTemplate [];


    // tslint:disable-next-line:max-line-length
    constructor(userUser: string, userPass: string, userType: string, tasks: Task [], clients: Client [], projects: Project [], projectTemplates: ProjectTemplate []) {
        this.userUser = userUser;
        this.userPass = userPass;
        this.userType = userType;
        this.tasks = tasks;
        this.clients = clients;
        this.projects = projects;
        this.projectTemplates = projectTemplates;

    }

}
