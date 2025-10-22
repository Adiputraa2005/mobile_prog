package id.ac.binus.project_mobileprog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register_activity extends AppCompatActivity{
    Button btn_signup_register;
    TextView tv_login;

    EditText et_person;
    EditText et_email;
    EditText et_password;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        et_person = findViewById(R.id.et_person);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_signup_register = findViewById(R.id.btn_signup_register);
        tv_login = findViewById(R.id.tv_login);

        btn_signup_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_person.getText().toString();
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(register_activity.this, "tolong isi field", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(register_activity.this, "registrasi berhasil!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(register_activity.this, login_activity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register_activity.this, login_activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
