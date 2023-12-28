import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StarCreateComponent } from './star-create.component';

describe('StarCreateComponent', () => {
  let component: StarCreateComponent;
  let fixture: ComponentFixture<StarCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StarCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StarCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
