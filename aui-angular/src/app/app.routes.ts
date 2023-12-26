import {RouterModule, Routes} from '@angular/router';
import {StarListComponent} from "./star/view/star-list/star-list.component";
import {NgModule} from "@angular/core";
import {StarEditComponent} from "./star/view/star-edit/star-edit.component";
import {StarViewComponent} from "./star/view/star-view/star-view.component";
import {PlanetEditComponent} from "./planet/view/planet-edit/planet-edit.component";
import {PlanetViewComponent} from "./planet/view/planet-view/planet-view.component";

export const routes: Routes = [
  {
    component: StarListComponent,
    path: "stars"
  },
  {
    component: StarEditComponent,
    path: "stars/:uuid/edit"
  },
  {
    component: StarViewComponent,
    path: "stars/:uuid"
  },
  {
    component: PlanetViewComponent,
    path: "stars/:uuid/planets/:puuid"
  },
  {
    component: PlanetEditComponent,
    path: "stars/:uuid/planets/:puuid/edit"
  }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
