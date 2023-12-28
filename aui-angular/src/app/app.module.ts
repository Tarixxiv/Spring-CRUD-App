import { NgModule } from '@angular/core';
import {AppComponent} from "./app.component";
import {MainComponent} from "./component/main/main.component";
import {StarListComponent} from "./star/view/star-list/star-list.component";
import {StarService} from "./star/service/star.service";
import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "./app.routes";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NavComponent} from "./component/nav/nav.component";



@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    MainComponent,
    StarListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers:[
    StarService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
