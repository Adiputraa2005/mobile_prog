package id.ac.binus.project_mobileprog;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class home_activity extends AppCompatActivity {
    Button btn_login_home;
    Button btn_signup_home;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_page);

        btn_login_home = findViewById(R.id.btn_login_home);
        btn_signup_home = findViewById(R.id.btn_signup_home);

        btn_login_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_activity.this, login_activity.class);
                startActivity(intent);
            }
        });

        btn_signup_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_activity.this, register_activity.class);
                startActivity(intent);
            }
        });
    }
}
