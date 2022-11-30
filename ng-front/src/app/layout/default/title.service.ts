import {Injectable} from '@angular/core';
import {WebSocketService} from "../../services/socket/web-socket.service";
import {Observable} from "rxjs";
import {TitleResponse} from "./TitleResponse";


@Injectable({
  providedIn: 'root'
})
export class TitleService {

  constructor(private socketClient:WebSocketService) { }

  public requestGetTitle():Observable<TitleResponse>{
    return this.socketClient.onMessage('/monitor/settings/last');
  }
}
