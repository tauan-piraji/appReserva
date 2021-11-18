package desenvolve.unesc.avaliacao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;

import desenvolve.unesc.avaliacao.dialog.ColorDialog;
import desenvolve.unesc.avaliacao.enums.IdentificadorMesaEnum;
import desenvolve.unesc.avaliacao.enums.OperacaoMesaEnum;
import desenvolve.unesc.avaliacao.enums.StatusMesaEnum;
import desenvolve.unesc.avaliacao.util.ColorPreferences;
import desenvolve.unesc.avaliacao.util.UtilSharedPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ColorPreferences colorPreferences;

    private LinearLayout linearMesa1;
    private LinearLayout linearMesa2;
    private LinearLayout linearMesa3;
    private LinearLayout linearMesa4;
    private LinearLayout linearMesa5;
    private LinearLayout linearMesa6;
    private LinearLayout linearMesa7;
    private LinearLayout linearMesa8;
    private LinearLayout linearMesa9;

    private Button btnReservarMesa1;
    private Button btnReservarMesa2;
    private Button btnReservarMesa3;
    private Button btnReservarMesa4;
    private Button btnReservarMesa5;
    private Button btnReservarMesa6;
    private Button btnReservarMesa7;
    private Button btnReservarMesa8;
    private Button btnReservarMesa9;
    private Button btnLiberarMesa;
    private Button btnSalvarOperacao;
    private Button btnReservarTodasAsMesas;
    private Button btnLiberarTodasMesas;
    private Button btnConfiguracao;

    private LinkedHashMap<IdentificadorMesaEnum, StatusMesaEnum> mapaMesas = new LinkedHashMap<IdentificadorMesaEnum, StatusMesaEnum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorPreferences = new ColorPreferences(MainActivity.this);

        if(colorPreferences.getInt(ColorPreferences.KEY_COLOR_LIVRE) == 0){
            colorPreferences.put(ColorPreferences.KEY_COLOR_LIVRE, R.color.Blue);
        }

        if(colorPreferences.getInt(ColorPreferences.KEY_COLOR_RESERVADO) == 0){
            colorPreferences.put(ColorPreferences.KEY_COLOR_RESERVADO, R.color.Red);
        }

        linearMesa1 = findViewById(R.id.linearMesa1);
        linearMesa2 = findViewById(R.id.linearMesa2);
        linearMesa3 = findViewById(R.id.linearMesa3);
        linearMesa4 = findViewById(R.id.linearMesa4);
        linearMesa5 = findViewById(R.id.linearMesa5);
        linearMesa6 = findViewById(R.id.linearMesa6);
        linearMesa7 = findViewById(R.id.linearMesa7);
        linearMesa8 = findViewById(R.id.linearMesa8);
        linearMesa9 = findViewById(R.id.linearMesa9);

        btnReservarMesa1 = findViewById(R.id.btnReservarMesa1);
        btnReservarMesa2 = findViewById(R.id.btnReservarMesa2);
        btnReservarMesa3 = findViewById(R.id.btnReservarMesa3);
        btnReservarMesa4 = findViewById(R.id.btnReservarMesa4);
        btnReservarMesa5 = findViewById(R.id.btnReservarMesa5);
        btnReservarMesa6 = findViewById(R.id.btnReservarMesa6);
        btnReservarMesa7 = findViewById(R.id.btnReservarMesa7);
        btnReservarMesa8 = findViewById(R.id.btnReservarMesa8);
        btnReservarMesa9 = findViewById(R.id.btnReservarMesa9);

        btnReservarMesa1.setOnClickListener(this);
        btnReservarMesa2.setOnClickListener(this);
        btnReservarMesa3.setOnClickListener(this);
        btnReservarMesa4.setOnClickListener(this);
        btnReservarMesa5.setOnClickListener(this);
        btnReservarMesa6.setOnClickListener(this);
        btnReservarMesa7.setOnClickListener(this);
        btnReservarMesa8.setOnClickListener(this);
        btnReservarMesa9.setOnClickListener(this);

        btnLiberarMesa = findViewById(R.id.btnLiberarMesa);
        btnSalvarOperacao = findViewById(R.id.btnSalvarOperacao);
        btnReservarTodasAsMesas = findViewById(R.id.btnReservarTodasAsMesas);
        btnLiberarTodasMesas = findViewById(R.id.btnLiberarTodasMesas);
        btnConfiguracao = findViewById(R.id.btnConfiguracao);

        btnLiberarMesa.setOnClickListener(this);
        btnSalvarOperacao.setOnClickListener(this);
        btnReservarTodasAsMesas.setOnClickListener(this);
        btnLiberarTodasMesas.setOnClickListener(this);
        btnConfiguracao.setOnClickListener(this);

        carregaMapa();
        pintarMesas();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnReservarMesa1:
            case R.id.btnReservarMesa2:
            case R.id.btnReservarMesa3:
            case R.id.btnReservarMesa4:
            case R.id.btnReservarMesa5:
            case R.id.btnReservarMesa6:
            case R.id.btnReservarMesa7:
            case R.id.btnReservarMesa8:
            case R.id.btnReservarMesa9:
                alterarStatusMesa(OperacaoMesaEnum.RESERVAR, IdentificadorMesaEnum.values()[Integer.parseInt(v.getTag().toString())-1]);
                                                                                 //values() inicia do 0   getTag criada no layout.xml para separar as entity
                break;
            case R.id.btnLiberarMesa:
                liberarMesa();
                break;
            case R.id.btnSalvarOperacao:
                salvarOperacao();
                break;
            case R.id.btnReservarTodasAsMesas:
                reservarTodasMesas();
                break;
            case R.id.btnLiberarTodasMesas:
                liberarTodasMesas();
                break;
            case R.id.btnConfiguracao:
                selectColor();
                break;
        }
    }

    private void alterarStatusMesa(OperacaoMesaEnum operacao, IdentificadorMesaEnum mesa) {

        StatusMesaEnum status = StatusMesaEnum.LIBERADA;
        int color = colorPreferences.getInt(ColorPreferences.KEY_COLOR_LIVRE);
        Boolean habilita = true;

        if (operacao.equals(OperacaoMesaEnum.RESERVAR)) {
            status = StatusMesaEnum.RESERVADA;
            color = colorPreferences.getInt(ColorPreferences.KEY_COLOR_RESERVADO);
            habilita = false;
        }

        getLinearLayout(mesa.getIndice()).setBackgroundColor(color);
        getButton(mesa.getIndice()).setEnabled(habilita);
                                    //setEnable bloqueia a função/botão
        mapaMesas.put(mesa, status);
    }

    private void liberarMesa() {

        String numeroMesa = ((EditText)findViewById(R.id.edtNumeroMesa)).getText().toString();
        if (numeroMesa.isEmpty()) {
            Toast.makeText(MainActivity.this, "Informe o número da mesa a ser liberada!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Integer.parseInt(numeroMesa) < 1 || Integer.parseInt(numeroMesa) > 9) {
            Toast.makeText(MainActivity.this, "Mesa não existe!", Toast.LENGTH_SHORT).show();
            return;
        }

        StatusMesaEnum status = mapaMesas.get(IdentificadorMesaEnum.values()[Integer.parseInt(numeroMesa)-1]);
        if (status.toString().equals(StatusMesaEnum.LIBERADA.toString())) {
            Toast.makeText(MainActivity.this, "A mesa já encontra-se liberada", Toast.LENGTH_SHORT).show();
            return;
        }

        alterarStatusMesa(OperacaoMesaEnum.LIBERAR, IdentificadorMesaEnum.values()[Integer.parseInt(numeroMesa)-1]);
        ((EditText)findViewById(R.id.edtNumeroMesa)).setText("");//limpa editText
    }

    private void salvarOperacao() {

        UtilSharedPreferences.clear(MainActivity.this);

        for (IdentificadorMesaEnum mesa : mapaMesas.keySet()) {
            StatusMesaEnum status = mapaMesas.get(mesa); //mapaMesas HashMap linha 47
            if (status != null && status.toString().equals((StatusMesaEnum.RESERVADA.toString()))) {
                UtilSharedPreferences.putString(MainActivity.this, mesa.getKey(), status.toString());
            }
        }

        Toast.makeText(MainActivity.this, "Operação salva com sucesso!!!", Toast.LENGTH_SHORT).show();
    }

    private void reservarTodasMesas() {
        for (int i = 1; i < 10; i++) {
            alterarStatusMesa(OperacaoMesaEnum.RESERVAR, IdentificadorMesaEnum.values()[i-1]);
        }
    }

    private void liberarTodasMesas() {
        for (int i = 1; i < 10; i++) {
            alterarStatusMesa(OperacaoMesaEnum.LIBERAR, IdentificadorMesaEnum.values()[i-1]);
        }
    }

    private void carregaMapa() {
        for (IdentificadorMesaEnum mesa : IdentificadorMesaEnum.values()) {
            mapaMesas.put(
                    mesa,
                    StatusMesaEnum.valueOf(
                        UtilSharedPreferences.getString(MainActivity.this, mesa.getKey(), StatusMesaEnum.LIBERADA.toString())
                        //mesa.getKey() vai pegar a mesa no shared, como ela n existe ainda ela sera criada com o StatusMesaEnum.LIBERADA.toString()
                    )
            );
        }
    }

    private void pintarMesas() {
        for (IdentificadorMesaEnum mesa : mapaMesas.keySet()) {
            StatusMesaEnum status = mapaMesas.get(mesa); //mapaMesas HashMap linha 47
            if (status != null && status.toString().equals((StatusMesaEnum.RESERVADA.toString()))) {
                alterarStatusMesa(OperacaoMesaEnum.RESERVAR, mesa);
            }
        }
    }

    private void selectColor() {
        ColorDialog dialog = new ColorDialog(MainActivity.this);
        dialog.show();
        pintarMesas();
    }

    private LinearLayout getLinearLayout(Integer indice) {
        switch (indice) {
            case 1: return linearMesa1;
            case 2: return linearMesa2;
            case 3: return linearMesa3;
            case 4: return linearMesa4;
            case 5: return linearMesa5;
            case 6: return linearMesa6;
            case 7: return linearMesa7;
            case 8: return linearMesa8;
            case 9: return linearMesa9;
            default: return new LinearLayout(MainActivity.this);
        }
    }

    private Button getButton(Integer indice) {
        switch (indice) {
            case 1: return btnReservarMesa1;
            case 2: return btnReservarMesa2;
            case 3: return btnReservarMesa3;
            case 4: return btnReservarMesa4;
            case 5: return btnReservarMesa5;
            case 6: return btnReservarMesa6;
            case 7: return btnReservarMesa7;
            case 8: return btnReservarMesa8;
            case 9: return btnReservarMesa9;
            default: return new Button(MainActivity.this);
        }
    }
}