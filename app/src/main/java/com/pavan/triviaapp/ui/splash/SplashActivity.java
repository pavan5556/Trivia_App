package com.pavan.triviaapp.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pavan.triviaapp.R;
import com.pavan.triviaapp.ui.history.HistoryActivity;
import com.pavan.triviaapp.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Handler handler = new Handler(Looper.myLooper());

        final BottomSheetDialog dialog = new BottomSheetDialog(SplashActivity.this);
        dialog.setContentView(R.layout.bottomssheet_addname);
        final TextInputEditText nameET = dialog.findViewById(R.id.addname_et);
        final TextInputLayout textInputLayout = dialog.findViewById(R.id.addname_textInputLayout);
        dialog.findViewById(R.id.next_iv_bottomsheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameET.getText().toString().isEmpty()) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("Name Required");
                } else {
                    textInputLayout.setErrorEnabled(false);
                    SharedPreferences preferences = getSharedPreferences("trivia", MODE_PRIVATE);
                    preferences.edit().putString("name", nameET.getText().toString().trim()).apply();
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        dialog.findViewById(R.id.view_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 100);
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.show();
            }
        }, 1000);


    }
}