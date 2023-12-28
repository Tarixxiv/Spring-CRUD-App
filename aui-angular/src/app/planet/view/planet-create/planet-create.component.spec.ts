import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanetCreateComponent } from './planet-create.component';

describe('PlanetCreateComponent', () => {
  let component: PlanetCreateComponent;
  let fixture: ComponentFixture<PlanetCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlanetCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PlanetCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
