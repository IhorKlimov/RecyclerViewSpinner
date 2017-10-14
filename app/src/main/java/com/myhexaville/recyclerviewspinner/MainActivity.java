package com.myhexaville.recyclerviewspinner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.myhexaville.recyclerviewspinner.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    private List<Laptop> laptops;
    private Adapter laptopsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        setupList();

        setupSort();
    }

    private void setupSort() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                        this,
                        R.array.sort_types,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
//                    sortByName();
                } else {
//                    sortByPrice();
                }
                laptopsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void sortByName() {
        Log.d(TAG, "sortByName: ");
        Collections.sort(laptops,  (l1, l2) -> l1.getName().compareTo(l2.getName()));
    }

    private void sortByPrice() {
        Log.d(TAG, "sortByPrice: ");
        Collections.sort(laptops, (l1, l2) -> {
            if (l1.getPrice() > l2.getPrice()) {
                return 1;
            } else if (l1.getPrice() < l2.getPrice()) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    private void setupList() {
        laptops = new ArrayList<>();
        laptops.add(new Laptop("MacBook Pro 13''", 1299));
        laptops.add(new Laptop("MacBook Pro 15''", 1499));
        laptops.add(new Laptop("Razer Stealth", 1399));
        laptops.add(new Laptop("Asus R540LA-XX543T", 349));
        laptops.add(new Laptop("HP Spectre", 1159));

        laptopsAdapter = new Adapter(this, laptops);
        binding.list.setAdapter(laptopsAdapter);
        binding.list.setLayoutManager(new LinearLayoutManager(this));
    }

}
