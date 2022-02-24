package com.example.tuan02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText edtName,edtPass;
    Button btnLogin;
    TextView txtThongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.txtName);
        edtPass = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtThongBao = findViewById(R.id.txtThongTin);

    }

    public void testClick(View view){
        String name = edtName.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();

        if(name.length() == 0 && pass.length() == 0){
            txtThongBao.setText("Vui lòng điền thông tin");
        }
        else if(name.equalsIgnoreCase("Phan Huu Trong") && pass.equalsIgnoreCase("123456") ){
            txtThongBao.setText("Người đăng nhập: Phan Hữu Trọng");
        }
        else txtThongBao.setText("Thông tin đăng nhập không hợp lệ");


    }


}