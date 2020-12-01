package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private DbActivity dbActivity = new DbActivity(this);
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbActivity.InsertCountry("Slovensko");
        dbActivity.InsertCountry("USA");
        dbActivity.InsertCountry("Kanada");
        dbActivity.InsertCountry("Taliansko");
        dbActivity.InsertCountry("Nemecko");
        dbActivity.InsertCountry("Anglicko");

        ArrayList<String> arrayList = dbActivity.GetCountries();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.list_view, arrayList);


        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
