import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserCreationViewerComponent } from './user-creation-viewer/user-creation-viewer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './services/user-creation-service';

@NgModule({
  declarations: [
    AppComponent,
    UserCreationViewerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTableModule,
    HttpClientModule
  ],
  providers: [UserService, HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
