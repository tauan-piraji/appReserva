package desenvolve.unesc.avaliacao.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ColorPreferences {

    public static final String KEY_COLOR_LIVRE = "COLOR_LIVRE";
    public static final String KEY_COLOR_RESERVADO = "COLOR_RESERVADO";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public ColorPreferences(final Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        editor = preferences.edit();
    }

    public final void put(final String key, final Object value) {

        if (value instanceof String) {
            editor.putString(key, (String)value);
        }else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean)value);
        }else if (value instanceof Long) {
            editor.putLong(key, (Long)value);
        }else if (value instanceof Integer) {
            editor.putInt(key, (Integer)value);
        }else if (value instanceof Float) {
            editor.putFloat(key, (Float)value);
        }else{
            //Toast.makeText(activity, "tipo de dado inválido", Toast.LENGTH_LONG).show();
        }

        editor.apply();
    }

    public final String getString(final String key) {
        return preferences.getString(key, "");
    }

    public final int getInt(final String key) {
        return preferences.getInt(key, 0);
    }

    public final void remove(final String key) {
        editor.remove(key);
        editor.apply();
    }

}