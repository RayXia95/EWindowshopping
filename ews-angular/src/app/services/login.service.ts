import { Injectable } from '@angular/core';

import { Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import 'rxjs/Rx';

import { User } from '../models/user.model';
import { ClientMessage } from '../models/client-message.model';
import { EWS_URL } from '../../environments/environment';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  public login(user: User) : Observable<Object> {
    return this.http
                .post(`${EWS_URL}login`,user)
                .catch(this.handleError);
  }

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }
}
