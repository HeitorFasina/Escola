package com.va.vestibularioapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {

    EditText usuarioLogin, senhaLogin;
    MaterialButton botaoLogin;

    private static final String URL  = "jdbc:mysql://185.42.117.115:3306/b2no9qi14ndhhpe0o9w2";
    private static final String USER = "u6ickfr0bctmfwmu";
    private static final String PASS = "LW9jHRqk5k9e5RvykTc2";

    public void openActivity(Class myClass) {
        Intent intent = new Intent(this, myClass);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        usuarioLogin = findViewById(R.id.etUsuario);
        senhaLogin = findViewById(R.id.etSenha);
        botaoLogin = findViewById(R.id.btnLogin);

        botaoLogin.setOnClickListener(v -> {
            String usuario = usuarioLogin.getText().toString();
            String senha = usuarioLogin.getText().toString();

            try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
                String sql = "SELECT * FROM login WHERE usuario='"+usuario+"' AND senha = md5('"+senha+"')";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) { openActivity(CalendarActivity.class); }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

}
