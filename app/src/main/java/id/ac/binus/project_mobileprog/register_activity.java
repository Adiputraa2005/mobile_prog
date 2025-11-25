package id.ac.binus.project_mobileprog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import id.ac.binus.project_mobileprog.R;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.Firebase;

import id.ac.binus.project_mobileprog.database_helper.Database_Helper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class register_activity extends AppCompatActivity{
    Button btn_signup_register;
    TextView tv_login;

    EditText et_person;
    EditText et_email;
    EditText et_password;
    Database_Helper db;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        et_person = findViewById(R.id.et_person);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_signup_register = findViewById(R.id.btn_signup_register);
        tv_login = findViewById(R.id.tv_login);
        db = new Database_Helper(this);

        btn_signup_register.setOnClickListener(v -> {
            String name = et_person.getText().toString();
            String email = et_email.getText().toString();
            String password = et_password.getText().toString();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "tolong isi field", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!email.endsWith("@gmail.com")) {
                Toast.makeText(this, "tolong masukan alamat email dengan benar", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6) {
                Toast.makeText(this, "password harus lebih dari 6 karakter", Toast.LENGTH_SHORT).show();
                return;
            }

            FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {

                        String uid = authResult.getUser().getUid();
                        FirebaseFirestore dbF = FirebaseFirestore.getInstance();

                        Map<String, Object> user = new HashMap<>();
                        user.put("name", name);
                        user.put("email", email);

                        dbF.collection("users").document(uid).set(user)
                                .addOnSuccessListener(unused -> {
                                    Toast.makeText(this,
                                            "Data Firestore tersimpan!", Toast.LENGTH_SHORT).show();
                                })
                                .addOnFailureListener(e ->
                                        Toast.makeText(this,
                                                "Gagal simpan Firestore: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                                );

                        db.insertUser(email, password);

                        Toast.makeText(this,
                                "Registrasi berhasil!", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(this, main_activity.class));
                        finish();
                    })
                    .addOnFailureListener(e ->
                            Toast.makeText(this,
                                    "Firebase gagal: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                    );
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
