package com.innovoid;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.innovoid.tabview.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Hammad Mukhtar on 15-Aug-17.
 */

public class TabView extends LinearLayout {

    int itemLayout, itemSelectedBackground, itemUnselectedBackground, textViewId, items, itemsColor, itemSelectedColor;
    boolean itemWidthEqual = false;
    int selectedIndex = 0;

    List<String> list;

    OnSelectListener mListener;

    public TabView(final Context context, AttributeSet attrs){
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TabView, 0, 0);

        try {
            itemLayout = a.getResourceId(R.styleable.TabView_itemLayout, R.layout.tabsview_item);
            itemSelectedBackground = a.getResourceId(R.styleable.TabView_itemSelectedBackground, R.drawable.tabsview_selected);
            itemUnselectedBackground = a.getResourceId(R.styleable.TabView_itemUnselectedBackground, R.drawable.tabsview_unselected);

            textViewId = a.getResourceId(R.styleable.TabView_itemLayoutTextViewId, R.id.tabsview_tv);
            items = a.getResourceId(R.styleable.TabView_items, R.array.dummy_items);

            itemWidthEqual = a.getBoolean(R.styleable.TabView_itemWidthEqual, false);
            itemSelectedColor = a.getColor(R.styleable.TabView_itemSelectedTextColor, getContext().getResources().getColor(R.color.tabview_selected_item_color));
            itemsColor = a.getColor(R.styleable.TabView_itemsTextColor, getContext().getResources().getColor(R.color.tabview_grey));
            selectedIndex = a.getInteger(R.styleable.TabView_itemSelected, 1) - 1;
            list = Arrays.asList(context.getResources().getStringArray(items));
        } finally {
            a.recycle();
        }

