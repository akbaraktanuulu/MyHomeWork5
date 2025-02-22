package com.example.myapplicationandroidlesson5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.myapplicationandroidlesson5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        String urlImage = "https://wdesk.ru/_ph/239/2/63524154.jpg?1734197071";

        Glide.with(MainActivity.this)
                .load(urlImage)
                .placeholder(R.color.gray)
                .error(R.color.black)
                .into(binding.imageView);
        binding.imageView.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MapsActivity.class));

        });
    }
}
/*
- Подключить Glide для отображении картиники
- При клике на картинку, открывать MapsActivity
-Подключить любую карту
-Получить API Key из консоли в зависимости от вашей карты, у каждого он уникальный
- Запросить разрешение на местоположение (Модалка)
- Показать себя на карте, при движении она должна двигаться
- Скинуть ссылку на гит
- Установить на телефон или на эмулятор чтобы продемонстрировать на уроке.
 */