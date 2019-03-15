import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../../services/task.service';
import { Router } from '@angular/router';
import { Task } from '../../../models/Task';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';
import { Resource } from '../../../models/Resource';
import { ResourceService } from '../../../services/resource.service';
import { Item } from '../../../models/Item';
import { ItemService } from '../../../services/item.service';

@Component({

    selector: 'app-task-insert',
    templateUrl: './task-insert.component.html',
    styleUrls: ['./task-insert.component.css']
})
export class TaskInsertComponent implements OnInit {

    public taskInsert: Task;
    public task: Task;
    resourceSelected: number;
    public resourcesInsert: Array<Resource>;
    public itemsInputInsert: Array<Item>;
    public itemsOutputInsert: Array<Item>;
    constructor(private taskService: TaskService, private itemService: ItemService, private resourceService: ResourceService) { }

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

    insertTask(taskInsertForm) {
        const taskAction = taskInsertForm.value.taskAction;
        const taskDescription = taskInsertForm.value.taskDescription;
        const taskState = taskInsertForm.value.taskState;
        const taskTime = taskInsertForm.value.taskTime;
        const userTaskInsert: User = JSON.parse(sessionStorage.getItem('user'));
        // tslint:disable-next-line:max-line-length
        const resourceInsert: Resource = new Resource(Number(taskInsertForm.value.resourceSelected), null, null, null, userTaskInsert, null);

        // Fill items
        const itemSelectedArray: Array<Item> = new Array<Item>();
        const itemInputReceived: [] = taskInsertForm.value.itemInputSelected;
        for (const itemInputIdSelected of itemInputReceived) {
            itemSelectedArray.push(new Item(itemInputIdSelected, null, null, null, userTaskInsert));
        }

        const itemOutputReceived: [] = taskInsertForm.value.itemOutputSelected;
        for (const itemOutputIdSelected of itemOutputReceived) {
            itemSelectedArray.push(new Item(itemOutputIdSelected, null, null, null, userTaskInsert));
        }

        console.log(taskInsertForm.value);
        this.task = new Task(0, taskAction, taskDescription, taskState, taskTime, userTaskInsert, resourceInsert, itemSelectedArray);
        this.taskService.insertTask(this.task);
    }
}
