import {EventType} from "./event.type";

export interface EventTableResponse {
  systemEvent: SystemEvent[];
}

export interface SystemEvent{
  id:number;
  dateTime: string;
  nameEquipment: string;
  eventType:EventType;
  message:string;
}
