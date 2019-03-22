export interface IProgram {
    id?: number;
    name?: string;
}

export class Program implements IProgram {
    constructor(public id?: number, public name?: string) {}
}
