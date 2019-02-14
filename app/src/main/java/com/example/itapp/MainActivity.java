package com.example.itapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String name;
    private int price;

    private EditText editTextName;
    private EditText editTextPrice;

    private Button buttonEnter;
    private Button buttonList;

    private Spinner spinnerType;
    private String[] spinnerAray;
    private String type = "K";

    Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextPrice = (EditText) findViewById(R.id.edit_text_price);

        buttonEnter = (Button) findViewById(R.id.button_enter);
        buttonList = (Button) findViewById(R.id.button_go_to_list);

        spinnerType = (Spinner) findViewById(R.id.spinner_type);
        spinnerAray = getResources().getStringArray(R.array.spinner_type);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, spinnerAray);
        spinnerType.setAdapter(spinnerArrayAdapter);
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    type = "K";
                } else {
                    type = "P";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = editTextName.getText().toString();
                price = Integer.valueOf(editTextPrice.getText().toString());

                utils.create(name, price, type);
                utils.yearCost(utils.pcostList);
                toastMethod(price, name, type);

            }
        });




    }

    void toastMethod(int price, String name, String type){
        Toast.makeText(this, "Add: "+ name + " " + price + " " + type , Toast.LENGTH_LONG).show();
    }





    private void init(){
        utils.create("Затраты на обучение ИТ-персонала в год", 1000, "P");
        utils.create("Средние затраты на закупку оборудования в год", 31600, "K");
        utils.create("Консультационные услуги третьих фирм и другие затраты на обслуживание", 6000, "K");
        utils.create("Средние затраты на программное обеспечение в год", 12000, "P");
        utils.create("Ежегодные затраты на комплектующие", 24000, "K");
        utils.create("Стоимость обслуживания техники по контрактам", 600, "K");
    }

    private void run(){
        utils.print();
        utils.yearCost(utils.pcostList);
    }
}

