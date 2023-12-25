import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Stars} from "../model/stars";
import {Star} from "../model/star";
import {StarForm} from "../model/star-form";

@Injectable()
export class StarService {

  constructor(private http: HttpClient) { }

  getStars(): Observable<Stars> {
    return this.http.get<Stars>('/api/stars');
  }

  getStar(uuid: string): Observable<Star>{
    return this.http.get<Star>('/api/stars/' + uuid);
  }

  deleteStar(uuid: string): Observable<any> {
    return  this.http.delete('api/stars/' + uuid);
  }


  putStar(uuid: string, request: StarForm): Observable<any> {
    return this.http.put('/api/stars/' + uuid, request)
  }


}
