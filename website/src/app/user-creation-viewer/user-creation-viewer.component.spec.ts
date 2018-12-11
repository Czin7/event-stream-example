import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCreationViewerComponent } from './user-creation-viewer.component';

describe('UserCreationViewerComponent', () => {
  let component: UserCreationViewerComponent;
  let fixture: ComponentFixture<UserCreationViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserCreationViewerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserCreationViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
