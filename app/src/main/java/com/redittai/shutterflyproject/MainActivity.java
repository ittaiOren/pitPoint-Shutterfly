package com.redittai.shutterflyproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.redittai.shutterflyproject.Models.pitPoint;

public class MainActivity extends AppCompatActivity {
    Button addPit;
    View pit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        pit = findViewById(R.id.view2);
        addPit = (Button) findViewById(R.id.addPitBTN);
        addPit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addaNewPitPoint();
            }
        });

    }
    // used to determine the position of the initialized pitPoint
    private float getScreenWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int widthInPixel = Math.round(dm.widthPixels);
        return widthInPixel;
    }
    // add a new pit point to the view group
    private void addaNewPitPoint(){
        pitPoint p = new pitPoint(getApplicationContext(),getScreenWidth()/2 , getScreenWidth() / 2);
        com.redittai.shutterflyproject.Views.mCanvas.pitPoints.add(p);
        pit.invalidate();
    }


}
