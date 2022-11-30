import {Component, OnInit} from '@angular/core';
import {CardData, CardType} from "../../shared/widgets/monitor-card/card.data";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  systemDescription:CardData = new class implements CardData {
    content: string = 'Контроллеров в системе ';
    count: number=42;
    type: CardType=CardType.BLUE;
  };
  structureDescription:CardData = new class implements CardData {
    content: string = 'Установок в системе';
    count: number=25;
    type: CardType=CardType.AZURE
  };
  nonCriticalError:CardData = new class implements CardData {
    content: string = 'Контроллеров с некритическими ошибками';
    count: number=4;
    type: CardType=CardType.YELLOW
  };
  criticalError:CardData = new class implements CardData {
    content: string = 'Контроллеров с критическими ошибками';
    count: number=2;
    type: CardType=CardType.RED
  };
  constructor() { }

  ngOnInit(): void {
  }

}
