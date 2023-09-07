import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/user/login-page/login-page.component';
import { DashboardPageComponent } from './pages/user/dashboard-page/dashboard-page.component';
import { ServicesPageComponent } from './pages/services-page/services-page.component';

const routes: Routes = [{
  component: HomeComponent,
  path: 'home',
}, {
  path: "",
  redirectTo: "/home",
  pathMatch: "full"
}, {
  component: LoginComponent,
  path: "login",
}, {
  component: DashboardPageComponent,
  path: "dashboard"
}, {
  component: ServicesPageComponent,
  path: "services"
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
