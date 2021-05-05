import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home/home.component';
import {UsersComponent} from './users/users.component';
import {WalletContainerComponent} from './wallet/wallet-container.component';
import {TransactionsContainerComponent} from './transactions/transactions-container.component';
import {TransferContainerComponent} from './transfer-steps/transfer-container.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'user', component: UsersComponent},
  {path: 'user/:id', component: UsersComponent},
  {path: 'wallet', component: WalletContainerComponent},
  {path: 'wallet/:id', component: WalletContainerComponent},
  {path: 'transaction', component: TransactionsContainerComponent},
  {path: 'transaction/:id', component: TransactionsContainerComponent},
  {path: 'transfer/:id', component: TransferContainerComponent},
  {path: '**', redirectTo: '/home'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
