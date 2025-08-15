import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-input-field',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './input-field.html',
})
export class InputFieldComponent {

  // O ID único para o campo, usado no `for` do label e no `id` do input.
  @Input() id: string = '';

  // O tipo do input: 'text', 'email', 'password', etc.
  @Input() type: string = 'text';

  // O texto que aparecerá como placeholder.
  @Input() placeholder: string = '';

}