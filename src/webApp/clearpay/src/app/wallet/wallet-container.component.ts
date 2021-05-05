import {Component} from '@angular/core';
import {Observable} from 'rxjs';
import {Wallet} from '../model/wallet';
import {ActivatedRoute, Router} from '@angular/router';
import {WalletService} from './wallet.service';
import {AuthService} from '../services/auth/auth.service';

@Component({
  selector: 'app-wallet-container',
  template: `
    <app-wallet [wallet]="wallet | async"></app-wallet>
  `
})

export class WalletContainerComponent {

  public wallet: Observable<Wallet[]>;
  private getAllWallet: boolean;
  private userId: string;


  constructor(private router: Router,
              public service: WalletService,
              private authService: AuthService,
              private activeRoute: ActivatedRoute) {

    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/home']);
    } else {
      this.activeRoute.params.subscribe(params => {
        if (params.id) {
          this.getAllWallet = false;
          this.userId = params.id;
        } else {
          this.getAllWallet = true;
        }
        this.wallet = this.service.getWalletList(this.userId, this.getAllWallet);
      });
    }
  }


}
