export interface SegmentTableDto{
  segments: Segment[];
}

interface Segment{
  id:number;
  name:string;
  protocol:string;
  baudRate:number;
  stopBits:string;
  rs485Mode:boolean;
  encoding:string;
  echo:boolean;
  tcpPort:number;
  timeout:number;
  countPlc:number;
}
