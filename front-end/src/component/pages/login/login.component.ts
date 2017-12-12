import {Component, OnInit} from '@angular/core';
import {PageComponent} from "../../page.component";
import {UserCredentials} from "../../../model/user/user-credentials";
import {SecurityService} from "../../../service/security-service/security.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent extends PageComponent {


  credentials: UserCredentials;
  error: string;

  constructor(private readonly security: SecurityService, private readonly router: Router) {
    super();
    this.credentials = new UserCredentials('', '');
    this.error = '';
  }

  tryAuth() {
    this.security.auth(this.credentials, (message, result) => {
      if (result) {
        this.error = '';
        this.credentials.login = '';
        this.credentials.password = '';
        this.router.navigateByUrl('/');
      }
      else {
        this.error = message;
      }
    });
  }
}
