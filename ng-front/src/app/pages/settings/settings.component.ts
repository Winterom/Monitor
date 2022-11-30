import {Component, OnInit} from '@angular/core';
import {SettingsService} from "./settings.service";
import {SegmentTableDto} from "./SegmentTableDto";

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {
  segments:SegmentTableDto|undefined;

  constructor(private settingsService:SettingsService) { }

  ngOnInit(): void {
    this.settingsService.requestGetSegments().subscribe(segments=>{
      this.segments = segments;
    })
  }

}
