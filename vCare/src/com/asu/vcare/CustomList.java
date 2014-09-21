package com.asu.vcare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomList extends ArrayAdapter<String>{
private final Activity context;
private final String[] web;
private final Integer[] imageId;
private final String[] desc;
public CustomList(Activity context,
String[] web, String[] desc, Integer[] imageId) {
super(context, R.layout.list_single, web);
this.context = context;
this.web = web;
this.imageId = imageId;
this.desc = desc;
}
@Override
public View getView(int position, View view, ViewGroup parent) {
LayoutInflater inflater = context.getLayoutInflater();
View rowView= inflater.inflate(R.layout.list_single, null, true);
TextView txtTitle = (TextView) rowView.findViewById(R.id.title);
TextView txtDesc = (TextView) rowView.findViewById(R.id.desc);
ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
txtTitle.setText(web[position]);
imageView.setImageResource(imageId[position]);
txtDesc.setText(desc[position]);
return rowView;
}
}