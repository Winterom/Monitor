import {CommonApi} from "./common.api";

export class SegmentApi extends CommonApi{
  private _getSegmentTable:string = 'segments/table';

  get getSegmentTable(): string {
    return super.applicationPrefix+this._getSegmentTable;
  }
}
