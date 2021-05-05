import {Component} from '@angular/core';
import {Observable} from 'rxjs';
import {Wallet} from '../model/wallet';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../services/auth/auth.service';
import {TransactionsService} from './transactions.service';
import {Transactions} from '../model/transactions';

@Component({
  selector: 'app-wallet-container',
  template: `
    <app-transactions [transactions]="transactions | async"></app-transactions>
  `
})

export class TransactionsContainerComponent {

  public transactions: Observable<Transactions[]>;
  private getAllTransactions: boolean;
  private walletId: string;


  constructor(private router: Router,
              public service: TransactionsService,
              private authService: AuthService,
              private activeRoute: ActivatedRoute) {

    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/home']);
    } else {
      this.activeRoute.params.subscribe(params => {
        if (params.id) {
          this.getAllTransactions = false;
          this.walletId = params.id;
        } else {
          this.getAllTransactions = true;
        }
        this.transactions = this.service.getTransactionsList(this.walletId, this.getAllTransactions);
      });
    }
  }


}
