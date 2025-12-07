package id.ac.binus.project_mobileprog;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class main_activity extends AppCompatActivity {
    EditText etSearch;
    Button btn_Brosur1;
    Button btn_Agent1;
    Button btn_brosur2;
    Button btn_Agent2;
    ListView listrumah;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        ListView listView = findViewById(R.id.listrumah);

        ArrayList<Rumah> listRumah = new ArrayList<>();
        listRumah.add(new Rumah(R.drawable.house1, "Rumah Minimalis", "puri residence resort", "Rp 1- 2 M", "Tipe 10 x 20 Standard", "puri utara"));
        listRumah.add(new Rumah(R.drawable.house2, "Rumah luxury", "Serpong heritage 1", "Rp 1- 3 M", "Tipe 15 x 20 Standard", "Serpong selatan"));
        listRumah.add(new Rumah(R.drawable.house3, "Rumah tusuk sate", "Pantai indah kapuk","Rp 3-5 M", "tipe 1 x 1", "jakarta utara"));

        listrumah_adapter adapter = new listrumah_adapter(this, R.layout.list_item_rumah, listRumah);
        listView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_home) return go(main_activity.class);
            if (id == R.id.nav_profile) return go(profil_activity.class);
            if(id == R.id.nav_message) return go(message_activity.class);
            if(id == R.id.nav_favorite) return go(favourit_activity.class);


            return false;
        });
    }

    private boolean go(Class<?> cls) {
        startActivity(new Intent(this, cls));
        return true;
    }
}
