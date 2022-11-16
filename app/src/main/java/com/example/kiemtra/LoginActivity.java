package com.example.kiemtra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText signin_edtUsername, signin_edtPassword;
    Button signin_btnSignin;
    CheckBox signin_cBoxremember;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initID();

        sharedPreferences =getSharedPreferences("user_name", MODE_PRIVATE);

        signin_edtUsername.setText(sharedPreferences.getString("save_user_name", ""));
        signin_edtPassword.setText(sharedPreferences.getString("save_user_password", ""));
        signin_cBoxremember.setChecked(sharedPreferences.getBoolean("save_checked", false));

        signin_btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check(signin_edtUsername.getText().toString().trim(), signin_edtPassword.getText().toString().trim())) {

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
                    alertDialog.setMessage("Đăng nhập thành công");
                    alertDialog.setTitle("Thông báo");
                    alertDialog.show();

                    if(signin_cBoxremember.isChecked()) {
                        SharedPreferences.Editor save = sharedPreferences.edit();
                        save.putString("save_user_name", signin_edtUsername.getText().toString().trim());
                        save.putString("save_user_password", signin_edtPassword.getText().toString().trim());
                        save.putBoolean("save_checked", true);
                        save.commit();
                    } else {
                        SharedPreferences.Editor save = sharedPreferences.edit();
                        save.remove("save_user_name");
                        save.remove("save_user_password");
                        save.remove("save_checked");
                        save.commit();
                    }

                    gotoMain(signin_edtUsername.getText().toString().trim());
                } else {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
                    alertDialog.setMessage("Đăng nhập thất bại");
                    alertDialog.setTitle("Thông báo");
                    alertDialog.show();
                }
            }
        });

    }




    public void initID() {
        signin_edtUsername = findViewById(R.id.signin_edtUsername);
        signin_edtPassword = findViewById(R.id.signin_edtPassword);
        signin_btnSignin = findViewById(R.id.signin_btnSignin);
        signin_cBoxremember = findViewById(R.id.signin_cBoxremember);
    }

    public void gotoMain(String username) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public boolean check(String username,String password) {
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
            return true;
        }
        return false;
    }
}