package com.anas.dynamicfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessagesFragment extends Fragment {

    public MessagesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String name = "";
        int number = 0;

        //receiving bundle from main activity
        if (getArguments()!=null){
            name=getArguments().getString("Key_name");
            number=getArguments().getInt("Key_number");

            //method from main activity
            ((MainActivity) getActivity()).main2messages();

            Log.d("Values from Main Activity (messagesfrag)",name+" "+number);
        }

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        //settings messages_fragment text into text recieved from main activity
        TextView txtMessagesFrag=view.findViewById(R.id.txtMessagesFrag);
        txtMessagesFrag.setText(name);


        return view;
    }
}