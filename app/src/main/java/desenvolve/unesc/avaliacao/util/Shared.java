package desenvolve.unesc.avaliacao.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Shared {

    public static final String KEY_NOME_USUARIO = "NOME_USUARIO";
    public static final String KEY_EMAIL_USUARIO = "EMAIL_USUARIO";
    public static final String KEY_SENHA_USUARIO = "SENHA_USUARIO";
    public static final String KEY_SET_COR = "SER_COR";
    public static final String KEY_COR_LINEAR_01 = "COR_LINEAR_01";
    public static final String KEY_COR_LINEAR_02 = "COR_LINEAR_02";
    public static final String KEY_COR_LINEAR_03 = "COR_LINEAR_03";
    public static final String KEY_COR_LINEAR_04 = "COR_LINEAR_04";
    public static final String KEY_COR_LINEAR_05 = "COR_LINEAR_05";
    public static final String KEY_COR_LINEAR_06 = "COR_LINEAR_06";
    public static final String KEY_COR_LINEAR_07 = "COR_LINEAR_07";
    public static final String KEY_COR_LINEAR_08 = "COR_LINEAR_08";
    public static final String KEY_COR_LINEAR_09 = "COR_LINEAR_09";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public Shared(final Context activity) {
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