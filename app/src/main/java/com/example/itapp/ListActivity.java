package com.example.itapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Model.Pcost;
import com.example.adapter.ListAdapteter;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends AppCompatActivity {


    @BindView(R.id.button_go_to_main)
    Button buttonGoToMain;
    @BindView(R.id.list_item)
    RecyclerView listItem;
    @BindView(R.id.edit_text_name)
    EditText editTextName;
    @BindView(R.id.edit_text_price)
    EditText editTextPrice;
    @BindView(R.id.spinner_type)
    Spinner spinnerType;
    @BindView(R.id.text_view_log)
    TextView textViewLog;

    private String name;
    private int price;

    private String[] spinnerAray;
    private String type = "K";

    ListAdapteter listAdapteter = new ListAdapteter();

    Utils utils = new Utils();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        //init();

        List<Pcost> list = utils.getPcostList();
        System.out.println(list.toString());

        listItem.setLayoutManager(new LinearLayoutManager(this));
        listItem.setAdapter(listAdapteter);
        listAdapteter.setList(list);

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

    private void init() {
        Random random = new Random();
        String type[] = {"P", "K"};
        for (int i = 1; i <= 11; i++) {
            utils.create("Затраты на обучение ИТ-персонала в год", 1000 * i, "P");
            utils.create("Средние затраты на закупку оборудования в год", 31600 * i, "K");
            utils.create("Консультационные услуги третьих фирм и другие затраты на обслуживание", 6000 * i, "K");
            utils.create("Средние затраты на программное обеспечение в год", 12000 * i, "P");
            utils.create("Ежегодные затраты на комплектующие", 24000 * i, "K");
            utils.create("Стоимость обслуживания техники по контрактам", 600 * i, "K");
        }

    }

    @OnClick(R.id.button_go_to_main)
    public void onClick() {
        name = editTextName.getText().toString();
        price = Integer.valueOf(editTextPrice.getText().toString());
        listAdapteter.update();

        utils.create(name, price, type);
        textViewLog.setText(utils.yearCost(utils.pcostList));
    }
}
