package com.example.echoapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;



import com.example.echoapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText wordsToEcho;
    private Snackbar pSnackBar;
    private String textInEditText;
    private TextView wordsEchoed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupField();
        setupToolBar();
        setupFAB();
    }

    private void setupField()
    {
        wordsToEcho = findViewById(R.id.text_to_copy);
        View layoutMain = findViewById(R.id.main_activity);
        pSnackBar = Snackbar.make(layoutMain, "", Snackbar.LENGTH_INDEFINITE);
        wordsEchoed = findViewById(R.id.tv_output);
    }

    private void setupToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void setupFAB() {
        ExtendedFloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> handleFABClick());
    }

    private void handleFABClick()
    {
        String toEcho = wordsToEcho.getText ().toString ();
        if(toEcho.length() > 0)
        {
            String echo = wordsToEcho.getText().toString();
            wordsEchoed.setText(echo);
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "You must enter a valid string",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void showMessage(String msg)
    {
        pSnackBar.setText(msg);
        pSnackBar.show();
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

