import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListReclamationComponent } from './list-reclamation.component';

describe('ListReclamationComponent', () => {
  let component: ListReclamationComponent;
  let fixture: ComponentFixture<ListReclamationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListReclamationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});