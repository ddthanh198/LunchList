package com.jack.lunchlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvRestaurants;
    private RadioGroup rgTypes;
    private EditText etName;
    private EditText etAddr;
    private Button btnSave;
    private ImageView ivType;

    private ArrayList<Restaurant> listRestaurants = new ArrayList<>();
    private ArrayList<Restaurant> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();
        setupListView();

    }

    private void setupListView(){
        ListRestaurantAdapter adapter = new ListRestaurantAdapter(this,R.layout.item_list_restaurants,listRestaurants);
        lvRestaurants.setAdapter(adapter);
    }

    private void init(){
        lvRestaurants = findViewById(R.id.lv_list_restaurants);
        rgTypes = findViewById(R.id.rg_types);
        etName = findViewById(R.id.et_name);
        etAddr = findViewById(R.id.et_addr);
        btnSave = findViewById(R.id.btn_save);
        ivType = findViewById(R.id.iv_type);
    }

    private void setEvent(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant restaurant = new Restaurant();
                restaurant.setName(etName.getText().toString());
                restaurant.setAddress(etAddr.getText().toString());
                switch (rgTypes.getCheckedRadioButtonId()){
                    case R.id.rb_takeout:
                        restaurant.setType("Take out");
                        break;
                    case R.id.rb_sit_down:
                        restaurant.setType("Sit down");
                        break;
                    case R.id.rb_delivery:
                        restaurant.setType("Delivery");
                        break;
                }
                listRestaurants.add(restaurant);
            }
        });

        rgTypes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_takeout:
                        ivType.setImageResource(R.drawable.img_takeout);
                        break;
                    case R.id.rb_sit_down:
                        ivType.setImageResource(R.drawable.img_sit_down);
                        break;
                    case R.id.rb_delivery:
                        ivType.setImageResource(R.drawable.img_delivery);
                        break;
                }
            }
        });

    }
}
