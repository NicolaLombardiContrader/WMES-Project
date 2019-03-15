import { User } from './User';

export class Item {

    itemId: number;
    itemCode: string;
    itemName: string;
    itemType: string;
    userDTO: User;

    constructor(itemId: number, itemCode: string, itemName: string, itemType: string, userDTO: User) {
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemType = itemType;
        this.userDTO = userDTO;
    }
}
