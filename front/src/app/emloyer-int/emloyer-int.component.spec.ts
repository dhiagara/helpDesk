import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmloyerIntComponent } from './emloyer-int.component';

describe('EmloyerIntComponent', () => {
  let component: EmloyerIntComponent;
  let fixture: ComponentFixture<EmloyerIntComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmloyerIntComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmloyerIntComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
