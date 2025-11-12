import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-header-pagina',
  standalone: true,
  imports: [],
  templateUrl: './header-pagina.html',
})
export class HeaderPagina {
  @Input() logoUrl: string = '/logo-icon.png';
}