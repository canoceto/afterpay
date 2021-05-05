import {Component} from '@angular/core';
import {Observable} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../services/auth/auth.service';
import {UserService} from '../users/user.service';
import {UserClient} from '../model/user';
import {Wallet} from '../model/wallet';
import {WalletService} from '../wallet/wallet.service';

@Component({
  selector: 'app-wallet-container',
  template: `
    <app-transfer-steps
      [users]="users | async"
      [sender]="walletId"
      [wallets]="wallets | async"
      (getWallets)="getWallets($event)"
    >
    </app-transfer-steps>
  `
})

export class TransferContainerComponent {

  public users: Observable<UserClient[]>;
  public walletId: string;
  wallets: Observable<Wallet[]>;


  constructor(private router: Router,
              public service: UserService,
              public walletService: WalletService,
              private authService: AuthService,
              private activeRoute: ActivatedRoute) {

    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/wallet']);
    } else {
      this.activeRoute.params.subscribe(params => {
        if (params.id) {
          this.walletId = params.id;
        } else {
          this.router.navigate(['/wallet']);
        }
        this.users = this.service.getUsers();
      });
    }
  }

  getWallets(userId: string) {
    this.wallets = this.walletService.getWalletList(userId, false);
  }

  makeTransfer() {
  }

}
