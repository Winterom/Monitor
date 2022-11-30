import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {DefaultModule} from "./layout/default/default.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {LoginDialogComponent} from './pages/login-dialog/login-dialog.component';
import {SettingsComponent} from './pages/settings/settings.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginDialogComponent,
    SettingsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DefaultModule,
    BrowserAnimationsModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
