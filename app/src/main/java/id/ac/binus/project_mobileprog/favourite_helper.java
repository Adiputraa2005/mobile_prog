package id.ac.binus.project_mobileprog;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class favourite_helper {
    private static final String Pref_name = "favourites";
    private static final String key_list = "house list";

    public static void saveFavorites(Context context, List<Rumah> list) {
        SharedPreferences prefs = context.getSharedPreferences(Pref_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key_list, json);
        editor.apply();
    }

    public static List<Rumah> getFavorites(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Pref_name, Context.MODE_PRIVATE);
        String json = prefs.getString(key_list, "");

        Gson gson = new Gson();
        Type type = new TypeToken<List<Rumah>>() {}.getType();

        if (json.isEmpty()) return new ArrayList<>();
        return gson.fromJson(json, type);
    }
    public static void removeFavourite(Context context, int rumahId){
        List<Rumah> favList = getFavorites(context);

        for(int i = 0; i < favList.size(); i++){
            if(favList.get(i).getId() == rumahId){
                favList.remove(i);
                break;
            }
        }
        saveFavorites(context, favList);
    }
}
