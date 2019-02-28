import { Component } from '@angular/core';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html'
})

export class InputComponent {
  inputId: number = 1;
  inputStatus: string = 'prazno';


getInputStatus() {
  return this.inputStatus;
}
change() {
  return this.inputStatus = 'popunjeno';
}


}

