import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { User } from '../../models/user.model';
import { ClientMessage } from '../../models/client-message.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  title = "Login";

  //Constructor Injection
  constructor(private loginService: LoginService) { }

  public user: User = new User(0,"","","","","",0,"","","","");
  public userData: User = new User(0,"","","","","",0,"","","","");

  public clientMessage: ClientMessage = new ClientMessage("");

  public login(): void {
    this.loginService.login(this.user).subscribe(
      data => {
        if(data instanceof User){
          this.userData = data;
        } else if (data instanceof ClientMessage) {
          this.clientMessage = data;
        } else {
          this.clientMessage.message = "Invalid Object";
        }
      },
      error => {
        this.clientMessage.message = "Something went wrong"
      }
    );
  }

}
