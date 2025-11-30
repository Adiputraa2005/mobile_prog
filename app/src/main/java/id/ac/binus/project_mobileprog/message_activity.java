package id.ac.binus.project_mobileprog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class message_activity extends AppCompatActivity {
    ImageButton btn_back;
    Button btn_make_appointment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_page);

     btn_back = findViewById(R.id.btn_back);

    btn_back.setOnClickListener(view -> {
        Intent intent = new Intent(message_activity.this, main_activity.class);
        startActivity(intent);
        finish();
    });
    }
}