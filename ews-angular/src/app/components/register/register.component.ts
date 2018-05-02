import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { User } from '../../models/user.model';
import { ClientMessage } from '../../models/client-message.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  title = "Register";

  //Constructor Injection
  constructor(private loginService: LoginService, private router:Router) { }

  public user: User = new User(0,"","","","","",0,"","","","");
  public repeatPassword: string = "";
  public userData: User = new User(0,"","","","","",0,"","","","");

  public clientMessage: ClientMessage = new ClientMessage("");

  public register(): void {
    if(this.repeatPassword === this.user.password) {
      this.loginService.register(this.user).subscribe(
        data => {
          if (data.hasOwnProperty("message")) {
            if((<ClientMessage>data).message)
            this.clientMessage.message = (<ClientMessage>data).message;
            if(this.clientMessage.message === "REGISTRATION SUCCESSFUL"){
              this.login();
            }
          } else {
            this.clientMessage.message = "Invalid Object";
          }
        },
        error => {
          this.clientMessage.message = "Something went wrong"
        }
      );
    } else {
      this.clientMessage.message = "Your passwords do not match.";
    }
  }

  public login(): void {
    this.loginService.login(this.user).subscribe(
      data => {
        if(data.hasOwnProperty("username")){
          this.userData = <User>data;
          sessionStorage.setItem("loggedUser",JSON.stringify(this.userData));
          this.router.navigate(["all"]);
        } else if (data.hasOwnProperty("message")) {
          this.clientMessage.message = (<ClientMessage>data).message;
        }
      },
      error => {
        this.clientMessage.message = "Something went wrong"
      }
    );
  }

}
