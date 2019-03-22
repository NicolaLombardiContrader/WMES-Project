export interface ITask {
    id?: number;
    description?: string;
    projectId?: number;
}

export class Task implements ITask {
    constructor(public id?: number, public description?: string, public projectId?: number) {}
}
