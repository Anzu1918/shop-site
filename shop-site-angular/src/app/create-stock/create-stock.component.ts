import { Component, OnInit } from '@angular/core';
import { StockService } from '../services/stock.service';

@Component({
  selector: 'app-create-stock',
  templateUrl: './create-stock.component.html',
  styleUrls: ['./create-stock.component.css']
})
export class CreateStockComponent implements OnInit {

  code: string;
  unitsSold: string;
  unitsAvailable: string;
  respondeSuccess: boolean = false;
  respondeFail: boolean = false;

  constructor(
    private stockService: StockService
  ) { }

  ngOnInit() {
  }

  submit() {
    console.log('code', this.code);
    console.log('unitsSold', this.unitsSold);
    console.log('unitsAvailable', this.unitsAvailable);

    this.stockService.saveStock({
      code: this.code,
      unitsSold: this.unitsSold,
      unitsAvailable: this.unitsAvailable
    }).subscribe(response => {
      this.code = '';
      this.unitsSold = '';
      this.unitsAvailable = '';
      this.respondeSuccess = true;
      this.respondeFail = false;
    }, error => {
      this.respondeFail = true;
      this.respondeSuccess = false;
    })
  }

}
