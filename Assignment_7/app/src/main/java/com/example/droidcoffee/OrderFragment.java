package com.example.droidcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OrderFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_order, container, false);


        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = getView();
        Intent intent = getActivity().getIntent();
        String message = "Order: " +
                intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        TextView textView = v.findViewById(R.id.order_textview);
        textView.setText(message);

        Spinner spinner = v.findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    Toast.makeText(getActivity().getApplicationContext(), getString(R.string.same_day_messenger_service),
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextday:
                if (checked)
                    Toast.makeText(getActivity().getApplicationContext(), getString(R.string.next_day_ground_delivery),
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.pickup:
                if (checked)
                    Toast.makeText(getActivity().getApplicationContext(), getString(R.string.pick_up),
                            Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getActivity().getApplicationContext(),spinnerLabel,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
