import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DefaultComponent} from "./default.component";
import {MatButtonModule} from "@angular/material/button";
import {MatDividerModule} from "@angular/material/divider";
import {MatIconModule} from "@angular/material/icon";
import {RouterModule} from "@angular/router";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {DashboardComponent} from "../../pages/dashboard/dashboard.component";
import {SharedModule} from "../../shared/shared.module";
import {VentilationComponent} from "../../pages/ventilation/ventilation.component";
import {ProfileComponent} from "../../pages/profile/profile.component";
import {UsersViewComponent} from "../../pages/users-view/users-view.component";
import {ItpComponent} from "../../pages/itp/itp.component";
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from "../../pages/login-dialog/login/login.component";



@NgModule({
  declarations: [
    DefaultComponent,
    DashboardComponent,
    LoginComponent,
    VentilationComponent,
    ItpComponent,
    UsersViewComponent,
    ProfileComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    RouterModule,
    MatSidenavModule,
    MatToolbarModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule
  ]
})
export class DefaultModule { }
