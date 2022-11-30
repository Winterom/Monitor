import {Injectable, OnDestroy} from '@angular/core';
import * as SockJS from 'sockjs-client';
import {CompatClient, Message, Stomp, StompSubscription} from "@stomp/stompjs";
import {BehaviorSubject, filter, first, Observable, switchMap} from "rxjs";
import {SocketClientState} from "./socket.client.state";


@Injectable({
  providedIn: 'root'
})
export class WebSocketService implements OnDestroy {
  private client :CompatClient;
  private state: BehaviorSubject<SocketClientState>;

  constructor() {
    this.state = new BehaviorSubject<SocketClientState>(SocketClientState.ATTEMPTING);
    this.client = Stomp.over(new SockJS('http://localhost:8080/ws'));
    this.client.connect(
      {}, () => {
        this.state.next(SocketClientState.CONNECTED);
      });
  }
  connect(): Observable<CompatClient> {
    return new Observable<CompatClient>(observer => {
      this.state.pipe(filter(state => state === SocketClientState.CONNECTED)).subscribe(() => {
        observer.next(this.client);
      });
    });
  }

  ngOnDestroy(): void {
    this.connect().pipe(first()).subscribe(inst => inst.disconnect(()=>{}));
  }

  onMessage(topic: string, handler = WebSocketService.jsonHandler): Observable<any> {
    return this.connect().pipe(first(), switchMap(inst => {
      return new Observable<any>(observer => {
        const subscription: StompSubscription = inst.subscribe(topic, message => {
          observer.next(handler(message));
        });
        return () => inst.unsubscribe(subscription.id);
      });
    }));
  }

  onPlainMessage(topic: string): Observable<string> {
    return this.onMessage(topic, WebSocketService.textHandler);
  }

  send(topic: string, payload: any): void {
    this.connect()
      .pipe(first())
      .subscribe(inst => inst.send(topic, {}, JSON.stringify(payload)));
  }

  static jsonHandler(message: Message): any {
    return JSON.parse(message.body);
  }

  static textHandler(message: Message): string {
    return message.body;
  }
}


