package com.example.indusstore;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    private Button languageButton;
    private String currentLanguage; 
    private static final String LANGUAGE_PREF_KEY = "language_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languageButton = findViewById(R.id.languageButton);
        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleLanguage();
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        currentLanguage = sharedPreferences.getString(LANGUAGE_PREF_KEY, "en");
        setLocale(currentLanguage);
    }
    public void onLoginButtonClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
    public void onSignUpButtonClick(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }
    private void toggleLanguage() {
        if (currentLanguage.equals("en")) {
            setLocale("hi"); 
            currentLanguage = "hi";
        } else {
            setLocale("en"); 
            currentLanguage = "en";
        }
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LANGUAGE_PREF_KEY, currentLanguage);
        editor.apply();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}