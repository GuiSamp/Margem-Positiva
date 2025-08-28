import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-input-base',
  imports: [],
  templateUrl: './input-base.html',
  styleUrl: './input-base.css',
})
export class InputBase {
  @Input() name!: string;

  @Input() id!: string;

  @Input() type!: string;

  @Input() placeholder!: string;

  @Input() pathIcon!: string;
}
