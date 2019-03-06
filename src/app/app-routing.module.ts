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

const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'homeAdmin', component: HomeAdminComponent },
    { path: 'homeBO', component: HomeBoComponent },
    { path: 'homeResource', component: HomeResourceComponent },
    /** User */
    { path: 'User/userManagement', component: UserManagementComponent },
    { path: 'User/insert', component: UserInsertComponent },
    { path: 'User/update', component: UserUpdateComponent },
    /** Client */
    { path: 'Client/clientManagement', component: ClientManagementComponent },
    { path: 'Client/insert', component: ClientInsertComponent },
    { path: 'Client/update', component: ClientUpdateComponent },
    /** Order */
    { path: 'Order/orderManagement', component: OrderManagementComponent },
    { path: 'Order/insert', component: OrderInsertComponent },
    { path: 'Order/update', component: OrderUpdateComponent },
];

@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { useHash: true, onSameUrlNavigation: 'reload', enableTracing: true })],
    declarations: []
})
export class AppRoutingModule {
}
