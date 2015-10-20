package com.example.jere.database3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity_cargar extends AppCompatActivity {
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_cargar);
        et1=(EditText)findViewById(R.id.et1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_cargar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void cargar(View view) {
        AdminSQLiteOpenHelper Admin =new AdminSQLiteOpenHelper(this);
        SQLiteDatabase db=Admin.getWritableDatabase();
        String nombre_cabaña=et1.getText().toString();
         ContentValues registro=new ContentValues();
        registro.put("nombre",nombre_cabaña);
        db.insert("caban", null, registro);
        db.close();
        et1.setText("");
        Toast.makeText(this, "se cargo la cabaña", Toast.LENGTH_SHORT).show();
    }

    }

