package com.example.melikaafrakhteh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aboutmeActivity extends AppCompatActivity {
    private Button exit;
    private View View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        exit =findViewById(R.id.buttonExitF);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myShowIntent = new Intent (aboutmeActivity.this, MainActivity.class);
                startActivity(myShowIntent);
            }
        });
    }
}
