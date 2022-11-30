export class CommonApi{
  private _applicationPrefix = 'monitor/';

  set applicationPrefix(value: string) {
    this._applicationPrefix = value;
  }
}
