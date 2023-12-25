import {Component, OnInit} from '@angular/core';
import {StarService} from "../../service/star.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Star} from "../../model/star";
import {NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-star-view',
  standalone: true,
    imports: [
        NgIf,
        FormsModule
    ],
  templateUrl: './star-view.component.html',
  styleUrl: './star-view.component.css'
})
export class StarViewComponent implements OnInit{
  star: Star | undefined
  constructor(private service: StarService,
              private route: ActivatedRoute,
              private router: Router) {
  }
  ngOnInit(): void {
    this.route.params.subscribe(params =>{
      this.service.getStar(params['uuid']).subscribe(star => this.star = star)
    })
  }

}
