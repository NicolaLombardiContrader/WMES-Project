import { Client } from './Client';
import { Order } from './Order';
import { Task } from './Task';
import { Project } from './Project';
import { ProjectTemplate } from './ProjectTemplate';
export class User {
    useruser: string;
    userpass: string;
    usertype: number;
    tasks: Task [];
    clients: Client [];
    projects: Project [];
    projectTemplates: ProjectTemplate [];


    // tslint:disable-next-line:max-line-length
    constructor(useruser: string, userpass: string, usertype: number, tasks: Task [], clients: Client [], projects: Project [], projectTemplates: ProjectTemplate []) {
        this.useruser = useruser;
        this.userpass = userpass;
        this.usertype = usertype;
        this.tasks = tasks;
        this.clients = clients;
        this.projects = projects;
        this.projectTemplates = projectTemplates;

    }

}
