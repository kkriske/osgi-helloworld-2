import { Component } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';

import {
  CalendarEvent
} from 'angular-calendar';

import 'rxjs/Rx';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

@Injectable()
export class AppComponent {
  constructor(
    private http: Http
  ) { }

  title = 'Schedule.it';
  post = 'Loading';
  input = 'World';
  viewDate = new Date();
  events: CalendarEvent[] = [{
    start: new Date(),
    end: new Date('2017-02-23'),
    title: 'A 2 day event',
    color: {
      primary: '#ad2121',
      secondary: '#FAE3E3'
    }
  }];

  ngOnInit() { this.getPost(); }

  getPost() {
    this.http.get(environment.baseUrl + '/api/hello?name=' + this.input)
      .map(res => res.text())
      .subscribe(
        res => this.post = res,
        _ => this.post = 'error'
      )
  };
}
