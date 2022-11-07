import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import {BreadcrumbComponent} from "./breadcrumb/breadcrumb.component";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {RouterModule} from "@angular/router";
import {MatDividerModule} from "@angular/material/divider";
import { VentStatusTableComponent } from './widgets/vent-status-table/vent-status-table.component';
import {MatTableModule} from "@angular/material/table";
import { ItpStatusCardComponent } from './widgets/itp-status-card/itp-status-card.component';



@NgModule({
  declarations: [
    HeaderComponent,
    SidebarComponent,
    BreadcrumbComponent,
    VentStatusTableComponent,
    ItpStatusCardComponent
  ],
  imports: [
    CommonModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    RouterModule,
    MatDividerModule,
    MatTableModule
  ],
  exports: [
    HeaderComponent,
    SidebarComponent,
    BreadcrumbComponent,
    VentStatusTableComponent,
    ItpStatusCardComponent
  ]
})
export class SharedModule { }
