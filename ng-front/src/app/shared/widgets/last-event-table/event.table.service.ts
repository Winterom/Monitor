import {Injectable} from '@angular/core';
import {WebSocketService} from "../../../services/socket/web-socket.service";
import {Observable} from "rxjs";
import {EventTableResponse} from "./eventTableResponse";

@Injectable({
  providedIn: 'root'
})
export class EventTableService {

  constructor(private socketClient:WebSocketService) { }

  public requestGetLastEvent():Observable<EventTableResponse>{
    return this.socketClient.onMessage('/monitor/events/last');
  }
}
