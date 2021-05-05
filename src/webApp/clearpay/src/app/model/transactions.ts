export interface Transactions {
  id?: string;
  walletId?: string;

  idWalletReceptor: string;
  action: string;
  amount: number;
  date: Date;
}
