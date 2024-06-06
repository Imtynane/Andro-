package com.example.projet1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    ListView niveauListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Instancie la liste en récupérant son id
        niveauListView=(ListView) findViewById(R.id.listView);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Licence1");
        arrayList.add("Licence2");
        arrayList.add("Licence3");
        arrayList.add("Master1");
        arrayList.add("Master2");

        //créer un adaptateur
        ArrayAdapter arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        niveauListView.setAdapter(arrayAdapter);

    }
}
