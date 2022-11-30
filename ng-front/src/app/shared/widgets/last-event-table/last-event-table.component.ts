import {AfterViewInit, Component} from '@angular/core';
import {SystemEvent} from "./eventTableResponse";
import {EventTableService} from "./event.table.service";

@Component({
  selector: 'app-last-event-table',
  templateUrl: './last-event-table.component.html',
  styleUrls: ['./last-event-table.component.scss']
})
export class LastEventTableComponent implements AfterViewInit {
  displayedColumns: string[] = ['id', 'Дата и время', 'Наименование установки', 'Событие'];
  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;
  dataSource: SystemEvent[] = [];

  constructor(private eventService: EventTableService) {
  }

  ngAfterViewInit() {
    this.eventService.requestGetLastEvent().subscribe(data=>{
      this.dataSource = data.systemEvent;
    })
  }
}
