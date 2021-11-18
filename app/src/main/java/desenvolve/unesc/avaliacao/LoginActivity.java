package desenvolve.unesc.avaliacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolve.unesc.avaliacao.util.Shared;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout linearGoogle, linearFace;
    private EditText userLogin, userPassword;
    private TextView textCriar;
    private Button btnLogar;
    private Shared shared;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        shared = new Shared(LoginActivity.this);

        userLogin = findViewById(R.id.userLogin);
        userPassword = findViewById(R.id.userPassword);

        btnLogar = findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userLogin.getText().toString().isEmpty()) {
                    userLogin.setError("Campo obrigatório");
                }else if (userPassword.getText().toString().isEmpty()) {
                    userPassword.setError("Campo obrigatório");
                }else if (userLogin.getText().toString().equalsIgnoreCase("Administrador") &&
                            userPassword.getText().toString().equalsIgnoreCase("Administrador")) {
                    startActivity(new Intent( LoginActivity.this, MainActivity.class));
                }else if(userLogin.getText().toString().equalsIgnoreCase("Adm") &&
                            userPassword.getText().toString().equalsIgnoreCase("Adm123")) {
                    startActivity(new Intent( LoginActivity.this, MainActivity.class));
                }else if(userLogin.getText().toString().equalsIgnoreCase("Administrator") &&
                        userPassword.getText().toString().equalsIgnoreCase("Que3B1eng4ElT0r0")) {
                    startActivity(new Intent( LoginActivity.this, MainActivity.class));
                }else if(userLogin.getText().toString().equalsIgnoreCase("Root") &&
                        userPassword.getText().toString().equalsIgnoreCase("pr0m1uscu0")) {
                    startActivity(new Intent( LoginActivity.this, MainActivity.class));
                }else if(userLogin.getText().toString().equalsIgnoreCase(shared.getString(Shared.KEY_EMAIL_USUARIO)) &&
                        userPassword.getText().toString().equalsIgnoreCase(shared.getString(Shared.KEY_SENHA_USUARIO))) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else if (!userLogin.getText().toString().equalsIgnoreCase("Administrador") ||
                        !userLogin.getText().toString().equalsIgnoreCase("Adm") ||
                        !userLogin.getText().toString().equalsIgnoreCase("Administrator") ||
                        !userLogin.getText().toString().equalsIgnoreCase("Root") ||
                        !userLogin.getText().toString().equalsIgnoreCase(shared.getString(Shared.KEY_EMAIL_USUARIO))) {
                    userLogin.setError("Nome do usuário invalido!");
                }else if(!userPassword.getText().toString().equalsIgnoreCase("Administrador") ||
                        !userPassword.getText().toString().equalsIgnoreCase("Adm123") ||
                        !userPassword.getText().toString().equalsIgnoreCase("Que3B1eng4ElT0r0") ||
                        !userPassword.getText().toString().equalsIgnoreCase("pr0m1uscu0") ||
                        !userPassword.getText().toString().equalsIgnoreCase(shared.getString(Shared.KEY_SENHA_USUARIO))) {
                    userPassword.setError("Nome do usuário invalido!");
                }else{}
            }
        });

        linearFace = findViewById(R.id.linearFace);
        linearFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shared.put(Shared.KEY_NOME_USUARIO, "FaceConta");
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        linearGoogle = findViewById(R.id.linearGoogle);
        linearGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shared.put(Shared.KEY_NOME_USUARIO, "GoogleConta");
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        textCriar = findViewById(R.id.textCriar);
        textCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastrarActivity.class));
            }
        });
    }
}
