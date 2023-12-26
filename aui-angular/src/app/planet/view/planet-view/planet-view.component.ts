import {Component, OnInit} from '@angular/core';
import {NgIf} from "@angular/common";
import {PlanetService} from "../../service/planet.service";
import {ActivatedRoute} from "@angular/router";
import {Planet} from "../../model/planet";

@Component({
  selector: 'app-planet-view',
  standalone: true,
    imports: [
        NgIf
    ],
  templateUrl: './planet-view.component.html',
  styleUrl: './planet-view.component.css'
})
export class PlanetViewComponent implements OnInit {
  planet: Planet | undefined

  constructor(private planetService: PlanetService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.planetService.getPlanet(params['uuid']).subscribe(planet => this.planet = planet)
    });
  }
}

