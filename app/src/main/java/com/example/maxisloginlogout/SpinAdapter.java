package com.example.maxisloginlogout;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpinAdapter extends ArrayAdapter<EntityDropdown> {

    private Context context;
    private EntityDropdown[] values;

    public SpinAdapter(Context context, int textViewResourceId, EntityDropdown[] values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount(){
        return values.length;
    }

    @Override
    public EntityDropdown getItem(int position){

        return values[position];
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
//        if (super == null)
//s            System.out.println("super is null");
        System.out.println("position:");
        System.out.println(position);
        if(values== null || values.length <= position)
        {
            System.out.println("values.length:");
          return new TextView(context);
        }
        System.out.println("values.length:1");
        TextView label;

        try {
            label = (TextView) super.getView(position, convertView, parent);
        }
        catch (Exception e)
        {
            System.out.println("values.length:1.1");
            label=new TextView(context);
        }
        System.out.println("values.length:2");

        label.setTextColor(Color.BLACK);
        System.out.println("values.length:3");
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        System.out.println("values:");
      try
      {label.setText(values[position].getName());}
      catch (Exception e)
      {label.setText("");}


        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values[position].getName());

        return label;
    }
}
