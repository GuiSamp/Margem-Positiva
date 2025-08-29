import { Component, input, Input } from '@angular/core';
import { FormControl, ɵInternalFormsSharedModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-input-base',
  imports: [ɵInternalFormsSharedModule, ReactiveFormsModule],
  templateUrl: './input-base.html',
})
export class InputBase {
  @Input() name!: string;

  @Input() id!: string;

  @Input() type!: string;

  @Input() placeholder!: string;

  @Input() pathIcon!: string;

  @Input() control!: FormControl;
}
