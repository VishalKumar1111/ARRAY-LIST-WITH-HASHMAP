package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {
    Button save, refresh;
    EditText name,record;
    ArrayAdapter arrayAdapter;
    PriorityQueue<String> hs;
    ArrayList<String> array_list;
    private ListView listView;
    Map map = new HashMap();

    @Override
    protected void onCreate(Bundle readdInstanceState) {
        super.onCreate(readdInstanceState);
        setContentView(R.layout.activity_main);
        array_list = new ArrayList<>();
        name = findViewById(R.id.name);
        record = findViewById(R.id.record);
        listView = findViewById(R.id.listView);
        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.notifyDataSetChanged();
                listView.invalidateViews();
                listView.refreshDrawableState();
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty() && !record.getText().toString().isEmpty()) {
                    map.put(record.getText().toString(),name.getText().toString());
                    array_list.clear();
                    array_list.addAll(map.values());
                    arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, array_list);
                    listView.setAdapter(arrayAdapter);
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
                } else {
                    name.setError("Enter NAME");
                    record.setError("Enter Record");
                }
            }
        });
    }
}