import { InputComponent } from './input/input.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DogadjajComponent } from './dogadjaj/dogadjaj.component';

@NgModule({
  declarations: [
    AppComponent,
    InputComponent,
    DogadjajComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


