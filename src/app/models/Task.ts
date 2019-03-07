import { User } from './User';
import { Resource } from './Resource';
import { Project } from './Project';
import { ProjectTemplate } from './ProjectTemplate';
export class Task {
    taskId: number;
    taskAction: string;
    taskDescription: string;
    taskInput: string;
    taskOutput: string;
    taskState: number;
    taskTime: number;
    userDTO: User;
    resourceDTO: Resource;
    projectsDTO: Project[];
    projectTemplatesDTO: ProjectTemplate[];



    // tslint:disable-next-line:max-line-length
    constructor(taskId: number, taskAction: string, taskDescription: string, taskInput: string, taskOutput: string, taskState: number, taskTime: number, userDTO: User, resourceDTO: Resource, projectsDTO: Project[], projectTemplatesDTO: ProjectTemplate[]) {

        this.taskId = taskId;
        this.taskAction = taskAction;
        this.taskDescription = taskDescription;
        this.taskInput = taskInput;
        this.taskOutput = taskOutput;
        this.taskState = taskState;
        this.taskTime = taskTime;
        this.userDTO = userDTO;
        this.resourceDTO = resourceDTO;
        this.projectsDTO = projectsDTO;
        this.projectTemplatesDTO = projectTemplatesDTO;

    }

}

