package aurora.tech.testcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    GridLayoutManager gridLayoutManager;
    RecyclerAdapter adapter;
    Button nxtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        gridLayoutManager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(gridLayoutManager);
        nxtBtn = findViewById(R.id.nxtBtn);
        List<Services> s = new ArrayList<>();
        s.add(new Services("Battery Jumper", R.drawable.ic_launcher_background, "160 L.E", 1));

        s.add(new Services("Engine Coolant", R.drawable.ic_launcher_foreground, "110 L.E", 2));

        s.add(new Services("Flat tire", R.drawable.ic_launcher_background, "150 L.E", 300));

        adapter = new RecyclerAdapter(this, s);
        rv.setAdapter(adapter);

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putParcelableArrayListExtra("data", adapter.svToSend);
                Log.d("OffRoad", "Size of list is : " + adapter.svToSend.size());
                startActivity(i);

            }
        });

    }
}
