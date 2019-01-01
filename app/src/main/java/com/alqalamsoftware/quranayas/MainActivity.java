package com.alqalamsoftware.quranayas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.lang.reflect.Field;



public class MainActivity extends AppCompatActivity {

    public static final String AYA_MESSAGE = "com.alqalamsoftware.quranayas.AYA";
    public static final String SORA_MESSAGE = "com.alqalamsoftware.quranayas.SORA";
    static final int BUTTON_PRESSED_IN_ZOOM = 1;

    static final int soraLengths[]={7, 286, 200, 176, 120,
            165, 206, 75, 129, 109, 123, 111, 43, 52, 99, 128, 111, 110, 98, 135, 112, 78, 118, 64,
            77, 227, 93, 88, 69, 60, 34, 30, 73, 54, 45, 83, 182, 88, 75, 85, 54, 53, 89, 59, 37, 35,
            38, 29, 18, 45, 60, 49, 62, 55, 78, 96, 29, 22, 24, 13, 14, 11, 11, 18, 12, 12, 30, 52,
            52, 44, 28, 28, 20, 56, 40, 31, 50, 40, 46, 42, 29, 19, 36, 25, 22, 17, 19, 26, 30, 20,
            15, 21, 11, 8, 8, 19, 5, 8, 8, 11, 11, 8, 3, 9, 5, 4, 7, 3, 6, 3, 5, 4, 5, 6};

    static String soraNames[];

    public static final String STATE_TAG = "MainActivity-States";

    {
        soraNames = new String[]{
                " سورة الفاتحة",
                "  سورة البقرة",

                "  سورة آل عمران",

                "  سورة النساء",

                "  سورة المائدة",

                "  سورة الأنعام",

                "  سورة الأعراف",

                "  سورة الأنفال",

                "  سورة التوبة",

                "  سورة يونس",

                "  سورة هود",

                "  سورة يوسف",

                "  سورة الرعد",

                "  سورة إبراهيم",

                "  سورة الحجر",

                "  سورة النحل",

                "  سورة الإسراء",

                "  سورة الكهف",

                "  سورة مريم",

                "  سورة طه",

                "  سورة الأنبياء",

                "  سورة الحج",

                "  سورة المؤمنون",

                "  سورة النّور",

                "  سورة الفرقان",

                "  سورة الشعراء",

                "  سورة النّمل",

                "  سورة القصص",

                "  سورة العنكبوت",

                "  سورة الرّوم",

                "  سورة لقمان",

                "  سورة السجدة",

                "  سورة الأحزاب",

                "  سورة سبأ",

                "  سورة فاطر",

                "  سورة يس",

                "  سورة الصافات",

                "  سورة ص",

                "  سورة الزمر",

                "  سورة غافر",

                "  سورة فصّلت",

                "  سورة الشورى",

                "  سورة الزخرف",

                "  سورة الدّخان",

                "  سورة الجاثية",

                "  سورة الأحقاف",

                "  سورة محمد",

                "  سورة الفتح",

                "  سورة الحجرات",

                "  سورة ق",

                "  سورة الذاريات",

                "  سورة الطور",

                "  سورة النجم",

                "  سورة القمر",

                "  سورة الرحمن",

                "  سورة الواقعة",

                "  سورة الحديد",

                "  سورة المجادلة",

                "  سورة الحشر",

                "  سورة الممتحنة",

                "  سورة الصف",

                "  سورة الجمعة",

                "  سورة المنافقون",

                "  سورة التغابن",

                "  سورة الطلاق",

                "  سورة التحريم",

                "  سورة الملك",

                "  سورة القلم",

                "  سورة الحاقة",

                "  سورة المعارج",

                "  سورة نوح",

                "  سورة الجن",

                "  سورة المزّمّل",

                "  سورة المدّثر",

                "  سورة القيامة",

                "  سورة الإنسان",

                "  سورة المرسلات",

                "  سورة النبأ",

                "  سورة النازعات",

                "  سورة عبس",

                "  سورة التكوير",

                "  سورة الإنفطار",

                "  سورة المطفّفين",

                "  سورة الإنشقاق",

                "  سورة البروج",

                "  سورة الطارق",

                "  سورة الأعلى",

                "  سورة الغاشية",

                "  سورة الفجر",

                "  سورة البلد",

                "  سورة الشمس",

                "  سورة الليل",

                "  سورة الضحى",

                "  سورة الشرح",

                "  سورة التين",

                "  سورة العلق",

                "  سورة القدر",

                "  سورة البينة",

                "  سورة الزلزلة",

                "  سورة العاديات",

                "  سورة القارعة",

                "  سورة التكاثر",

                "  سورة العصر",

                "  سورة الهمزة",

                "  سورة الفيل",

                "  سورة قريش",

                "  سورة الماعون",

                "  سورة الكوثر",

                "  سورة الكافرون",

                "  سورة النصر",

                "  سورة المسد",

                "  سورة الإخلاص",

                "  سورة الفلق",

                "  سورة النّاس"
        };
    }


