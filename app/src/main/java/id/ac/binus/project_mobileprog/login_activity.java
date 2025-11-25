package id.ac.binus.project_mobileprog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.WindowManager;

import id.ac.binus.project_mobileprog.database_helper.Database_Helper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_activity extends AppCompatActivity {
    EditText et_email;
    EditText et_password;
    TextView tv_signup;

    Button btn_login;

    Database_Helper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_page);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
        );


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et_email =  findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        tv_signup = findViewById(R.id.tv_signup);
        db = new Database_Helper(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() || !email.endsWith("@gmail.com")) {
                    et_email.setError("gunakan email yang valid");
                    return;
                }
                if (password.length() < 6){
                    et_password.setError("password harus lebih dari 6 karakter");
                    return;
                }
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()){
                                Toast.makeText(login_activity.this, "Login Firebase berhasil", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(login_activity.this, main_activity.class));
                                finish();
                            } else {
                                if(db.checkUser(email,password)){
                                    Toast.makeText(login_activity.this, "Login Offline (SQLite)", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(login_activity.this, main_activity.class));
                                    finish();
                                } else {
                                    Toast.makeText(login_activity.this,"password atau email salah",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_activity.this, register_activity.class);
                startActivity(intent);
            }
        });
    }
}