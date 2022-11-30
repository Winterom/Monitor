import {Component, Input, OnInit} from '@angular/core';
import {CardData, CardType} from "./card.data";

@Component({
  selector: 'app-monitor-card',
  templateUrl: './monitor-card.component.html',
  styleUrls: ['./monitor-card.component.scss']
})
export class MonitorCardComponent implements OnInit {

  @Input() cardData: CardData | undefined;
  defaultCardData: CardData=new class implements CardData {
  content: string = '';
  count: number=0;
  type: CardType=CardType.BLUE;
};
  constructor() {
  }

  ngOnInit(): void {
    if(this.cardData){
      this.defaultCardData = this.cardData;
    }
  }

  getClass():string{
    switch (this.defaultCardData.type){
      case CardType.RED: return 'color-red';
      case CardType.BLUE: return 'color-blue';
      case CardType.AZURE: return 'color-azure';
      case CardType.YELLOW: return 'color-yellow';
    }
  }

}
