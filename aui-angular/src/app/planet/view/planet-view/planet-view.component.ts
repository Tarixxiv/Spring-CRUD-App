import {Component, OnInit} from '@angular/core';
import {NgIf} from "@angular/common";
import {PlanetService} from "../../service/planet.service";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {Planet} from "../../model/planet";
import {Star} from "../../../star/model/star";
import {StarService} from "../../../star/service/star.service";

@Component({
  selector: 'app-planet-view',
  standalone: true,
  imports: [
    NgIf,
    RouterLink
  ],
  templateUrl: './planet-view.component.html',
  styleUrl: './planet-view.component.css'
})
export class PlanetViewComponent implements OnInit {
  planet: Planet | undefined
  star: Star | undefined

  constructor(private planetService: PlanetService,
              private starService: StarService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.planetService.getPlanet(params['puuid']).subscribe(planet => this.planet = planet)
      this.starService.getStar(params['uuid']).subscribe(star => this.star = star)
    });
  }
}

