import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-transfer-dialog',
  templateUrl: './transfer-dialog.component.html',
  styleUrls: ['./transfer-dialog.component.css']
})
export class TransferDialogComponent implements OnInit {

  constructor(private dialogRef: MatDialogRef<TransferDialogComponent>) {
  }

  ngOnInit(): void {
  }

}
