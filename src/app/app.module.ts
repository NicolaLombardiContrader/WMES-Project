import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

/** Import modules */
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

/** ========= Import component ============ */
import { AppComponent } from './app.component';

/** Shared component */
import { HeaderComponent } from './components/share/header/header.component';
import { FooterComponent } from './components/share/footer/footer.component';
import { SidebarAdminComponent } from './components/share/sidebar-admin/sidebar-admin.component';
import { SidebarBoComponent } from './components/share/sidebar-bo/sidebar-bo.component';
import { SidebarResourceComponent } from './components/share/sidebar-resource/sidebar-resource.component';

/** Home component */
import { LoginComponent } from './components/login/login.component';
import { HomeAdminComponent } from './components/home-admin/home-admin.component';
import { HomeBoComponent } from './components/home-bo/home-bo.component';
import { HomeResourceComponent } from './components/home-resource/home-resource.component';

/** User */
import { UserManagementComponent } from './components/user/user-management/user-management.component';
import { UserUpdateComponent } from './components/user/user-update/user-update.component';
import { UserInsertComponent } from './components/user/user-insert/user-insert.component';

/** Client */
import { ClientManagementComponent } from './components/client/client-management/client-management.component';
import { ClientInsertComponent } from './components/client/client-insert/client-insert.component';
import { ClientUpdateComponent } from './components/client/client-update/client-update.component';

/** Order */
import { OrderManagementComponent } from './components/order/order-management/order-management.component';
import { OrderInsertComponent } from './components/order/order-insert/order-insert.component';
import { OrderUpdateComponent } from './components/order/order-update/order-update.component';

/** Project */
import { ProjectManagementComponent } from './components/project/project-management/project-management.component';
import { ProjectInsertComponent } from './components/project/project-insert/project-insert.component';
import { ProjectUpdateComponent } from './components/project/project-update/project-update.component';

/** ProjectTemplate */
// tslint:disable-next-line:max-line-length
import { ProjectTemplateManagementComponent } from './components/project-template/project-template-management/project-template-management.component';
import { ProjectTemplateInsertComponent } from './components/project-template/project-template-insert/project-template-insert.component';
import { ProjectTemplateUpdateComponent } from './components/project-template/project-template-update/project-template-update.component';

/** Resource */
import { ResourceManagementComponent } from './components/resource/resource-management/resource-management.component';
import { ResourceInsertComponent } from './components/resource/resource-insert/resource-insert.component';
import { ResourceUpdateComponent } from './components/resource/resource-update/resource-update.component';

/** Task */
import { TaskManagementComponent } from './components/task/task-management/task-management.component';
import { TaskInsertComponent } from './components/task/task-insert/task-insert.component';
import { TaskUpdateComponent } from './components/task/task-update/task-update.component';

/** Item */
import { ItemManagementComponent } from './components/item/item-management/item-management.component';
import { ItemUpdateComponent } from './components/item/item-update/item-update.component';
import { ItemInsertComponent } from './components/item/item-insert/item-insert.component';
import { TaskUpdateResourceComponent } from './components/task/task-update-resource/task-update-resource.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    SidebarAdminComponent,
    SidebarBoComponent,
    SidebarResourceComponent,
    HomeAdminComponent,
    HomeBoComponent,
    UserManagementComponent,
    UserUpdateComponent,
    UserInsertComponent,
    HomeResourceComponent,
    ClientManagementComponent,
    ClientInsertComponent,
    ClientUpdateComponent,
    OrderManagementComponent,
    OrderInsertComponent,
    OrderUpdateComponent,
    ProjectManagementComponent,
    ProjectInsertComponent,
    ProjectUpdateComponent,
    ProjectTemplateManagementComponent,
    ProjectTemplateInsertComponent,
    ProjectTemplateUpdateComponent,
    ResourceManagementComponent,
    ResourceInsertComponent,
    ResourceUpdateComponent,
    TaskManagementComponent,
    TaskInsertComponent,
    TaskUpdateComponent,
    ItemManagementComponent,
    ItemUpdateComponent,
    ItemInsertComponent,
    TaskUpdateResourceComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
