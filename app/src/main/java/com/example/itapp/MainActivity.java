package com.example.itapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.adapter.ListAdapteter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_text_name)
    EditText editTextName;
    @BindView(R.id.edit_text_price)
    EditText editTextPrice;
    @BindView(R.id.spinner_type)
    Spinner spinnerType;
    @BindView(R.id.button_enter)
    Button buttonEnter;
    @BindView(R.id.button_go_to_list)
    Button buttonGoToList;


    private String name;
    private int price;

    private String[] spinnerAray;
    private String type = "K";

    Utils utils = new Utils();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();


        spinnerAray = getResources().getStringArray(R.array.spinner_type);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, spinnerAray);
        spinnerType.setAdapter(spinnerArrayAdapter);
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    type = "K";
                } else {
                    type = "P";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    void toastMethod(int price, String name, String type) {
        Toast.makeText(this, "Add: " + name + " " + price + " " + type,
                Toast.LENGTH_LONG).show();
    }

    private void init(){
        utils.create("Затраты на обучение ИТ-персонала в год", 1000, "P");
        utils.create("Средние затраты на закупку оборудования в год", 31600, "K");
        utils.create("Консультационные услуги третьих фирм и другие затраты на обслуживание", 6000, "K");
        utils.create("Средние затраты на программное обеспечение в год", 12000, "P");
        utils.create("Ежегодные затраты на комплектующие", 24000, "K");
        utils.create("Стоимость обслуживания техники по контрактам", 600, "K");
    }

    private void run() {
        utils.print();
        utils.yearCost(utils.pcostList);
    }

    @OnClick({R.id.button_enter, R.id.button_go_to_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_enter:
                name = editTextName.getText().toString();
                price = Integer.valueOf(editTextPrice.getText().toString());

                utils.create(name, price, type);
                utils.yearCost(utils.pcostList);
                toastMethod(price, name, type);
                break;
            case R.id.button_go_to_list:
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
        }
    }
}

