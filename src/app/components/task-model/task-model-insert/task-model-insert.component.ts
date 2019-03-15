import { Component, OnInit } from '@angular/core';
import { TaskModel } from '../../../models/TaskModel';
import { Resource } from '../../../models/Resource';
import { Item } from '../../../models/Item';
import { ResourceService } from '../../../services/resource.service';
import { ItemService } from '../../../services/item.service';
import { TaskModelService } from '../../../services/taskModel.service';
import { User } from '../../../models/User';

@Component({
    selector: 'app-task-model-insert',
    templateUrl: './task-model-insert.component.html',
    styleUrls: ['./task-model-insert.component.css']
})
export class TaskModelInsertComponent implements OnInit {

    public taskModelInsert: TaskModel;
    public taskModel: TaskModel;
    resourceSelected: number;
    public resourcesInsert: Array<Resource>;
    public itemsInputInsert: Array<Item>;
    public itemsOutputInsert: Array<Item>;

    // tslint:disable-next-line:max-line-length
    constructor(private taskModelService: TaskModelService, private itemService: ItemService, private resourceService: ResourceService) {

    }

    ngOnInit() {

        this.resourceService.resourceList().subscribe((response) => {
            this.resourcesInsert = response;
            console.log('Lista clienti caricarita');
        });

        this.itemService.itemListByItemType('input').subscribe((response) => {
            this.itemsInputInsert = response;
            console.log('Lista item input caricarita');
        });

        this.itemService.itemListByItemType('output').subscribe((response) => {
            this.itemsOutputInsert = response;
            console.log('Lista item output caricarita');
        });

    }


    insertTaskModel(taskModelInsertForm) {
        const taskModelAction = taskModelInsertForm.value.taskModelAction;
        const taskModelDescription = taskModelInsertForm.value.taskModelDescription;
        const taskModelState = taskModelInsertForm.value.taskModelState;
        const taskModelTime = taskModelInsertForm.value.taskModelTime;
        const userTaskModelInsert: User = JSON.parse(sessionStorage.getItem('user'));
        // tslint:disable-next-line:max-line-length
        const resourceInsert: Resource = new Resource(Number(taskModelInsertForm.value.resourceSelected), null, null, null, userTaskModelInsert, null);

        // Fill items
        const itemSelectedArray: Array<Item> = new Array<Item>();
        const itemInputReceived: [] = taskModelInsertForm.value.itemInputSelected;
        for (const itemInputIdSelected of itemInputReceived) {
            itemSelectedArray.push(new Item(itemInputIdSelected, null, null, null, userTaskModelInsert));
        }

        const itemOutputReceived: [] = taskModelInsertForm.value.itemOutputSelected;
        for (const itemOutputIdSelected of itemOutputReceived) {
            itemSelectedArray.push(new Item(itemOutputIdSelected, null, null, null, userTaskModelInsert));
        }

        console.log(taskModelInsertForm.value);
        // tslint:disable-next-line:max-line-length
        this.taskModel = new TaskModel(0, taskModelAction, taskModelDescription, taskModelState, taskModelTime, userTaskModelInsert, resourceInsert, itemSelectedArray);
        this.taskModelService.insertTaskModel(this.taskModel);
    }
}
