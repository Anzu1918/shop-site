import { Component, OnInit } from '@angular/core';
import { Stock } from '../models/Stock';
import { ItemsService } from '../services/items.service';
import { StockService } from '../services/stock.service';

@Component({
  selector: 'app-create-item',
  templateUrl: './create-item.component.html',
  styleUrls: ['./create-item.component.css']
})
export class CreateItemComponent implements OnInit {

  code: string;
  name: string;
  amount: number;
  inventoryCode: string;
  stockId: number;
  stockCode: string;
  stocks: Stock[] = [];
  existStocks: boolean = true;
  respondeSuccess: boolean = false;
  respondeFail: boolean = false;

  constructor(
    private stockService: StockService,
    private itemService: ItemsService
  ) { }

  ngOnInit() {
    this.stockService.getStock().subscribe(response => {
      this.stocks = response as Stock[];
      
      if (this.stocks && this.stocks.length > 0) {
        this.existStocks = true;
      } else {
        this.existStocks = false;  
      }
    }, error => {
      this.existStocks = false;
    });
  }

  saveItem() {
    if (this.stockId) {
      this.itemService.saveItem({
        amount: this.amount,
        code: this.code,
        inventoryCode: this.inventoryCode,
        name: this.name,
        stockId: this.stockId
      }).subscribe(response => {
        this.respondeSuccess = true;
        this.respondeFail = false;
  
        this.code = '';
        this.amount = null;
        this.inventoryCode = '';
        this.stockId = null;
        this.stockCode = '';
        this.name = '';
      }, error => {
        this.respondeSuccess = false;
        this.respondeFail = true;
      });
    } else {
      this.respondeSuccess = false;
      this.respondeFail = true;
    }
  }

}
