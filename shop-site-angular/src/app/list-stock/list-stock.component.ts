import { Component, OnInit } from '@angular/core';
import { Stock } from '../models/Stock';
import { StockService } from '../services/stock.service';

@Component({
  selector: 'app-list-stock',
  templateUrl: './list-stock.component.html',
  styleUrls: ['./list-stock.component.css']
})
export class ListStockComponent implements OnInit {

  stocks: Stock[] = [];

  constructor(
    private stockService: StockService
  ) { }

  ngOnInit() {
    this.stockService.getStock().subscribe(response => {
      this.stocks = response as Stock[];
    });
  }

}
