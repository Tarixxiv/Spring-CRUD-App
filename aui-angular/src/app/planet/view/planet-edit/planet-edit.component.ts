import {Component, OnInit} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
import {ActivatedRoute, Router} from "@angular/router";
import {PlanetService} from "../../service/planet.service";
import {PlanetForm} from "../../model/planetForm";

@Component({
  selector: 'app-planet-edit',
  standalone: true,
    imports: [
        FormsModule,
        NgIf,
        ReactiveFormsModule
    ],
  templateUrl: './planet-edit.component.html',
  styleUrl: './planet-edit.component.css'
})
export class PlanetEditComponent implements OnInit{
  uuid: string | undefined
  puuid: string | undefined
  planet: PlanetForm | undefined
  original: PlanetForm | undefined

  constructor(
    private planetService: PlanetService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.uuid = params['uuid'];
      this.puuid = params['puuid'];
      this.planetService.getPlanet(params['puuid'])
        .subscribe(planet => {
          this.planet = {
            name: planet.name,
            population: planet.population,
            star: this.uuid!
          };
          this.original = {...this.planet};
        })

    });
  }

  onSubmit(): void {
    this.planetService.putPlanet(this.puuid!, this.planet!)
      .subscribe(() => this.router.navigate(['/stars/' + this.uuid]))
  }
}
