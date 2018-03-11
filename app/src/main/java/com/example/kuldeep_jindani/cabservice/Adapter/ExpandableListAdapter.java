package com.example.kuldeep_jindani.cabservice.Adapter;

/**
 * Created by Kuldeep_jindani on 3/4/2018.
 */



import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kuldeep_jindani.cabservice.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader;
    List<Drawable> ArrayList; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
ExpandableListView vehicle_expandable;


    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData,ExpandableListView vehicle_expandable,List<Drawable>  ArrayList) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.vehicle_expandable=vehicle_expandable;
        this.ArrayList=ArrayList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.vehicle_expandable_item_layout, parent,false);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.expandable_item_name);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.vehicle_expandable_layout, null);
        }
//        final ImageView expandable_image=convertView.findViewById(R.id.expandable_image);
        switch (groupPosition){
            case 0:

            case 1:
                @SuppressLint("CutPasteId") ImageView expandable_image=convertView.findViewById(R.id.expandable_image);
                expandable_image.setImageDrawable(ArrayList.get(groupPosition));
            case 2:
                @SuppressLint("CutPasteId") ImageView expandable_image1=convertView.findViewById(R.id.expandable_image);
                expandable_image1.setImageDrawable(ArrayList.get(groupPosition));
            case 3:
                @SuppressLint("CutPasteId") ImageView expandable_image2=convertView.findViewById(R.id.expandable_image);
                expandable_image2.setImageDrawable(ArrayList.get(groupPosition));
            case 4:
                @SuppressLint("CutPasteId") ImageView expandable_image3=convertView.findViewById(R.id.expandable_image);
                expandable_image3.setImageDrawable(ArrayList.get(groupPosition));
            case 5:
                @SuppressLint("CutPasteId") ImageView expandable_image4=convertView.findViewById(R.id.expandable_image);
                expandable_image4.setImageDrawable(ArrayList.get(groupPosition));
        }



        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.expandable_name);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);



        vehicle_expandable.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();

                final ImageView expandable_image = v.findViewById(R.id.expandable_angular);
                if (parent.isGroupExpanded(groupPosition)) {

                    expandable_image.setImageDrawable(_context.getResources().getDrawable(R.drawable.ic_right_angular));
                }else {
                    expandable_image.setImageDrawable(_context.getResources().getDrawable(R.drawable.ic_down_angular));
                }
                return false;
            }
        });


        vehicle_expandable.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(_context,
                        _listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();



            }
        });

        vehicle_expandable.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(_context,
                        _listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
                /*final ImageView expandable_image=v.findViewById(R.id.expandable_angular);
                expandable_image.setImageDrawable(_context.getResources().getDrawable(R.drawable.ic_right_angular));*/
            }
        });

        vehicle_expandable.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        _context,
                        _listDataHeader.get(groupPosition)
                                + " : "
                                + _listDataChild.get(
                                _listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}