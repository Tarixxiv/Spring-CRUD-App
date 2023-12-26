import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Star} from "../../star/model/star";
import {Planets} from "../model/planets";
import {Planet} from "../model/planet";
import {StarForm} from "../../star/model/star-form";

@Injectable({
  providedIn: 'root'
})
export class PlanetService {

  constructor(private http: HttpClient) { }

  getPlanetsByStar(uuid: string): Observable<Planets>{
    return this.http.get<Planets>('/api/stars/' + uuid + '/planets')
  }

  getPlanet(uuid: string): Observable<Planet>{
    return this.http.get<Planet>('/api/planets/' + uuid)
  }


  deletePlanet(uuid: string): Observable<any> {
    return  this.http.delete('api/planets/' + uuid);
  }

  /*
  putPlanet(uuid: string, request: PlanetForm): Observable<any> {
    return this.http.put('/api/planets/' + uuid, request)
  }
  */

}
