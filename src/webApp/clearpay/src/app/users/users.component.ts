import {Component,  OnInit,  ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {Router} from '@angular/router';
import {AuthService} from '../services/auth/auth.service';
import {UserService} from './user.service';
import {UserClient} from '../model/user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  users: UserClient[];
  displayedColumns: string[] = ['name', 'wallets', 'balance', 'action'];
  dataSource: MatTableDataSource<UserClient>;
  checked = false;
  disabled = false;

  constructor(private router: Router, private authService: AuthService, private userService: UserService) {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/home']);
    }
  }


  ngOnInit() {
    this.userService.getUsers().subscribe(value => {
      this.users = value;
    });
  }

  update(userClient: UserClient) {
    this.userService.updateUser(userClient);
  }

  delete(id: string) {
    this.userService.deleteUser(id);
  }

  redirectTo(row) {
    this.router.navigateByUrl('wallet/' + row.id);
  }
}
