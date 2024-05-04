package com.example.indusstore;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class Homepage extends AppCompatActivity {
    private Button StatButton; 
    private Button BookButton;
    private Button ProjButton;
    private Button Helpbutton;
    private Button AbtUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        StatButton = findViewById(R.id.stat_button);
        BookButton = findViewById(R.id.books_button);
        ProjButton = findViewById(R.id.proj_button);
        Helpbutton = findViewById(R.id.help_button);
        AbtUs = findViewById(R.id.Abtus);
        StatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onstationaryClick();
            }
        });
        BookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbookClick();
            }
        });
        ProjButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onprojClick();
            }
        });
        Helpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onhelpClick();
            }
        });
        AbtUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAbtClick();
            }
        });
    }
    private void onstationaryClick() {
        Intent intent = new Intent(Homepage.this, stationary.class);
        startActivity(intent);
    }
    private void onbookClick() {
        Intent intent = new Intent(Homepage.this, Book.class);
        startActivity(intent);
    }
    private void onprojClick() {
        Intent intent = new Intent(Homepage.this, Projects.class);
        startActivity(intent);
    }
    private void onhelpClick() {
        Intent intent = new Intent(Homepage.this, Help.class);
        startActivity(intent);
    }
    private void onAbtClick() {
        Intent intent = new Intent(Homepage.this, About.class);
        startActivity(intent);
    }
}
