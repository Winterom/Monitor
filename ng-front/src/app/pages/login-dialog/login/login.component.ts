import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  hide = true;
  form: FormGroup;

  email:string|null=null;
  password:string|null=null;
  submitted = false;
  emailError = false;
  passwordError= false;
  isLoginFailed = false;
  errorMessage = '';
  constructor(private formBuilder: FormBuilder,private router: Router,public dialogRef: MatDialogRef<LoginComponent>) {
    this.form = this.formBuilder.group({
        emailControl:[Validators.required],
        passwordControl:[Validators.required]
      }
    )
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitted = true;
  }
}
