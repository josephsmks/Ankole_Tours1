package com.example.ankoletours;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*public class Receiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }*/
   BroadcastReceiver broadcast = new MyReceiver(){
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            int battery= intent.getIntExtra("Battery Level",5);
            ProgressBar myBar = findViewById(R.id.progressBar);
            myBar.setProgress(battery);
            TextView mytxt = findViewById(R.id.broadcast);
            mytxt.setText("Battery low"+Integer.parseInt(String.valueOf(battery))+"%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(broadcast, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        }
        //Alarm broadcasting
        public void alarm(View v){
        EditText txt = findViewById(R.id.alarm);
      //bellow not finished
            int i=Integer.parseInt(txt.getText().toString());
            //cresting sn intent to call the broadcast created
            Intent intent = new Intent(this,MyReceiver.class);
            //creating a pending intent and call the receiver
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
            //Alarm manager class to generate an alarm
            AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);

            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);
            Toast.makeText(this,"alarm set in"+ i +"seconds",Toast.LENGTH_LONG).show();


        }
        Button myButton;
    public void sendMessage(View view){
        EditText message = findViewById(R.id.message);
        Toast.makeText (this, "Sending message " + message.getText().toString(), Toast.LENGTH_SHORT).show();
         myButton = findViewById(R.id.sendButton);
        Intent intents = new Intent(this, screenone.class);
        startActivity(intents);

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);

        return true;

    }
     @SuppressLint("IntentReset")
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_booking) {
            //Intent intent1 = new Intent(this, Booking.class);
            //this.startActivity(intent1);
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0757613785"));
            startActivity(intent);
            return true;

        }

        if (id == R.id.menu_cleaning) {
            //Intent intents = new Intent(this, cleaning.class);
            //this.startActivity(intents);
            Intent intent2 = new Intent(Intent.ACTION_SEND);
            intent2.setData(Uri.parse("mailto:"));
            String[] to;
            to = new String[]{"denydory014@gmail.com", "josephsmukasa@gmail.com", "twntskbnn@gmail.com"};
            intent2.putExtra(Intent.EXTRA_EMAIL, to);
            intent2.putExtra(Intent.EXTRA_SUBJECT,"Hey, We have a MUCOSA meeting Today");
            intent2.putExtra(Intent.EXTRA_TEXT,"Try to keep time");
            intent2.setType("message/rfc882");
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
