package com.example.abhibaseadaptergridview;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    GridView simpleGridView;
    ListView simpleListView;
    String[] animalName={"animal11","animal12","animal3","animal14","animal15","animal16","animal17"};
    int animals[]={R.drawable.animal11,R.drawable.animal12,R.drawable.animal13,R.drawable.animal14,R.drawable.animal15,R.drawable.animal16,R.drawable.animal17};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleListView=findViewById(R.id.simpleListView);

        simpleGridView=findViewById(R.id.simpleGridViewId);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),animals);
        simpleGridView.setAdapter(customAdapter);

        ArrayList<HashMap<String, String>> arrayList=new ArrayList<>();
        for (int i=0;i<animals.length;i++){
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("names",animalName[i]);
            hashMap.put("images",animals[i]+"");
            arrayList.add(hashMap);

        }

        String[] from={"names","images"};
        int[] to={R.id.textView,R.id.imageView};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);
        simpleListView.setAdapter(simpleAdapter);
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, animalName[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