    //---------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //sora np:
        final NumberPicker np_sora = (NumberPicker) findViewById(R.id.np_sora);
        final NumberPicker np_aya = (NumberPicker) findViewById(R.id.np_aya);

        np_sora.setMaxValue(113);
        np_sora.setMinValue(0);
        np_sora.setDisplayedValues(soraNames);

        if (savedInstanceState==null || savedInstanceState.isEmpty()) {
            np_sora.setValue(0);
        }

        np_aya.setMinValue(1);
        np_aya.setMaxValue(soraLengths[0]);

        final ImageView soraImg = (ImageView) findViewById(R.id.sora_img);
        soraImg.setImageResource(R.drawable.a1_1);


        np_sora.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected value from picker
                np_aya.setMaxValue(soraLengths[newVal]);
                np_aya.setValue(1);
                adjustImage(np_aya.getValue(), np_sora.getValue());
            }
        });

        np_aya.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                adjustImage(np_aya.getValue(), np_sora.getValue());
            }
        });

        ImageView plusBut = findViewById(R.id.plus_but);
        ImageView minusBut= findViewById(R.id.minus_but);


        //Increase Aya
        plusBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                incAya(np_sora,np_aya);

            }
        });

        minusBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                decAya(np_sora, np_aya);
            }
        });


        ImageView ayaImage = findViewById(R.id.sora_img);
        ayaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "Aya Pressed!", Toast.LENGTH_SHORT).show();
                //Intent intent = getIntent();
                zoomAya(v, np_aya.getValue(), np_sora.getValue());
            }
        });


    }

    //---------------------------------------------------------------------------------------------
    private void saveData()
    {
        int aya, sora;
        NumberPicker np_sora = (NumberPicker) findViewById(R.id.np_sora);
        NumberPicker np_aya = (NumberPicker) findViewById(R.id.np_aya);

        aya = np_aya.getValue();
        sora = np_sora.getValue();

        SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.saved_aya_value), aya);
        editor.putInt(getString(R.string.saved_sora_value), sora);
        editor.commit();
    }

    //---------------------------------------------------------------------------------------------
    private void restoreData()
    {
        int aya, sora;
        SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        aya = sharedPref.getInt(getString(R.string.saved_aya_value), 1);
        sora = sharedPref.getInt(getString(R.string.saved_sora_value), 0);

        NumberPicker np_sora = (NumberPicker) findViewById(R.id.np_sora);
        NumberPicker np_aya = (NumberPicker) findViewById(R.id.np_aya);

        np_aya.setMinValue(1);
        np_aya.setMaxValue(soraLengths[sora]);

        np_aya.setValue(aya);
        np_sora.setValue(sora);

        adjustImage(aya,sora);
    }

    //---------------------------------------------------------------------------------------------
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(STATE_TAG, "onSaveInstanceState: called");

        NumberPicker np_sora = findViewById(R.id.np_sora);
        NumberPicker np_aya  = findViewById(R.id.np_aya);

        outState.putInt("Aya", np_aya.getValue());
        outState.putInt("Sora", np_sora.getValue());

        saveData();
    }

    //---------------------------------------------------------------------------------------------
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(STATE_TAG, "onRestoreInstanceState: called");

        int aya=1;
        int sora =0;
        if (savedInstanceState!=null && !savedInstanceState.isEmpty()) {
            aya = savedInstanceState.getInt("Aya");
            sora = savedInstanceState.getInt("Sora");
        }

        NumberPicker np_sora = (NumberPicker) findViewById(R.id.np_sora);
        NumberPicker np_aya = (NumberPicker) findViewById(R.id.np_aya);


        np_aya.setMinValue(1);
        np_aya.setMaxValue(soraLengths[sora]);

        np_aya.setValue(aya);
        np_sora.setValue(sora);

        adjustImage(aya,sora);
    }

    //---------------------------------------------------------------------------------------------
    @Override
    protected void onPause() {
        super.onPause();

        Log.d(STATE_TAG, "onPause: called");
    }
    //---------------------------------------------------------------------------------------------
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(STATE_TAG, "onStop: called");

        saveData();
    }
    //---------------------------------------------------------------------------------------------
    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d(STATE_TAG, "onPostResume: called");
    }
    //---------------------------------------------------------------------------------------------
    @Override
    protected void onStart() {
        super.onStart();

        Log.d(STATE_TAG, "onStart: called");

        restoreData();

    }
    //---------------------------------------------------------------------------------------------
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(STATE_TAG, "onDestroy: called");
    }

    //---------------------------------------------------------------------------------------------
    private void incAya(NumberPicker np_sora, NumberPicker np_aya)
    {
        int sora = np_sora.getValue();
        int aya = np_aya.getValue();
        aya ++;
        if (aya > soraLengths[sora])
        {
            aya = 1;
            sora++;
            if (sora > 113)
                sora = 0;
        }
        np_aya.setMaxValue(soraLengths[sora]);
        np_aya.setValue(aya);
        np_sora.setValue(sora);
        adjustImage(np_aya.getValue(), np_sora.getValue());
    }

    //---------------------------------------------------------------------------------------------
    private void decAya(NumberPicker np_sora, NumberPicker np_aya)
    {
        int sora = np_sora.getValue();
        int aya = np_aya.getValue();

        aya --;
        if (aya < 1 )
        {

            sora--;
            if (sora < 0)
                sora = 113;

            aya = soraLengths[sora];
        }
        np_aya.setMaxValue(soraLengths[sora]);
        np_aya.setValue(aya);
        np_sora.setValue(sora);

        adjustImage(np_aya.getValue(), np_sora.getValue());
    }

    //---------------------------------------------------------------------------------------------
    /** Called when the user taps the Aya Image */
    public void zoomAya(View view, int aya, int sora) {
        Intent intent = new Intent(this, ImageZoomActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        intent.putExtra(AYA_MESSAGE, aya);
        intent.putExtra(SORA_MESSAGE, sora);
        startActivityForResult(intent, BUTTON_PRESSED_IN_ZOOM);
    }

    //---------------------------------------------------------------------------------------------
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BUTTON_PRESSED_IN_ZOOM) {
            if (resultCode == RESULT_OK) {
                //String returnedResult = data.getData().toString();
                // OR
                 String returnedResult = data.getDataString();
                final NumberPicker np_sora = (NumberPicker) findViewById(R.id.np_sora);
                final NumberPicker np_aya = (NumberPicker) findViewById(R.id.np_aya);

                switch (returnedResult)
                 {
                     case "next":
                         incAya(np_sora, np_aya);
                         break;

                     case "prev":
                         decAya(np_sora, np_aya);
                         break;

                     case "quit":
                         break;
                 }

                 saveData();  //so when we close the zoom, onStart will read the correct values
                 zoomAya(MainActivity.this.getCurrentFocus(), np_aya.getValue(), np_sora.getValue() );
            }
        }
    }

    //---------------------------------------------------------------------------------------------
    private void adjustImage(int aya, int sora)
    {
        sora++;

        if (sora==0 || aya==0)
            return;


        //build resource name:
        String resName;
        resName = "a" + sora + "_" + aya;
        int resID = getResId(resName, R.drawable.class);

        final ImageView soraImg = (ImageView) findViewById(R.id.sora_img);
        soraImg.setImageResource(resID);
    }

    //---------------------------------------------------------------------------------------------
    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }



    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
}
