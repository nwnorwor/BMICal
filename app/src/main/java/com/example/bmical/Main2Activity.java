package com.example.bmical;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    private  static final String TAG = Main2Activity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button calButton = findViewById(R.id.CalculateButton);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = findViewById(R.id.heightEditText);
                EditText weightEditText = findViewById(R.id.weightEditText);

                int height = Integer.parseInt(heightEditText.getText().toString());
                int weight = Integer.parseInt(weightEditText.getText().toString());

                float C = cal(height,weight);

                String resultText = null;
                if(C < 16.5){
                    resultText = "ผอมเกินไป";
                } else if(C < 25){
                    resultText = "น้ำหนักปกติ ไม่อ้วนไม่ผอม";
                } else if(C < 30){
                    resultText = "อ้วน";
                } else {
                    resultText = "อ้วนมาก";
                }

                //String message = "ค่า BMI เท่ากับ "+ String.format(Locale.US,"%.2f",C);
                String message = "เกณฑ์น้ำหนักของคุณ "+ resultText;

                Toast t = Toast.makeText(
                        Main2Activity.this,"ค่า  BMI เท่ากับ " + String.valueOf(C),
                        Toast.LENGTH_LONG
                );
                t.show();

                AlertDialog.Builder dialog = new AlertDialog.Builder(Main2Activity.this);
                dialog.setTitle("Result");
                dialog.setMessage(message);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                //dialog.setNegativeButton("No",null);
                dialog.setCancelable(false);
                dialog.show();

            }
        });

    }

    private float cal(int heightInCm , int weightInKg){
        float h = heightInCm / 100f;
        Log.i(TAG, "ความสูงหน่วยเมตร = "+String.valueOf(h));
        float bmi = weightInKg / (h*h);
        return  bmi;
    }



}
