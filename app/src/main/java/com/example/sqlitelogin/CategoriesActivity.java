package com.example.sqlitelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class CategoriesActivity extends AppCompatActivity {
    GridView gridview;
    int images[]={R.drawable.skin_care,R.drawable.beverages,R.drawable.hair_care};
    String titles[]={"Skin care","Beverages","Hair Care"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        gridview= (GridView) findViewById(R.id.GridView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), images,titles);
        gridview.setAdapter(customAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(CategoriesActivity.this, ProductActivity.class);
                intent.putExtra("image", images[position]);
                intent.putExtra("titles",titles[position]);
                startActivity(intent);
            }
        });
    }
}
