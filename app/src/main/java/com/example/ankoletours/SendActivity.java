package com.example.ankoletours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
        TextView messageView = findViewById(R.id.messageTextView);
        messageView.setText(message);

    }

    public void onClose(View view) { super.finish();


    }
    public void sendMessage(View view) {
        EditText message = (EditText)findViewById(R.id.edit_message);
        Intent intent = new Intent(this, SendActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
    }

}
