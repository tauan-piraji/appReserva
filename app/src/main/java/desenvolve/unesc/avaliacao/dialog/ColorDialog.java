package desenvolve.unesc.avaliacao.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import desenvolve.unesc.avaliacao.R;
import desenvolve.unesc.avaliacao.util.ColorPreferences;
import petrov.kristiyan.colorpicker.ColorPicker;

public class ColorDialog extends AppCompatActivity {

    private Activity activity;
    private TextView corDisponivel, corReservado, cencelar;
    private AlertDialog dialog;
    private ColorPreferences colorPreferences;

    public ColorDialog(final Activity activity) {
        this.activity = activity;
    }

    public void show() {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_color_config, null);

        builder.setView(view);

        colorPreferences = new ColorPreferences(activity);

        corDisponivel = view.findViewById(R.id.corDisponivel);
        corDisponivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ColorPicker colorPicker = new ColorPicker(activity);
                ArrayList<String> colors = new ArrayList<>();
                colors.add("#82B926");
                colors.add("#a276eb");
                colors.add("#6a3ab2");
                colors.add("#666666");
                colors.add("#FFFF00");
                colors.add("#3C8D2F");
                colors.add("#FA9F00");
                colors.add("#FF0000");

                colorPicker
                        .setDefaultColorButton(Color.parseColor("#f84c44"))
                        .setColors(colors)
                        .setColumns(5)
                        .setRoundColorButton(true)
                        .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                            @Override
                            public void onChooseColor(int position, int color) {
                                Log.d("position", "" + position);// will be fired only when OK button was tapped
                                colorPreferences.put(ColorPreferences.KEY_COLOR_LIVRE, color);
                                dialog.cancel();
                            }

                            @Override
                            public void onCancel() {

                            }
                        }).show();
            }
        });

        corReservado = view.findViewById(R.id.corReservado);
        corReservado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ColorPicker colorPicker = new ColorPicker(activity);
                ArrayList<String> colors = new ArrayList<>();
                colors.add("#82B926");
                colors.add("#a276eb");
                colors.add("#6a3ab2");
                colors.add("#666666");
                colors.add("#FFFF00");
                colors.add("#3C8D2F");
                colors.add("#FA9F00");
                colors.add("#FF0000");

                colorPicker
                        .setDefaultColorButton(Color.parseColor("#f84c44"))
                        .setColors(colors)
                        .setColumns(5)
                        .setRoundColorButton(true)
                        .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                            @Override
                            public void onChooseColor(int position, int color) {
                                Log.d("position", "" + position);// will be fired only when OK button was tapped
                                colorPreferences.put(ColorPreferences.KEY_COLOR_RESERVADO, color);
                                dialog.cancel();
                            }

                            @Override
                            public void onCancel() {

                            }
                        }).show();
            }
        });

        cencelar = view.findViewById(R.id.cancelar);
        cencelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog = builder.create();
        dialog.show();
    }
}