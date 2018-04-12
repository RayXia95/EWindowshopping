import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { HttpClient } from '@angular/common/http';
import 'rxjs/Rx';
import { Purchase } from '../models/purchase.model';
import { EWC_URL } from '../../environments/environment';
import { ClientMessage } from '../models/client-message.model'; 


@Injectable()
export class PurchaseService {

  constructor(private http:HttpClient) { }

  public purchaseProduct(purchase:Purchase): Observable<ClientMessage>{
    return this.http
    .post(`${EWC_URL}purchase`,purchase)
    .catch(this.handleError);
  }
  private handleError(error: Response){
    return Observable.throw(error.statusText);
  }
}
