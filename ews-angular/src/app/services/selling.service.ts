import { Injectable } from '@angular/core';

import { Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

import { EWS_URL } from '../../environments/environment';
import { Selling } from '../models/selling.model';

@Injectable()
export class SellingService {

  constructor(private http: HttpClient) { }

  public findAllProducts(): Observable<Selling[]> { 
    return this.http
      .get(`${EWS_URL}getAllProducts`)
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }
}