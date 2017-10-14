package com.innovoid.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.innovoid.TabView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Set a callback on tab item click */
        TabView tabview = findViewById(R.id.tabview);
        tabview.setOnItemClickListener(new TabView.OnSelectListener() {
            @Override
            public void onSelect(View view, String selectedValue) {
                //Todo: On item selection
            }
        });

        /* Initialize or change Tab items with List */
        List<String> list = new ArrayList<>();
        list.add("Apartment");
        list.add("Villa");
        tabview.setList(list);

        /* Initialize or change Tab items with Array */
        String [] array = {"Studio", "1", "2", "3", "4"};
        tabview.setList(array);

        /* Initialize or change Tab items with Array resource */
        tabview.setList(R.array.dummy_items);

        /* Get selected tab item */
        String selectedItem = tabview.getSelectedItem();

        /* Get selected item index */
        int selectedIndex = tabview.getSelectedIndex();

        /* Set selected index*/
        tabview.setSelectedIndex(0);

        /* Set if item width needs to be equal or according to content */
        tabview.setItemWidthEqual(true);
    }
}
