import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/user/login-page/login-page.component';
import { DashboardPageComponent } from './pages/user/dashboard-page/dashboard-page.component';
import { SplashComponent } from './pages/app/splash/splash.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './pages/home/home.component';
import { HeaderComponent } from './shared/header/header.component';
import { MenuComponent } from './components/menu/menu.component';
import { ServicesPageComponent } from './pages/services/services-page/services-page.component';
import { ServicesListComponent } from './components/services/services-list/services-list.component';
import { PaginationComponent } from './components/services/pagination/pagination.component';
import { CategoryPageComponent } from './pages/services/category-page/category-page.component';
import { provideRouter, withComponentInputBinding } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardPageComponent,
    SplashComponent,
    HomeComponent,
    HeaderComponent,
    MenuComponent,
    ServicesPageComponent,
    ServicesListComponent,
    PaginationComponent,
    CategoryPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
