import { User } from './User';
import { Task } from './Task';
export class Resource {
    resourceId: number;
    resourceName: string;
    resourceUsername: string;
    resourcePass: string;
    userDTO: User;
    tasksDTO: Task[];


    constructor(resourceId: number, resourceName: string, resourceUsername: string, resourcePass: string, userDTO: User, tasksDTO: Task[]) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceUsername = resourceUsername;
        this.resourcePass = resourcePass;
        this.userDTO = userDTO;
        this.tasksDTO = tasksDTO;
    }

}
