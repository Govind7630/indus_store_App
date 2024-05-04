package com.example.indusstore;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
public class About extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ImageView instagram1 = findViewById(R.id.instagramLogo1);
        instagram1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagramProfile("govind_mudaliar"); 
            }
        });
        ImageView instagram2 = findViewById(R.id.instagramLogo2); 
        instagram2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagramProfile("ssup_om_"); 
            }
        });
        ImageView instagram3 = findViewById(R.id.instagramLogo3); 
        instagram3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagramProfile("bakarali_077"); 
            }
        });
    }
    private void openInstagramProfile(String username) {
        String url = "https://www.instagram.com/" + username;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}

