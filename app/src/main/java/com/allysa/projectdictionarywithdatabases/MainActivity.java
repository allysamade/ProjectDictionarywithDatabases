package com.allysa.projectdictionarywithdatabases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    private TextView txtIndonesia;
    private EditText txtInggris;
    private DataDictionary datakamus = null;
    public static final String INGGRIS = "inggris";
    public static final String INDONESIA = "indonesia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datakamus = new DataDictionary(this);
        db = datakamus.getWritableDatabase();
        datakamus.createTable(db);
        datakamus.generateData(db);

        setContentView(R.layout.activity_main);
        txtInggris = (EditText) findViewById(R.id.wordInggis);
        txtIndonesia = (TextView) findViewById(R.id.worldIndonesia);


    }

    public void getTerjemahan(View view) {
        String result = "";
        String englishword = txtInggris.getText().toString();
        kamusCursor = db.rawQuery("SELECT ID, INDONESIA, INGGRIS "
                + "FROM kamus where INDONESIA='" + englishword
                + "' ORDER BY INDONESIA", null);

        if (kamusCursor.moveToFirst()) {
            result = kamusCursor.getString(2);
            for (; !kamusCursor.isAfterLast(); kamusCursor.moveToNext()) {
                result = kamusCursor.getString(2);
            }
        }
        if (result.equals("")) {
            result = "Terjemahan Not Found";
        }
        txtIndonesia.setText(result);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        kamusCursor.close();
        db.close();
    }

}


