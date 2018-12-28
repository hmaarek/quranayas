package com.alqalamsoftware.quranayas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.alqalamsoftware.quranayas.MainActivity.getResId;
import static com.alqalamsoftware.quranayas.MainActivity.soraNames;

public class ImageZoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_zoom);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        int aya = intent.getIntExtra(MainActivity.AYA_MESSAGE, 1);
        int sora = intent.getIntExtra(MainActivity.SORA_MESSAGE, 0);

        adjustImage(aya,sora);

        TextView ayaDetails = findViewById(R.id.ayaDetails);

        ayaDetails.setText(soraNames[sora] + " : " + aya);

        //when user taps the aya image...activity closes and goes back to Main
        ImageView ayaImg = findViewById(R.id.ayaImg);
        ayaImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void adjustImage(int aya, int sora)
    {
        sora++;

        if (sora==0 || aya==0)
            return;


        //build resource name:
        String resName;
        resName = "a" + sora + "_" + aya;
        int resID = getResId(resName, R.drawable.class);

        final ImageView soraImg = (ImageView) findViewById(R.id.ayaImg);
        soraImg.setImageResource(resID);
    }
}
