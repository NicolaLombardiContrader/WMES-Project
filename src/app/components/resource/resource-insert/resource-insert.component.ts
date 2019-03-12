import { Component, OnInit } from '@angular/core';
import { ResourceService } from '../../../services/resource.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../../models/User';
import { Task } from '../../../models/Task';
import { Resource } from '../../../models/Resource';
import { NgForm } from '@angular/forms';

@Component({
    selector: 'app-resource-insert',
    templateUrl: './resource-insert.component.html',
    styleUrls: ['./resource-insert.component.css']
})
export class ResourceInsertComponent implements OnInit {

    public resource: Resource;
    constructor(private resourceService: ResourceService, private router: Router) { }

    ngOnInit() {
        const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        this.resource = new Resource(null, null, null, null, userInsert, null);
    }

    insertResource(f: NgForm) {
        console.log('Resource id: ' + f.value.resourceId + ' ' + f.value.resourceName);
        // const userInsert: User = JSON.parse(sessionStorage.getItem('user'));
        // const taskArray: Task[] = [];
        // tslint:disable-next-line:max-line-length
        // const insertResource: Resource = new Resource(null, f.value.resourceName, f.value.resourceUsername, f.value.resourcePass, userInsert, taskArray);
        this.resourceService.insertResource(this.resource);
        // this.router.navigateByUrl('/Resource/resourceManagement');
    }

}
