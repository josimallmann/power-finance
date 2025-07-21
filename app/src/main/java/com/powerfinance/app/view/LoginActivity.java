package com.powerfinance.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.powerfinance.app.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvGoToRegister = findViewById(R.id.tvGoToRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica de login aqui
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                // ... (sua lógica de autenticação)
            }
        });

        // Configurar o listener de clique para o TextView "Cadastre-se!"
        tvGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma Intent para iniciar a RegisterActivity
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class); // Alterado para RegisterActivity
                startActivity(intent);
                finish(); // Finaliza a LoginActivity para removê-la da pilha
            }
        });
    }
}
