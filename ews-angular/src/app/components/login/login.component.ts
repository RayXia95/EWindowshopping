import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { User } from '../../models/user.model';
import { ClientMessage } from '../../models/client-message.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  title = "Login";

  //Constructor Injection
  constructor(private loginService: LoginService, private router:Router) { }

  public user: User = new User(0,"","","","","",0,"","","","");
  public userData: User = new User(0,"","","","","",0,"","","","");

  public clientMessage: ClientMessage = new ClientMessage("");

  public login(): void {
    this.loginService.login(this.user).subscribe(
      data => {
        if(data.hasOwnProperty("username")){
          this.userData = <User>data;
          sessionStorage.setItem("loggedUser",JSON.stringify(this.userData));
          this.clientMessage.message = "Login Success";
          this.router.navigate(["all"]);
          //console.log(<User>JSON.parse(sessionStorage.getItem("loggedUser")).username);
        } else if (data.hasOwnProperty("message")) {
          this.clientMessage.message = (<ClientMessage>data).message;
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
