package com.example.android.edittexttest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText input, digits, pass, phone;
    private Button next, display;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this.getApplicationContext();

        input = (EditText) findViewById(R.id.editInp);
        digits = (EditText) findViewById(R.id.editDig);
        pass = (EditText) findViewById(R.id.editPass);
        phone = (EditText) findViewById(R.id.editPhone);

        phone.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast msg = Toast.makeText(getBaseContext(), "Only 10 numbers",
                Toast.LENGTH_LONG);
        msg.show();

    }
});

        next = (Button) findViewById(R.id.nextBtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, NextScreen.class);
                myIntent.putExtra("pass", pass.getText().toString());
                myIntent.putExtra("phone", phone.getText().toString());
                startActivity(myIntent);

            }
        });

        display = (Button) findViewById(R.id.displayBtn);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setTextColor(Color.RED);
                String displayString = "You typed '" + input.getText().toString() +
                        "' as input text and '" + digits.getText().toString() + "' as digits";
                Toast msg = Toast.makeText(getBaseContext(), displayString,
                        Toast.LENGTH_LONG);
                msg.show();


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
