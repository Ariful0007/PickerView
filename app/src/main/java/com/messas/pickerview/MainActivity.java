package com.messas.pickerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOptionsPickerView singlePicker = new MyOptionsPickerView(MainActivity.this);
        final ArrayList<String> items = new ArrayList<String>();
        for (int i = 1; i <= 254; i++) {
            items.add(""+i);
        }
        singlePicker.setPicker(items);
        singlePicker.setCyclic(false);
        int defaultSelection = 128 - 1;
        singlePicker.setSelectOptions(defaultSelection);
        singlePicker.setCancelButtonText("Cancel");
        singlePicker.setCancelButtonText("Cancel");
        singlePicker.setSubmitButtonText("Select");


        singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //  singleTVOptions.setText("Single Picker " + items.get(options1));
                Toast.makeText(MainActivity.this, "" + items.get(options1), Toast.LENGTH_SHORT).show();

            }
        });
        singlePicker.show();
    }
}