import {Component, OnInit} from '@angular/core';
import {StarService} from "../../service/star.service";
import {ActivatedRoute, Router} from "@angular/router";
import {StarForm} from "../../model/star-form";
import {FormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-star-edit',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './star-edit.component.html',
  styleUrl: './star-edit.component.css'
})
export class StarEditComponent implements OnInit{
  uuid: string | undefined
  star: StarForm | undefined
  original: StarForm | undefined

  constructor(
    private starService: StarService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.starService.getStar(params['uuid'])
        .subscribe(star => {
          this.uuid = star.id;
          this.star = {
            name: star.name,
            age: star.age
          };
          this.original = {...this.star};
        })
      });
  }

  onSubmit(): void {
    this.starService.putStar(this.uuid!, this.star!)
      .subscribe(() => this.router.navigate(['/stars']))
  }


}
