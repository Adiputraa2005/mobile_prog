package id.ac.binus.project_mobileprog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class Agent_activity extends AppCompatActivity {
    ListView list_agent;
    ImageButton btn_back;
    ImageButton btn_search;
    Button request;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agent_page);

        ListView listView = findViewById(R.id.list_agent);

        ArrayList<Agent> Agent = new ArrayList<>();
        Agent.add(new Agent(R.drawable.agent_1, "Adi","makmur jaya", "0821488452342"));
        Agent.add(new Agent(R.drawable.agent_2, "jaya","makmur terus", "0821488458980"));

        agent_adapter adapter = new agent_adapter(this, R.layout.items, Agent);
        listView.setAdapter(adapter);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent intent = new Intent(Agent_activity.this, main_activity.class);
            startActivity(intent);
            finish();
        });

    }

}
