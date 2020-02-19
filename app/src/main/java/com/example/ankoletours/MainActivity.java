package com.example.ankoletours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }
    public void sendMessage(View view){
        EditText message = findViewById(R.id.message);
        Toast.makeText (this, "Sending message " + message.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);

        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_booking) {
            Intent intent1 = new Intent(this, Booking.class);
            this.startActivity(intent1);
            return true;

        }

        if (id == R.id.menu_cleaning) {
            Intent intents = new Intent(this, cleaning.class);
            this.startActivity(intents);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
