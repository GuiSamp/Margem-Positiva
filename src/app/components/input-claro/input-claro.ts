import { Component, Input } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-input-claro',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './input-claro.html',
})
export class InputClaro {
  @Input() control!: FormControl;
  @Input() placeholder: string = '';
  @Input() id: string = '';
  @Input() type: string = 'text';
}