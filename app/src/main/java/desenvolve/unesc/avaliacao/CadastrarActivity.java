package desenvolve.unesc.avaliacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolve.unesc.avaliacao.util.Shared;

public class CadastrarActivity extends AppCompatActivity {

    private EditText editNome, editEmail, editSenha;
    private Button btnCadastrar, btnRetornar;
    private Shared shared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        shared = new Shared(CadastrarActivity.this);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

        btnCadastrar = findViewById(R.id.btnCadastrar); 
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editNome.getText().toString().isEmpty()) {
                    editNome.setError("Campo obrigatório");
                }else if (editEmail.getText().toString().isEmpty()) {
                    editEmail.setError("Campo obrigatório");
                }else if (editSenha.getText().toString().isEmpty()) {
                    editSenha.setError("Campo obrigatório");
                }else {
                    shared.put(Shared.KEY_NOME_USUARIO, editNome.getText().toString());
                    shared.put(Shared.KEY_EMAIL_USUARIO, editEmail.getText().toString());
                    shared.put(Shared.KEY_SENHA_USUARIO, editSenha.getText().toString());
                    startActivity(new Intent(CadastrarActivity.this, MainActivity.class));
                }
            }
        });

        btnRetornar = findViewById(R.id.btnRetornar);
        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CadastrarActivity.this, LoginActivity.class));
            }
        });

    }
}
