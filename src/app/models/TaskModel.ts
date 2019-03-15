import { User } from './User';
import { Item } from './Item';
import { Resource } from './Resource';


export class TaskModel {
    taskModelId: number;
    resourceDTO: Resource;
    taskModelAction: string;
    taskModelDescription: string;
    taskModelState: number;
    taskModelTime: number;
    userDTO: User;
    itemsDTO: Item[];

    // tslint:disable-next-line:max-line-length
    constructor(taskModelId: number, taskModelAction: string, taskModelDescription: string, taskModelState: number, taskModelTime: number, userDTO: User, resourceDTO: Resource, itemsDTO: Item[]) {

        this.taskModelId = taskModelId;
        this.taskModelAction = taskModelAction;
        this.taskModelDescription = taskModelDescription;
        this.taskModelState = taskModelState;
        this.taskModelTime = taskModelTime;
        this.userDTO = userDTO;
        this.resourceDTO = resourceDTO;
        this.itemsDTO = itemsDTO;
        /*
        this.projectsDTO = projectsDTO;
        this.projectTemplatesDTO = projectTemplatesDTO;
        */
    }
}

