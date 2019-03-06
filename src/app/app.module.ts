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
    OrderUpdateComponent
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
