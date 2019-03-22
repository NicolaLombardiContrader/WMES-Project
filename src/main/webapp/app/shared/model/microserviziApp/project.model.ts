import { Moment } from 'moment';
import { ITask } from 'app/shared/model/microserviziApp/task.model';

export interface IProject {
    id?: number;
    name?: string;
    link?: string;
    description?: string;
    addedValue?: number;
    endDate?: Moment;
    nextCriticalDate?: Moment;
    status?: string;
    fileId?: number;
    programId?: number;
    personId?: number;
    tasks?: ITask[];
    currentTaskId?: number;
}

export class Project implements IProject {
    constructor(
        public id?: number,
        public name?: string,
        public link?: string,
        public description?: string,
        public addedValue?: number,
        public endDate?: Moment,
        public nextCriticalDate?: Moment,
        public status?: string,
        public fileId?: number,
        public programId?: number,
        public personId?: number,
        public tasks?: ITask[],
        public currentTaskId?: number
    ) {}
}
