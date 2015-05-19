package com.test.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

/**
 * Created by iriemo on 14/5/15.
 */
public class FirstFragment extends Fragment {

    ListView listView;
    ArrayList<String> itemList;
    ArrayAdapter<String> arrayAdapter;
    OnListItemClickListener listItemClickListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            listItemClickListener = (OnListItemClickListener)activity;
        } catch(ClassCastException e){
            throw new ClassCastException( FirstActivity.class.getSimpleName() +" must implements " + OnListItemClickListener.class.getSimpleName());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.first_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.FirstFragmentListView);

        itemList = new ArrayList<String>();

        for (int i = 0; i < 50; i++) {
            itemList.add("ListView 1: Item: " + i);
        }

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(itemClickListener);

        return view;
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            listItemClickListener.onItemClick(position);
        }
    };
}
