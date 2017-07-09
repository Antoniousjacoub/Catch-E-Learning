package com.example.corsatk.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.corsatk.controller.Item;
import com.example.corsatk.R;
import com.example.corsatk.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class About extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private GridLayoutManager gridLayoutManager;
    private List<Item> items;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("About");
        //implement arrow button
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                onBackPressed();
            }
        });

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        initItemsData();

        gridLayoutManager = new GridLayoutManager(this, 1);
        itemAdapter = new ItemAdapter(items, gridLayoutManager);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initItemsData() {
        items = new ArrayList<>(6);
        items.add(new Item(R.drawable.fahad, "DR.Fahad ", "Instructor", "01143777734"));
        items.add(new Item(R.drawable.farid, "DR.Farid", "Instructor", " 01278815226"));
        items.add(new Item(R.drawable.bola, "Bola", "Android Developer", "bolatalaat055@gmail.com "));
        items.add(new Item(R.drawable.tony, "Antonious", "Android Developer", "AntoniousJacoub@gmail.coom"));
        items.add(new Item(R.drawable.ahmed, "Ahmed", "Graphic Designer", "ahmedshanzlezeh@outlook.com"));
        items.add(new Item(R.drawable.mostafa, "Mostafa", "Web Developer", "mostafahasieb13@yahoo.com"));
        items.add(new Item(R.drawable.khalid, "khalid", "AR Developer", "khalidshaker@yahoo.com"));
        items.add(new Item(R.drawable.alaa, "Alaa", "Web Developer", "khalidshaker@yahoo.com"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_switch_layout) {
            switchLayout();
            switchIcon(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayout() {
        switch (gridLayoutManager.getSpanCount()) {
            case 1:
                gridLayoutManager.setSpanCount(3);
                break;
            case 3:
                gridLayoutManager.setSpanCount(1);
                break;
            default:
                gridLayoutManager.setSpanCount(1);
                break;
        }
        itemAdapter.notifyItemRangeChanged(0, itemAdapter.getItemCount());
    }

    private void switchIcon(MenuItem item) {
        if (gridLayoutManager.getSpanCount() == 3) {
            item.setIcon(getResources().getDrawable(R.drawable.cpp));
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.cpp));
        }
    }
}
