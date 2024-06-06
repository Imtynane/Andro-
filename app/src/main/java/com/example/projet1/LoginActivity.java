package com.example.projet1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {
    private BDUser bdUser;
    private Button btcompte;
    private Button btconn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());

        bdUser = new BDUser(this);

        // Initialiser les boutons
        btcompte = findViewById(R.id.btcompte);
        btconn = findViewById(R.id.btconn);

        // Action pour le bouton "Créer un compte"
        btcompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les informations saisies par l'utilisateur
                EditText etLogin = findViewById(R.id.et_login);
                EditText etPassword = findViewById(R.id.et_password);

                String login = etLogin.getText().toString();
                String password = etPassword.getText().toString();

                // Insérer l'utilisateur dans la base de données
                try {
                    bdUser.insertUser(login, password);
                    Toast.makeText(LoginActivity.this, "Compte créé avec succès", Toast.LENGTH_SHORT).show();
                } catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "Erreur lors de la création du compte", Toast.LENGTH_SHORT).show();
                }

                // Changer d'activité
                Intent startInsActivity = new Intent(getApplicationContext(), InscriptionActivity.class);
                startActivity(startInsActivity);
            }
        });

        // Action pour le bouton "Connexion"
        btconn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Changer d'activité
                Intent startDetailsActivity = new Intent(getApplicationContext(), DetailsActivity.class);
                startActivity(startDetailsActivity);
            }
        });
    }
}
