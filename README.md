# Tabview
A widget to create Tabs.

![Screenshot 1](/app/src/main/res/raw/ss_1.png) ![Screenshot 2](/app/src/main/res/raw/ss_2.png)

## Usage
#### Using with default options

```xml
<com.innovoid.TabView
  android:layout_width="match_parent"
  android:layout_height="wrap_content"/>
```

#### Using with custom options
```xml
<com.innovoid.TabView
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  app:itemLayout="@layout/tabsview_item"
  app:itemLayoutTextViewId="@+id/tabsview_tv"
  app:items="@array/dummy_items"
  app:itemSelected="1"
  app:itemsTextColor="#9D9D9D"
  app:itemSelectedTextColor="#007C92"
  app:itemSelectedBackground="@drawable/tabsview_selected"
  app:itemUnselectedBackground="@drawable/tabsview_unselected"
  app:itemWidthEqual="false"
  android:padding="0.5dp"
  android:layout_margin="10dp"/>
```

#### Programmatic tabs manipulation
```java
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
```
