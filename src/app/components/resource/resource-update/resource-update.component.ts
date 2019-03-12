import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ResourceService } from '../../../services/resource.service';
import { Task } from '../../../models/Task';
import { Resource } from '../../../models/Resource';
import { NgForm } from '@angular/forms';
import { User } from '../../../models/User';

@Component({
    selector: 'app-resource-update',
    templateUrl: './resource-update.component.html',
    styleUrls: ['./resource-update.component.css']
})
export class ResourceUpdateComponent implements OnInit {

    resourceId: number;
    resourceName: string;
    public resource: Resource;

    // tslint:disable-next-line:max-line-length
    constructor(private resourceService: ResourceService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        /** Convert String to number */
        this.resourceId = Number(this.route.snapshot.paramMap.get('resourceId'));
        console.log('Resource id in update:' + this.resourceId);
        this.resourceService.readResource(this.resourceId).subscribe((response) => {
            this.resource = response;
            console.log('Resource caricarito: ' + this.resource.resourceName);
        });
    }

    update(f: NgForm) {
        console.log(f.value);
        const userUpdate: User = JSON.parse(sessionStorage.getItem('user'));
        // const taskArray: Task[] = [];
        // tslint:disable-next-line:max-line-length
        // const updateResource: Resource = new Resource(f.value.resourceId, f.value.resourceName, f.value.resourceUsername, f.value.resourcePass, userUpdate, taskArray);
        this.resource.userDTO = userUpdate;
        this.resourceService.updateResource(this.resource);
        // this.router.navigateByUrl('/Resource/resourceManagement');
    }

}
