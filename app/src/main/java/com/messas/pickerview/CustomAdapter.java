package com.messas.pickerview;

// CustomAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {

    private int selectedIndex = -1;

    public CustomAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    public void setSelectedIndex(int position) {
        selectedIndex = position;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        }

        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(getItem(position));

        if (position == selectedIndex) {
            // Highlight the selected item
            view.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_blue_light));
        } else {
            // Reset the background color for other items
            view.setBackgroundColor(getContext().getResources().getColor(android.R.color.transparent));
        }

        return view;
    }
}
