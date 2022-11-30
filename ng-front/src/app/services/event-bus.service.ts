import {Injectable} from '@angular/core';
import {Subject, Subscription} from "rxjs";
import {filter, map} from "rxjs/operators";
import {EventData} from "./event.data";
import {EventEnum} from "./event.enum";


@Injectable({
  providedIn: 'root'
})
export class EventBusService {
  private subject$ = new Subject();
  constructor() { }

  emit(event:EventData){
    this.subject$.next(event);
  }


  on(eventName:EventEnum,action:any):Subscription{
    return  this.subject$.pipe(
      filter((e:EventData)=>e.name === eventName),
      map((e:EventData)=>e["value"])).subscribe(action);
  }
}
