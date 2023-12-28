import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
import {PlanetForm} from "../../model/planetForm";
import {PlanetService} from "../../service/planet.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-planet-create',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './planet-create.component.html',
  styleUrl: './planet-create.component.css'
})
export class PlanetCreateComponent implements OnInit{
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
      this.uuid = params['uuid']
      this.planet = {
        name: "",
        population: 0,
        star: this.uuid!
      }
    });
  }

  onSubmit(): void {
    this.planetService.putNewPlanet(this.planet!)
      .subscribe(() => this.router.navigate(['/stars/' + this.uuid]))
  }
}
