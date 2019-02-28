import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DogadjajComponent } from './dogadjaj.component';

describe('DogadjajComponent', () => {
  let component: DogadjajComponent;
  let fixture: ComponentFixture<DogadjajComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DogadjajComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DogadjajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
