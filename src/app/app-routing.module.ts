import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
/** Login */
import { LoginComponent } from './components/login/login.component';
/** User Management */


const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent }
];

@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { useHash: true, onSameUrlNavigation: 'reload', enableTracing: true })],
    declarations: []
})
export class AppRoutingModule {
}
