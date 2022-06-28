package com.example.task2_mobile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeActivity extends Fragment {
    TextView textViewHome;
    EditText editTextHome;
    Button btnSubmitFragmentHome, LoadingBtn;
    AlertDialog dialogFirstPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View HomeViewFragment = inflater.inflate(R.layout.fragment_home_activity, container, false);
        textViewHome = HomeViewFragment.findViewById(R.id.tv_textFragment);
        editTextHome = HomeViewFragment.findViewById(R.id.et_textFragment);
        btnSubmitFragmentHome = HomeViewFragment.findViewById(R.id.btn_submitFragment);
        LoadingBtn = HomeViewFragment.findViewById(R.id.loadingButton);

        ProgressDialog progressDialog= new ProgressDialog(getContext());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Aplikasi sedang di jalankan...");
        progressDialog.setCancelable(true);

        LoadingBtn.setOnClickListener(view -> {
            progressDialog.show();
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Confirm").setMessage("Are you sure want to edit the title text?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textViewHome.setText(editTextHome.getText().toString());
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogFirstPage.dismiss();
                Toast.makeText(getActivity(), "Changes canceled", Toast.LENGTH_SHORT).show();
            }
        });
        dialogFirstPage = builder.create();

        btnSubmitFragmentHome.setOnClickListener(view -> {
            dialogFirstPage.show();
        });
        return HomeViewFragment;
        //Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home_activity, container, false);
    }
}