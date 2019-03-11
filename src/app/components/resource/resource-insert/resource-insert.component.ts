import { Component, OnInit } from '@angular/core';
import { ResourceService } from '../../../services/resource.service';

@Component({
  selector: 'app-resource-insert',
  templateUrl: './resource-insert.component.html',
  styleUrls: ['./resource-insert.component.css']
})
export class ResourceInsertComponent implements OnInit {

 constructor(private resourceService: ResourceService) { }

  ngOnInit() {
  }

}
