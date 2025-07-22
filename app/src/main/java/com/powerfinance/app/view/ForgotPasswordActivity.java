package com.powerfinance.app.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.powerfinance.app.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText etRecoveryEmail;
    private Button btnRecover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etRecoveryEmail = findViewById(R.id.etRecoveryEmail);
        btnRecover = findViewById(R.id.btnRecover);

        btnRecover.setOnClickListener(v -> {
            String email = etRecoveryEmail.getText().toString().trim();

            if (email.isEmpty()) {
                Toast.makeText(this, "Por favor, insira seu e-mail", Toast.LENGTH_SHORT).show();
            } else {
                // Aqui você implementa a lógica para enviar instruções de recuperação
                Toast.makeText(this, "Instruções enviadas para: " + email, Toast.LENGTH_LONG).show();
                // Talvez fechar a tela após enviar
                finish();
            }
        });
    }
}
