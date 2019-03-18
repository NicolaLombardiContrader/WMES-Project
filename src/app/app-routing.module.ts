import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

/** Login */
import { LoginComponent } from './components/login/login.component';
/** Home */
import { HomeAdminComponent } from './components/home-admin/home-admin.component';
import { HomeBoComponent } from './components/home-bo/home-bo.component';
import { HomeResourceComponent } from './components/home-resource/home-resource.component';
import { UserManagementComponent } from './components/user/user-management/user-management.component';
import { UserInsertComponent } from './components/user/user-insert/user-insert.component';
import { UserUpdateComponent } from './components/user/user-update/user-update.component';
import { ClientManagementComponent } from './components/client/client-management/client-management.component';
import { ClientInsertComponent } from './components/client/client-insert/client-insert.component';
import { ClientUpdateComponent } from './components/client/client-update/client-update.component';
import { OrderManagementComponent } from './components/order/order-management/order-management.component';
import { OrderInsertComponent } from './components/order/order-insert/order-insert.component';
import { OrderUpdateComponent } from './components/order/order-update/order-update.component';
import { ProjectManagementComponent } from './components/project/project-management/project-management.component';
import { ProjectInsertComponent } from './components/project/project-insert/project-insert.component';
import { ProjectUpdateComponent } from './components/project/project-update/project-update.component';
// tslint:disable-next-line:max-line-length
import { ProjectTemplateManagementComponent } from './components/project-template/project-template-management/project-template-management.component';
import { ProjectTemplateInsertComponent } from './components/project-template/project-template-insert/project-template-insert.component';
import { ProjectTemplateUpdateComponent } from './components/project-template/project-template-update/project-template-update.component';
import { ResourceManagementComponent } from './components/resource/resource-management/resource-management.component';
import { ResourceInsertComponent } from './components/resource/resource-insert/resource-insert.component';
import { ResourceUpdateComponent } from './components/resource/resource-update/resource-update.component';
import { TaskManagementComponent } from './components/task/task-management/task-management.component';
import { TaskInsertComponent } from './components/task/task-insert/task-insert.component';
import { TaskUpdateComponent } from './components/task/task-update/task-update.component';
import { ItemManagementComponent } from './components/item/item-management/item-management.component';
import { ItemInsertComponent } from './components/item/item-insert/item-insert.component';
import { ItemUpdateComponent } from './components/item/item-update/item-update.component';
import { TaskModelManagementComponent } from './components/task-model/task-model-management/task-model-management.component';
import { TaskModelInsertComponent } from './components/task-model/task-model-insert/task-model-insert.component';
import { TaskModelUpdateComponent } from './components/task-model/task-model-update/task-model-update.component';
import { ProjectTreeInsertNodeComponent } from './components/project-tree/project-tree-insert-node/project-tree-insert-node.component';
import { ProjectTreeViewComponent } from './components/project-tree/project-tree-view/project-tree-view.component';

const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'homeAdmin', component: HomeAdminComponent },
    { path: 'homeBO', component: HomeBoComponent },
    { path: 'homeResource', component: HomeResourceComponent },
    /** User */
    { path: 'User/userManagement', component: UserManagementComponent },
    { path: 'User/insert', component: UserInsertComponent },
    { path: 'User/update/:userId', component: UserUpdateComponent },
    /** Client */
    { path: 'Client/clientManagement', component: ClientManagementComponent },
    { path: 'Client/insert', component: ClientInsertComponent },
    { path: 'Client/update/:clientId', component: ClientUpdateComponent },
    /** Order */
    { path: 'Order/orderManagement', component: OrderManagementComponent },
    { path: 'Order/insert', component: OrderInsertComponent },
    { path: 'Order/update/:orderId', component: OrderUpdateComponent },
    /** Project */
    { path: 'Project/projectManagement', component: ProjectManagementComponent },
    { path: 'Project/insert', component: ProjectInsertComponent },
    { path: 'Project/update/:projectId', component: ProjectUpdateComponent },
    /** ProjectTemplate */
    { path: 'ProjectTemplate/projectTemplateManagement', component: ProjectTemplateManagementComponent },
    { path: 'ProjectTemplate/insert', component: ProjectTemplateInsertComponent },
    { path: 'ProjectTemplate/update/:projectTemplateId', component: ProjectTemplateUpdateComponent },
      /** Resource */
    { path: 'Resource/resourceManagement', component: ResourceManagementComponent },
    { path: 'Resource/insert', component: ResourceInsertComponent },
    { path: 'Resource/update/:resourceId', component: ResourceUpdateComponent },
      /** Task */
    { path: 'Task/taskManagement', component: TaskManagementComponent },
    { path: 'Task/insert', component: TaskInsertComponent },
    { path: 'Task/update/:taskId', component: TaskUpdateComponent },
    /** Item */
    { path: 'Item/itemManagement', component: ItemManagementComponent },
    { path: 'Item/insert', component: ItemInsertComponent },
    { path: 'Item/update/:itemId', component: ItemUpdateComponent },
    /** TaskModel */
    { path: 'TaskModel/taskModelManagement', component: TaskModelManagementComponent },
    { path: 'TaskModel/insert', component: TaskModelInsertComponent },
    { path: 'TaskModel/update/:taskModelId', component: TaskModelUpdateComponent },
    /** Project Tree */
    { path: 'ProjectTree/insert/:projectId/:taskFatherId/', component: ProjectTreeInsertNodeComponent },
    { path: 'ProjectTree/treeView/:projectId', component: ProjectTreeViewComponent }
];


@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload', enableTracing: true })],
    declarations: []
})
export class AppRoutingModule {
}
