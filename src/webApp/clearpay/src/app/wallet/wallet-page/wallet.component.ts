import {Component, Input, OnChanges, SimpleChanges, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {Router} from '@angular/router';
import {Wallet} from '../../model/wallet';
import {WalletService} from '../wallet.service';
import {MatDialog} from '@angular/material/dialog';
import {TransferDialogComponent} from '../../shared/transfer-dialog/transfer-dialog.component';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnChanges {
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @Input() wallet: Wallet[];
  displayedColumns: string[] = ['alias', 'quantity', 'createdDate', 'action'];
  dataSource: MatTableDataSource<Wallet>;
  checked = false;
  disabled = false;

  constructor(private router: Router,
              public service: WalletService,
              private dialog: MatDialog
  ) {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (!!changes.wallet) {
      if (this.wallet && this.wallet.length > 0) {
        this.wallet = changes.wallet.currentValue;
        this.dataSource = new MatTableDataSource<Wallet>(this.wallet);
        this.dataSource.paginator = this.paginator;
        this.dataSource.data = this.wallet;
      }
    }
  }

  update(data: Wallet) {
    this.service.updateProduct(data);
  }

  delete(id: string) {
    this.service.deleteProduct(id);
  }

  walletTransaction(url, row) {
    this.router.navigate([url, row.id]);
  }

  openLoginDialog(): void {
    const dialogRef = this.dialog.open(TransferDialogComponent, {
      width: '300px',
    });
  }
}
