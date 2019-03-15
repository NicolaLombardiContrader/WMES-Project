import { Component, OnInit } from '@angular/core';
import { TaskModel } from '../../../models/TaskModel';
import { Resource } from '../../../models/Resource';
import { Item } from '../../../models/Item';
import { TaskModelService } from '../../../services/taskModel.service';
import { ItemService } from '../../../services/item.service';
import { ResourceService } from '../../../services/resource.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../../models/User';
import { NgForm } from '@angular/forms';

@Component({
    selector: 'app-task-model-update',
    templateUrl: './task-model-update.component.html',
    styleUrls: ['./task-model-update.component.css']
})
export class TaskModelUpdateComponent implements OnInit {
    public taskModelUpdate: TaskModel;
    public taskModel: TaskModel;
    resourceSelected: number;
    public resourcesUpdate: Array<Resource>;
    public itemsInputUpdate: Array<Item>;
    public itemsOutputUpdate: Array<Item>;
    taskModelId: number;
    // tslint:disable-next-line:max-line-length
    constructor(private taskModelService: TaskModelService, private itemService: ItemService, private route: ActivatedRoute, private resourceService: ResourceService) {
    }

    ngOnInit() {

        this.taskModelId = Number(this.route.snapshot.paramMap.get('taskModelId'));
        console.log('Task Model id in update:' + this.taskModelId);
        this.taskModelService.readTask(this.taskModelId).subscribe((response) => {
            this.taskModel = response;
            console.log('Task Model caricarito: ' + this.taskModel.taskModelDescription);
        });

        this.resourceService.resourceList().subscribe((response) => {
            this.resourcesUpdate = response;
            console.log('Lista clienti caricarita');
        });

        this.itemService.itemListByItemType('input').subscribe((response) => {
            this.itemsInputUpdate = response;
            console.log('Lista item input caricarita');
        });

        this.itemService.itemListByItemType('output').subscribe((response) => {
            this.itemsOutputUpdate = response;
            console.log('Lista item output caricarita');
        });

    }

    updateTaskModel(taskModelUpdateForm: NgForm) {
        const userUpdate: User = JSON.parse(sessionStorage.getItem('user'));
        this.taskModelUpdate.userDTO = userUpdate;
        this.taskModelService.updateTaskModel(this.taskModelUpdate);
    }

}
