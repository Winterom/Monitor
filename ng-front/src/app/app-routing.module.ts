import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DefaultComponent} from "./layout/default/default.component";
import {DashboardComponent} from "./pages/dashboard/dashboard.component";
import {VentilationComponent} from "./pages/ventilation/ventilation.component";
import {ItpComponent} from "./pages/itp/itp.component";
import {UsersViewComponent} from "./pages/users-view/users-view.component";
import {ProfileComponent} from "./pages/profile/profile.component";
import {LoginDialogComponent} from "./pages/login-dialog/login-dialog.component";
import {SettingsComponent} from "./pages/settings/settings.component";


const routes: Routes = [{
  path: '',
  component: DefaultComponent,
  children: [{
    path: '',
    component: DashboardComponent,
    data: {breadcrumb: 'Информационная панель'}
  },{
    path:'vent',
    component:VentilationComponent,
    data: {breadcrumb: 'Система вентиляции'}
  },{
    path:'itp',
    component:ItpComponent,
    data: {breadcrumb: 'Индивидуальный тепловой пункт'},
  },{
    path:'users',
    component:UsersViewComponent,
    data: {breadcrumb: 'Пользователи'},
  },{
    path:'profile',
    component:ProfileComponent,
    data: {breadcrumb: 'Профиль пользователя'},
  },{
    path:'settings',
    component:SettingsComponent,
    data: {breadcrumb: 'Настройки'},
  }
  ]},
  {
    path: 'login',
    component: LoginDialogComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
