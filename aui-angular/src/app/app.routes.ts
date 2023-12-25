import {RouterModule, Routes} from '@angular/router';
import {StarListComponent} from "./star/view/star-list/star-list.component";
import {NgModule} from "@angular/core";
import {StarEditComponent} from "./star/view/star-edit/star-edit.component";
import {StarViewComponent} from "./star/view/star-view/star-view.component";

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
    component: StarListComponent,
    path: "planets"
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
