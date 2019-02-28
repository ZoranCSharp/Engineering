
import { Component, OnInit } from '@angular/core';
import { ArrayType } from '@angular/compiler';


@Component({
  selector: 'app-dogadjaj',
  templateUrl: './dogadjaj.component.html',
  // tslint:disable-next-line:max-line-length
  //template: '<app-input></app-input><app-input></app-input><app-input></app-input><app-input></app-input>>',
  styleUrls: ['./dogadjaj.component.css']
})
export class DogadjajComponent implements OnInit {

  dodajNoviInput = false;
  inputStatus = 'Nov Unos';
  dozvoliNoviStatus = 'nije unesen';
  value = 'Blaaaaa';
  values = '';

  array: Array<string> = new Array<string>();

  addToString(input: string) {
    console.log(input);
    this.array.push(input);
    console.log(this.array);
  }

  
  delete(){
    this.array.splice(0,this.array.length);
  }

  onKey(event: any) { // without type info
    this.values += event.target.value + ' | ';
  }

  onEnter(value: string) { this.value = value; }

  // tslint:disable-next-line:member-ordering
  heroes = ['Windstorm', 'Bombasto', 'Magneta', 'Tornado'];
  addHero(newHero: string) {
    if (newHero) {
      this.heroes.push(newHero);
    }
  }

  



  
  

  constructor() {
      // setTimeout(() => {this.dodajNoviInput = true; }, 2000);
  }


  ngOnInit() {
  }

  public dozvoliStatus() {
    return this.dozvoliNoviStatus;  }

}
