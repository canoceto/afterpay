import {Component, Input, OnChanges, SimpleChanges, ViewChild} from '@angular/core';
import {Transactions} from '../../model/transactions';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {TransactionsService} from '../transactions.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnChanges {
  @Input() transactions: Transactions[];
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  displayedColumns: string[] = ['walletId', 'action', 'amount', 'to', 'date', 'id'];
  dataSource: MatTableDataSource<Transactions>;
  checked = false;
  disabled = false;

  constructor(public service: TransactionsService) {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (!!changes.transactions) {
      if (this.transactions && this.transactions.length > 0) {
        this.transactions = changes.transactions.currentValue;
        this.dataSource = new MatTableDataSource<Transactions>(this.transactions);
        this.dataSource.paginator = this.paginator;
        this.dataSource.data = this.transactions;
      }
    }
  }

  update(data: Transactions) {
    // this.service.updateProduct(data);
  }

  delete(id: string) {
    // this.service.deleteProduct(id);
  }

}
