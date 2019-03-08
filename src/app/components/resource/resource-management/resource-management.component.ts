import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResourceService } from '../../../services/resource.service';
import { Resource } from '../../../models/Resource';

@Component({
    selector: 'app-resource-management',
    templateUrl: './resource-management.component.html',
    styleUrls: ['./resource-management.component.css']
})
export class ResourceManagementComponent implements OnInit {
    public resources: Array<Resource>;

    constructor(private resourceService: ResourceService, private router: Router) { }
    ngOnInit() {
        this.resourceService.resourceList().subscribe((response) => {
            this.resources = response;
            console.log('La grandezza e\'' + this.resources.length);
        });
    }

    removeLink(resourceId: number) {
        /** this.router.navigateByUrl('/delete?resourceID=' + resourceId); */
        this.resourceService.deleteResource(resourceId);
        /** this.router.navigateByUrl('/Resource/resourceManagement'); */
    }

    updateLink(resourceId: number) {
        this.router.navigateByUrl('/Resource/update/' + resourceId);
    }

    insertLink() {
        this.router.navigateByUrl('/Resource/insert');
    }
}



