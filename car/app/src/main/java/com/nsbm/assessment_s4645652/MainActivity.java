package com.nsbm.assessment_s4645652;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nsbm.assessment_s4645652.R;
import com.nsbm.assessment_s4645652.add_Car;
import com.nsbm.assessment_s4645652.check_Car;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddCarClicked(View view) {
        Intent addCar = new Intent(getApplicationContext(), add_Car.class);
        startActivity(addCar);
    }

    public void onCheckCarClicked(View view) {
        Intent checkCar = new Intent(getApplicationContext(), check_Car.class);
        startActivity(checkCar);
    }
}