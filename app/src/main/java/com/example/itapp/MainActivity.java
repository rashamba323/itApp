package com.example.itapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Utils utils = new Utils();



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

