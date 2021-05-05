import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {UserClient} from '../model/user';
import {Wallet} from '../model/wallet';
import {MatHorizontalStepper} from '@angular/material/stepper';
import {UtilService} from '../services/util.service';
import {Transactions} from '../model/transactions';

@Component({
  selector: 'app-transfer-steps',
  templateUrl: './transfer-steps.component.html',
  styleUrls: ['./transfer-steps.component.css']
})
export class TransferStepsComponent implements OnInit, OnChanges {
  @Input() sender: string;
  @Input() users: UserClient[];
  @Input() wallets: Wallet[];
  @Output() getWallets = new EventEmitter<string>();
  editable = true;
  matcher = new MyErrorStateMatcher();
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  amountFormGroup: FormGroup;

  selected: FormControl;
  walletSelected: FormControl;
  amountInput: FormControl;

  transactionData: Transactions;

  constructor(private formBuilder: FormBuilder, private utilService: UtilService) {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes.users) {
      if (this.users && this.users.length > 0) {
        this.firstFormGroup = this.formBuilder.group({
          selectFormControl: ['', Validators.required]
        });
        this.secondFormGroup = this.formBuilder.group({
          secondCtrl: ['', Validators.required]
        });
      }
    }
    if (changes.wallets) {
      if (this.wallets && this.wallets.length > 0) {
        this.firstFormGroup = this.formBuilder.group({
          selectFormControl: ['']
        });
        this.secondFormGroup = this.formBuilder.group({
          secondCtrl: ['']
        });
      }
    }
    this.selected = new FormControl('valid', [
      Validators.required,
    ]);
    this.walletSelected = new FormControl('valid', [
      Validators.required,
    ]);
    this.amountInput = new FormControl('valid', [
      Validators.required,
    ]);
  }

  ngOnInit() {
    this.firstFormGroup = this.formBuilder.group({
      selectFormControl: ['']
    });
    this.secondFormGroup = this.formBuilder.group({
      walletSelected: ['', Validators.required]
    });
    this.amountFormGroup = this.formBuilder.group({
      amountInput: ['']
    });
  }

  checkBalance(stepper: MatHorizontalStepper) {
    this.nextStep(stepper);
    this.utilService.makeTransfer(this.sender, this.amountInput.value, this.walletSelected.value.id).subscribe(value => {
      if (value == null) {
        setTimeout(() => {
          this.previousStep(stepper);
        }, 5000);
      } else {
        this.transactionData = value;
        this.nextStep(stepper);
        this.editable = false;
      }
    });
  }

  nextStep(stepper: MatHorizontalStepper) {
    stepper.next();
  }

  previousStep(stepper: MatHorizontalStepper) {
    stepper.previous();
  }
}

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
