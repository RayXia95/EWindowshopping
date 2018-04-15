import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/user.model';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
    let user: User = this.loginService.getLoggedUser();
    console.log(`Logged User before logout: ${JSON.stringify(user)}`);
    
    sessionStorage.setItem("loggedUser","{}");
    console.log(`Logged User after logout: ${this.loginService.getLoggedUser()}`);
    this.router.navigate(["login"]);
  }


}
