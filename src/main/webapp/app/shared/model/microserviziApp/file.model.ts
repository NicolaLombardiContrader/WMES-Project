export interface IFile {
    id?: number;
    name?: string;
    url?: string;
    jhi_size?: number;
    mime?: string;
}

export class File implements IFile {
    constructor(public id?: number, public name?: string, public url?: string, public jhi_size?: number, public mime?: string) {}
}
