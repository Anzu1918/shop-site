import { Component, OnInit } from '@angular/core';
import { Item } from '../models/Item';
import { ItemsService } from '../services/items.service';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.css']
})
export class ListItemComponent implements OnInit {

  items: Item[] = [];

  constructor(
    private itemService: ItemsService
  ) { }

  ngOnInit() {
    this.itemService.getItems().subscribe(response => {
      this.items = response as Item[];
    });
  }

}
