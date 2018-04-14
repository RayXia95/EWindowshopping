import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { HttpClient } from '@angular/common/http';
import 'rxjs/Rx';
import { Purchase } from '../models/purchase.model';
import { EWS_URL,ACCESS_KEY_ID,SECRET_ACCESS_KEY, BUCKET } from '../../environments/environment';
import { ClientMessage } from '../models/client-message.model'; 
import { Selling } from '../models/selling.model';
import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';

@Injectable()
export class SellingService {
  FOLDER = 'images/';
  constructor(private http:HttpClient) {}
 

  public sellingProduct(selling:Selling): Observable<ClientMessage>{
    return this.http
    .post(`${EWS_URL}selling`,selling)
    .catch(this.handleError);
  }
  private handleError(error: Response){
    return Observable.throw(error.statusText);
  }
}