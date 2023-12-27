import {Component, OnInit} from '@angular/core';
import {Stars} from "../../model/stars";
import {StarService} from "../../service/star.service";
import {Star} from "../../model/star";

@Component({
  selector: 'app-star-list',
  templateUrl: './star-list.component.html',
  styleUrl: './star-list.component.css'
})
export class StarListComponent implements OnInit{


  constructor(private service: StarService) {
  }

  stars: Stars | undefined;

  ngOnInit(): void {
    this.service.getStars().subscribe(stars => this.stars = stars);
  }

  onDelete(star: Star): void{
    this.service.deleteStar(star.id).subscribe(() => this.ngOnInit())
  }

}
