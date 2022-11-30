import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeaderComponent} from './header/header.component';
import {SidebarComponent} from './sidebar/sidebar.component';
import {BreadcrumbComponent} from "./breadcrumb/breadcrumb.component";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {RouterModule} from "@angular/router";
import {MatDividerModule} from "@angular/material/divider";
import {MatTableModule} from "@angular/material/table";
import {MonitorCardComponent} from './widgets/monitor-card/monitor-card.component';
import {VentCardComponent} from './widgets/vent-card/vent-card.component';
import {ItpCardComponent} from './widgets/itp-card/itp-card.component';
import {MatCardModule} from "@angular/material/card";
import {LastEventTableComponent} from './widgets/last-event-table/last-event-table.component';
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";


@NgModule({
  declarations: [
    HeaderComponent,
    SidebarComponent,
    BreadcrumbComponent,
    MonitorCardComponent,
    VentCardComponent,
    ItpCardComponent,
    LastEventTableComponent,
  ],
  imports: [
    CommonModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    RouterModule,
    MatDividerModule,
    MatTableModule,
    MatCardModule,
    MatProgressSpinnerModule
  ],
  exports: [
    HeaderComponent,
    SidebarComponent,
    BreadcrumbComponent,
    MonitorCardComponent,
    VentCardComponent,
    ItpCardComponent,
    LastEventTableComponent,
  ]
})
export class SharedModule { }
