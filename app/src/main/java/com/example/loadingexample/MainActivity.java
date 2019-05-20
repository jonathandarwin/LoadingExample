package com.example.loadingexample;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loadingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setListener();
    }

    private void setListener(){
        binding.btnFullLoading.setOnClickListener(this);
        binding.btnDialogLoading.setOnClickListener(this);
        binding.btnShowHideLoading.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(binding.btnFullLoading)) {
            final ProgressDialog loading = new ProgressDialog(this);
            loading.setCanceledOnTouchOutside(false);
            loading.setMessage("Loading");
            loading.show();

            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    loading.dismiss();
                    handler.postDelayed(this, 3000);
                }
            };
            handler.postDelayed(runnable, 3000);
        } else if (v.equals(binding.btnDialogLoading)) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                    handler.postDelayed(this, 3000);
                }
            };
            handler.postDelayed(runnable, 3000);

        } else if (v.equals(binding.btnShowHideLoading)) {
            // USE RELATIVE LAYOUT AS THE PARENT OF THIS TYPE OF LOADING
            binding.loading.setVisibility(View.VISIBLE);

            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    binding.loading.setVisibility(View.GONE);
                    handler.postDelayed(this, 3000);
                }
            };
            handler.postDelayed(runnable, 3000);
        }
    }
}
