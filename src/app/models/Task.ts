import { User } from './User';
import { Item } from './Item';
import { Resource } from './Resource';
import { Project } from './Project';
import { ProjectTemplate } from './ProjectTemplate';
export class Task {
    taskId: number;
    taskAction: string;
    taskDescription: string;
    taskState: number;
    taskTime: number;
    userDTO: User;
    resourceDTO: Resource;
    itemsDTO: Item[];
    childsList: Task[];
    taskFatherDTO: Task;
    projectsDTO: Project[];
    projectTemplatesDTO: ProjectTemplate[];



    // tslint:disable-next-line:max-line-length
    constructor(taskId: number, taskAction: string, taskDescription: string, taskState: number, taskTime: number, userDTO: User, resourceDTO: Resource, itemsDTO: Item[], taskFatherDTO: Task, childsList: Task[]) {

        this.taskId = taskId;
        this.taskAction = taskAction;
        this.taskDescription = taskDescription;
        this.taskState = taskState;
        this.taskTime = taskTime;
        this.userDTO = userDTO;
        this.resourceDTO = resourceDTO;
        this.itemsDTO = itemsDTO;
        this.childsList = childsList;
        this.taskFatherDTO = taskFatherDTO;
        /*
        this.projectsDTO = projectsDTO;
        this.projectTemplatesDTO = projectTemplatesDTO;
        */
    }
}

