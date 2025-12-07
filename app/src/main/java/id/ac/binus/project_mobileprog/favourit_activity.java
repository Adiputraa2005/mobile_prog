package id.ac.binus.project_mobileprog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class favourit_activity extends AppCompatActivity {

    ListView listrumah;

    ImageButton back_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_activity);
        ListView listView = findViewById(R.id.listrumah);

        List<Rumah> favlist = favourite_helper.getFavorites(this);

        listrumah_adapter adapter = new listrumah_adapter(this,
                R.layout.list_item_rumah,
                new ArrayList<>(favlist));

        listView.setAdapter(adapter);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(favourit_activity.this, main_activity.class);
            startActivity(intent);
            finish();
        });
    }


}
