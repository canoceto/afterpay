import {Component} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {MatDialog} from "@angular/material/dialog";

import {LoginDialogComponent} from "../login-dialog/login-dialog.component";


@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent {

  constructor(private auth: AuthService, private dialog: MatDialog) {
  }

  loginLogout() {
    if (this.isLoggedIn()) {
      this.auth.logout();
    } else {
      this.openLoginDialog();
    }
  }

  isLoggedIn(): boolean {
    return this.auth.isLoggedIn();
  }

  getUser() {
    return this.auth.user;
  }

  getUserName() {
    const user = this.getUser();
    return !!user ? user.email : "Not logged";
  }

  getUserPhoto() {
    const user = this.getUser();
    return (!!user && !!user.photoURL)
      ? user.photoURL
      : "https://www.materialui.co/materialIcons/social/person_outline_white_192x192.png";
  }

  openLoginDialog(): void {
    const dialogRef = this.dialog.open(LoginDialogComponent, {
      width: "300px",
    });
  }

}
