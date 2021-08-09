package com.nsbm.assessment_s4645652;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nsbm.assessment_s4645652.database.DbManager;
import com.nsbm.assessment_s4645652.entity.addCar;

public class add_Car extends AppCompatActivity {

    EditText etCarBrand;
    EditText etCarPrice;
    EditText etCarModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        etCarBrand = findViewById(R.id.etCarBrand);
        etCarModel = findViewById(R.id.etCarModel);
        etCarPrice = findViewById(R.id.etCarPrice);

    }

    public void onbtnAddcarclick(View view) {
        addCar addCar = new addCar(etCarBrand.getText().toString(),etCarModel.getText().toString(),etCarPrice.getText().toString());
        DbManager dbManager = new DbManager(this);
        long retValue = dbManager.addEntity(addCar);

        if (retValue == -1){
            Toast.makeText(add_Car.this,"Error! Try Again",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(add_Car.this,"Successfully Added!",Toast.LENGTH_SHORT).show();
            Log.d("TAGS",addCar.getCarBrand());
        }
    }
}