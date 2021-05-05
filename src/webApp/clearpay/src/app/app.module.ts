import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AngularFireModule} from '@angular/fire';
import {AngularFireAuthModule} from '@angular/fire/auth';
import {environment} from '../environments/environment';

import {MatPaginatorModule} from '@angular/material/paginator';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatSortModule} from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatSelectModule} from '@angular/material/select';
import {ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToolbarComponent} from './toolbar/toolbar.component';
import {LayoutModule} from '@angular/cdk/layout';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {HomeComponent} from './home/home/home.component';
import {LoginDialogComponent} from './shared/login-dialog/login-dialog.component';
import {UsersComponent} from './users/users.component';
import {UserService} from './users/user.service';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {WalletComponent} from './wallet/wallet-page/wallet.component';
import {WalletContainerComponent} from './wallet/wallet-container.component';
import {TransactionsComponent} from './transactions/transactions-page/transactions.component';
import {TransactionsContainerComponent} from './transactions/transactions-container.component';
import {TransferDialogComponent} from './shared/transfer-dialog/transfer-dialog.component';
import {TransferStepsComponent} from './transfer-steps/transfer-steps.component';
import {MatStepperModule} from '@angular/material/stepper';
import {TransferContainerComponent} from './transfer-steps/transfer-container.component';
import {AuthInterceptorService} from './services/auth-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    HomeComponent,
    LoginDialogComponent,
    WalletComponent,
    WalletContainerComponent,
    UsersComponent,
    TransactionsComponent,
    TransactionsContainerComponent,
    TransferDialogComponent,
    TransferContainerComponent,
    TransferStepsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireAuthModule,
    LayoutModule,
    MatStepperModule,
    MatToolbarModule,
    HttpClientModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatMenuModule,
    MatCardModule,
    MatGridListModule,
    MatListModule,
    MatInputModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatButtonToggleModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatDialogModule,
    MatInputModule
  ],
  providers: [UserService, {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptorService,
    multi: true
  }, ],
  entryComponents: [LoginDialogComponent],
  exports: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
