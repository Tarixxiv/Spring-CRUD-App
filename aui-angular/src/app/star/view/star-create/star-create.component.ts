import {Component, OnInit} from '@angular/core';
import {StarService} from "../../service/star.service";
import {StarForm} from "../../model/star-form";
import {FormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
import {Router} from "@angular/router";

@Component({
  selector: 'app-star-create',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './star-create.component.html',
  styleUrl: './star-create.component.css'
})
export class StarCreateComponent implements OnInit{
  star: StarForm | undefined
    uuid: string | null | undefined

  constructor(
    private starService: StarService,
    private router: Router
  ) {
  }
  ngOnInit(): void {
    this.star = {
      name: "",
        age: 0
    }
    this.uuid = null
  }

    onSubmit(): void {
        this.starService.putNewStar(this.star!)
            .subscribe(() => this.router.navigate(['']))

    }




}
