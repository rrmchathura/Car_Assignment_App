package com.nsbm.assessment_s4645652;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nsbm.assessment_s4645652.R;
import com.nsbm.assessment_s4645652.database.DbManager;
import com.nsbm.assessment_s4645652.entity.addCar;

public class check_Car extends AppCompatActivity {

    EditText etCarbrand;
    EditText etCarmodel;
    EditText etCarprice;

    Button  btnCheckCarPrice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_car);

        etCarbrand = findViewById(R.id.etCarbrand);
        etCarmodel = findViewById(R.id.etCarmodel);
        etCarprice = findViewById(R.id.etCarprice);
        btnCheckCarPrice = findViewById(R.id.btnCheckCarPrice);

    }


    public void onCheckCarPriceClick(View view) {



        String carBrand = etCarbrand.getText().toString().trim();
        String carModel = etCarmodel.getText().toString().trim();

        if (carBrand.isEmpty() || carBrand.isEmpty()){
            etCarbrand.setError("Please enter the car brand");
            etCarmodel.setError("Please enter the car model");
            Toast.makeText(this,"Check Again",Toast.LENGTH_SHORT).show();
        }else {
            DbManager dbManager = new DbManager(this);
            addCar addcar = dbManager.getCarbyBrandAndModel(carBrand, carModel);

            etCarprice.setText(addcar.getCarPrice());
        }


    }
}