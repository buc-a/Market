package com.example.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Activity2Binding binding = Activity2Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+binding.number.getText().toString()));
                startActivity(intent);
            }
        });


        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //добавление всех выбранных элементо в строку
                String str = "";
                if(binding.fruit.isChecked()){
                    str+=" " + (binding.fruit.getText().toString());
                }
                if(binding.m.isChecked()){
                    str+=" " + (binding.m.getText().toString());
                }
                if(binding.vegetables.isChecked()){
                    str+=" " + (binding.vegetables.getText().toString());
                }
                if(binding.sweet.isChecked()){
                    str+=" "+(binding.sweet.getText().toString());
                }
                if(binding.alcohol.isChecked()){
                    str+=" "+(binding.alcohol.getText().toString());
                }
                if(binding.freezing.isChecked()){
                    str+=" "+(binding.freezing.getText().toString());
                }
                if(binding.yes.isChecked()){
                    str+=". Заказать доставку";
                }
                if(binding.no.isChecked()){
                    str+=". Забрать самостоятельно";
                }

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"butz.angelina@icloud.com"});
                intent.putExtra(Intent.EXTRA_TEXT,str);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Напоминание");
                startActivity(intent);
            }
        });
    }
}
