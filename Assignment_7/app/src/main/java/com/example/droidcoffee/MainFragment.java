package com.example.droidcoffee;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    ImageView donutImg = null;
    ImageView iceImg = null;
    ImageView froyoImg = null;
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";
    String mOrderMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_main, container, false);


        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = getView();
        donutImg = v.findViewById(R.id.donut);
        donutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.donut_order_message);
                Toast.makeText(getActivity().getApplicationContext(), "donut_order_message", Toast.LENGTH_SHORT).show();
            }
        });
        iceImg = v.findViewById(R.id.ice_cream);
        iceImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.ice_cream_order_message);
                Toast.makeText(getActivity().getApplicationContext(), "ice_order_message", Toast.LENGTH_SHORT).show();
            }
        });
        froyoImg = v.findViewById(R.id.froyo);
        froyoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.froyo_order_message);
                Toast.makeText(getActivity().getApplicationContext(), "froyo_order_message", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClick(View view) {
        Intent intent =
                new Intent(getContext().getApplicationContext(), MainFragment.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }
}
