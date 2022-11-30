import {Component, OnInit} from '@angular/core';
import {TitleService} from "./title.service";

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.scss']
})
export class DefaultComponent implements OnInit {
  organizationName:string ="Наименование организации не заполнено в настройках";

  constructor(private titleService:TitleService) { }

  ngOnInit(): void {
    this.titleService.requestGetTitle().subscribe(result=>{
      console.log(result.name);
      this.organizationName = result.name;
    })
  }

}
