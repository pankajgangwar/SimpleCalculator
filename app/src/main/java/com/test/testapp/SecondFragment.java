package com.test.testapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import utils.Utility;

/**
 * Created by iriemo on 14/5/15.
 */
public class SecondFragment extends Fragment {

    ListView listView;
    ArrayList<String> itemList;
    ArrayAdapter<String> arrayAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.second_fragment,container,false);
        listView = (ListView)view.findViewById(R.id.SecondFragmentListView);

        itemList = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            itemList.add("ListView 2: Item: " + i);
        }

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(arrayAdapter);

        if(getArguments().containsKey(Utility.KEY_ARGS)){
            int position = getArguments().getInt(Utility.KEY_ARGS);

            listView.setSelection(position);
        }
        return view;
    }
}
