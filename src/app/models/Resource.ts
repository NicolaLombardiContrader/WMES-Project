import { User } from './User';
import { Task } from './Task';
export class Resource {
    resourceId: number;
    resourceName: string;
    resourceUsername: string;
    resourcePass: string;
    user: User;
    tasks: Task [];


    constructor(resourceId: number, resourceName: string, resourceUsername: string, resourcePass: string, user: User, tasks: Task [] ) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceUsername = resourceUsername;
        this.resourcePass = resourcePass;
        this.user = user;
        this.tasks = tasks;
    }

}
