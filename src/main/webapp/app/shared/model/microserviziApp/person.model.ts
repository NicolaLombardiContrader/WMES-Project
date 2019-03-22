export interface IPerson {
    id?: number;
    name?: string;
    lastName?: string;
}

export class Person implements IPerson {
    constructor(public id?: number, public name?: string, public lastName?: string) {}
}
