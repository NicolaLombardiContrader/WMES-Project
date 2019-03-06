import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

/** Login */
import { LoginComponent } from './components/login/login.component';
/** Home */
import { HomeAdminComponent } from './components/home-admin/home-admin.component';

const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'homeAdmin', component: HomeAdminComponent}
];

@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { useHash: true, onSameUrlNavigation: 'reload', enableTracing: true })],
    declarations: []
})
export class AppRoutingModule {
}
