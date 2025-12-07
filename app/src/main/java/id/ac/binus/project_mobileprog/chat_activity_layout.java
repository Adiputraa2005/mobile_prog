package id.ac.binus.project_mobileprog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class chat_activity_layout extends AppCompatActivity {
    ImageButton back_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_agent);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(chat_activity_layout.this, main_activity.class);
            startActivity(intent);
            finish();
        });
    }
}
