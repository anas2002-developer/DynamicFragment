package com.anas.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//contains dynamic frag + backstack of frags + data passing in frags
public class MainActivity extends AppCompatActivity {

    String Root_Frag="root_fagment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtMessages,txtStatus,txtCalls;

        txtMessages=findViewById(R.id.txtMessages);
        txtStatus=findViewById(R.id.txtStatus);
        txtCalls=findViewById(R.id.txtCalls);

        //default frag
        loadFrag(new MessagesFragment(),0);

        txtMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFrag(new MessagesFragment(),0);

            }
        });

        txtStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFrag(new StatusFragment(),1);
            }
        });

        txtCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFrag(new CallsFragment(), 1);

            }
        });
    }

    //flag 0 for add , 1 for replace , 2 for remove
    public void loadFrag(Fragment fragment_name, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Bundle bundle=new Bundle();
        bundle.putString("Key_name","Asus");
        bundle.putInt("Key_number",7060);
        fragment_name.setArguments(bundle);

        if (flag == 0) {
            ft.add(R.id.FL, fragment_name);

            //inclusive=1
            //0=exclusive then multiple copies of root frag will remain their
            fm.popBackStack(Root_Frag,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(Root_Frag);

        }
        else{
            ft.replace(R.id.FL, fragment_name);
            ft.addToBackStack(null);
        }
//            ft.remove(R.id.FL, fragment_name);

        ft.commit();
    }

    @SuppressLint("LongLogTag")
    public void main2messages(){
        Log.d("Method of Main Activity in ","Messages Fragement");
    }
}