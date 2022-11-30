import {Injectable} from '@angular/core';
import {WebSocketService} from "../../services/socket/web-socket.service";
import {SegmentApi} from "../../services/socket/api/segment.api";
import {Observable} from "rxjs";
import {SegmentTableDto} from "./SegmentTableDto";

@Injectable({
  providedIn: 'root'
})
export class SettingsService {

  constructor(private socketClient:WebSocketService, private api:SegmentApi) { }

  public requestGetSegments():Observable<SegmentTableDto>{
    return this.socketClient.onMessage(this.api.getSegmentTable);
  }
}
