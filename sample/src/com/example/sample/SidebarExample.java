package com.example.sample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.brazhnik.SideBarScrollTest.SideBarComponent;

public class SidebarExample extends Activity {
    /**
     * Called when the activity is first created.
     */
    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };


    private SideBarComponent scroller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // initialize toggle buttons
        Button btnLeft = (Button) findViewById(R.id.button_left);
        btnLeft.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroller.toggleLeftSide();
            }
        });

        Button btnRight = (Button) findViewById(R.id.button_right);
        btnRight.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroller.toggleRightSide();
            }
        });

        // initialize sidebar navigation component
        scroller = (SideBarComponent) findViewById(R.id.scroller);
        View leftV = getLayoutInflater().inflate(R.layout.left_side_layout, null, false);
        scroller.setLeftSideView( leftV );

        View rightV = getLayoutInflater().inflate(R.layout.right_layout, null, false);
        scroller.setRightSideView(rightV);


        // initialize content
        ListView lvMain = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        lvMain.setAdapter(adapter);
        lvMain.setCacheColorHint(Color.TRANSPARENT);
        lvMain.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SidebarExample.this, "onItemClick", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
