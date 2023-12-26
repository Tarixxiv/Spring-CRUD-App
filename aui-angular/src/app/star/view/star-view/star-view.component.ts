import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {Star} from "../../model/star";
import {NgForOf, NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {Planets} from "../../../planet/model/planets";
import {StarService} from "../../service/star.service";
import {PlanetService} from "../../../planet/service/planet.service";
import {Planet} from "../../../planet/model/planet";

@Component({
  selector: 'app-star-view',
  standalone: true,
  imports: [
    NgIf,
    FormsModule,
    NgForOf,
    RouterLink
  ],
  templateUrl: './star-view.component.html',
  styleUrl: './star-view.component.css'
})
export class StarViewComponent implements OnInit{
  star: Star | undefined
  planets: Planets | undefined
  constructor(private starService: StarService,
              private planetService: PlanetService,
              private route: ActivatedRoute,
              private router: Router) {
  }
  ngOnInit(): void {
    this.route.params.subscribe(params =>{
      this.starService.getStar(params['uuid']).subscribe(star => this.star = star)
      this.planetService.getPlanetsByStar(params['uuid'])
        .subscribe(planets => this.planets = planets)
    })
  }

  onDelete(planet: Planet): void{
    this.planetService.deletePlanet(planet.id).subscribe(() => this.ngOnInit())
  }

}