        makeViews();
    }

    public void makeViews(){

        Context context = getContext();

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int size = list.size();

        int totalCharacters = 0;
        for(int i = 0 ; i < list.size() ; i++){
            totalCharacters += list.get(i).length();
            if(list.get(i).length() == 1)
                totalCharacters++;
        }
        if(selectedIndex > list.size() - 1)
            selectedIndex = list.size() - 1;

        this.setWeightSum(1f);

        for(int i = 0 ; i < size ; i++){
            final int position = i;
            View view = layoutInflater.inflate(itemLayout, null );
            ((TextView) view.findViewById(textViewId)).setText(list.get(i));

            LayoutParams param;
            if(itemWidthEqual)
                param = new LayoutParams(
                        0,
                        LayoutParams.MATCH_PARENT,
                        (getWeightSum()/((float)size))
                );
            else
                param = new LayoutParams(
                        0,
                        LayoutParams.MATCH_PARENT,
                        ((list.get(i).length() == 1 ? ((float) list.get(i).length() + 1)
                                : ((float) list.get(i).length()))/((float) totalCharacters))
                );
            view.setLayoutParams(param);

            view.setBackgroundResource(itemUnselectedBackground);
            ((TextView) view.findViewById(textViewId)).setTextColor(itemsColor);
            if(i == selectedIndex) {
                view.setBackgroundResource(itemSelectedBackground);
                ((TextView) view.findViewById(textViewId)).setTextColor(itemSelectedColor);
            }
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int j = 0; j < TabView.this.getChildCount() ; j++){
                        TabView.this.getChildAt(j).setBackgroundResource(itemUnselectedBackground);
                        ((TextView) TabView.this.getChildAt(j).findViewById(textViewId)).setTextColor(itemsColor);
                    }
                    v.setBackgroundResource(itemSelectedBackground);
                    ((TextView) v.findViewById(textViewId)).setTextColor(itemSelectedColor);
                    selectedIndex = position;
                    if(mListener != null)
                        mListener.onSelect(TabView.this, list.get(position));
                }
            });
            this.addView(view);
        }
        this.setBackground(getContext().getResources().getDrawable(R.drawable.tabsview_background));
    }

    /* Returns Pixel from density pixels (dp) */
    int dpToPx(float dp) {
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, getContext().getResources().getDisplayMetrics());
    }

    public OnSelectListener getItemSelectedListener() {
        return mListener;
    }

    public void setOnItemClickListener(OnSelectListener mListener) {
        this.mListener = mListener;
    }

    public int getItemLayout() {
        return itemLayout;
    }

    public void setItemLayout(int itemLayout) {
        this.itemLayout = itemLayout;
        updateViews();
        requestLayout();
    }

    public int getItemSelectedBackground() {
        return itemSelectedBackground;
    }

    public void setItemSelectedBackground(int itemSelectedBackground) {
        this.itemSelectedBackground = itemSelectedBackground;
        updateViews();
        requestLayout();
    }

    public int getItemUnselectedBackground() {
        return itemUnselectedBackground;
    }

    public void setItemUnselectedBackground(int itemUnselectedBackground) {
        this.itemUnselectedBackground = itemUnselectedBackground;
        updateViews();
        requestLayout();
    }

    public int getTextViewId() {
        return textViewId;
    }

    public void setTextViewId(int textViewId) {
        this.textViewId = textViewId;
        updateViews();
        requestLayout();
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
        updateViews();
        requestLayout();
    }

    public int getItemsColor() {
        return itemsColor;
    }

    public void setItemsColor(int itemsColor) {
        this.itemsColor = itemsColor;
        updateViews();
        requestLayout();
    }

    public int getItemSelectedColor() {
        return itemSelectedColor;
    }

    public void setItemSelectedColor(int itemSelectedColor) {
        this.itemSelectedColor = itemSelectedColor;
        updateViews();
        requestLayout();
    }

    public boolean isItemWidthEqual() {
        return itemWidthEqual;
    }

    public void setItemWidthEqual(boolean itemWidthEqual) {
        this.itemWidthEqual = itemWidthEqual;
        updateViews();
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public String getSelectedItem() {
        return list != null && !list.isEmpty() ? list.get(selectedIndex) : "";
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(int arrayId) {
        items = arrayId;
        list = Arrays.asList(getContext().getResources().getStringArray(items));
        updateViews();
    }

    public void setList(List<String> list) {
        this.list = list;
        updateViews();
    }

    public void setList(String[] list) {
        this.list = Arrays.asList(list);
        updateViews();
    }

    public void updateViews(){
        Context context = getContext();
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int size = list.size();

        int totalCharacters = 0;
        for(int i = 0 ; i < list.size() ; i++){
            totalCharacters += list.get(i).length();
            if(list.get(i).length() == 1)
                totalCharacters++;
        }
        if(selectedIndex > list.size() - 1)
            selectedIndex = list.size() - 1;
        this.setWeightSum(1f);

        for(int i = 0 ; i < size ; i++){
            final int position = i;
            View view = layoutInflater.inflate(itemLayout, null );
            ((TextView) view.findViewById(textViewId)).setText(list.get(i));

            LayoutParams param;
            if(itemWidthEqual)
                param = new LayoutParams(
                        0,
                        LayoutParams.MATCH_PARENT,
                        (getWeightSum()/((float)size))
                );
            else
                param = new LayoutParams(
                        0,
                        LayoutParams.MATCH_PARENT,
                        ((list.get(i).length() == 1 ? ((float) list.get(i).length() + 1)
                                : ((float) list.get(i).length()))/((float) totalCharacters))
                );
            view.setLayoutParams(param);

            view.setBackgroundResource(itemUnselectedBackground);
            ((TextView) view.findViewById(textViewId)).setTextColor(itemsColor);
            if(i == selectedIndex) {
                view.setBackgroundResource(itemSelectedBackground);
                ((TextView) view.findViewById(textViewId)).setTextColor(itemSelectedColor);
            }
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int j = 0; j < TabView.this.getChildCount() ; j++){
                        TabView.this.getChildAt(j).setBackgroundResource(itemUnselectedBackground);
                        ((TextView) TabView.this.getChildAt(j).findViewById(textViewId)).setTextColor(itemsColor);
                    }
                    v.setBackgroundResource(itemSelectedBackground);
                    ((TextView) v.findViewById(textViewId)).setTextColor(itemSelectedColor);
                    selectedIndex = position;
                    if(mListener != null)
                        mListener.onSelect(TabView.this, list.get(position));
                }
            });
            this.addView(view);
        }
    }

    public interface OnSelectListener {
        void onSelect(View view, String selectedValue);
    }
}
