# TabView
A widget to create custom Tabs.

![Screenshot 1](/app/src/main/res/raw/ss_1.png) ![Screenshot 2](/app/src/main/res/raw/ss_2.png)

## Set-up

#### Download 
[ ![Download](https://api.bintray.com/packages/hammadmukhtar/maven/TabView/images/download.svg) ](https://bintray.com/hammadmukhtar/maven/TabView/_latestVersion)

#### Grab via Gradle:
```groovy
compile 'com.innovoid:tabview:1.0.7'
```
#### Maven:
```xml
<dependency>
  <groupId>com.innovoid</groupId>
  <artifactId>tabview</artifactId>
  <version>1.0.7</version>
  <type>pom</type>
</dependency>
```

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

#### Programmatically
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

## Credits

Author: Hammad Mukhtar    

<a href="https://plus.google.com/+HammadMukhtar">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/hammadmukhtar">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://linkedin.com/in/hammadmukhtar">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>

# License

    Copyright 2017

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
