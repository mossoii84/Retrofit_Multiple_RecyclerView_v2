package com.example.retrofit_multiple_recyclerview_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofit_multiple_recyclerview_v2.Adapter.MyAdapter;
import com.example.retrofit_multiple_recyclerview_v2.Model.News;
import com.example.retrofit_multiple_recyclerview_v2.Model.Pub;
import com.example.retrofit_multiple_recyclerview_v2.Model.RoditelInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MyActivity";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    List<RoditelInterface> roditelInterfaces = new ArrayList<>();
    //   Retrofit ссылка на наш url где лижат json массивы
    // Это наш  ENDPOINT
    public static final String ENDPOINT_URL = "https://my-json-server.typicode.com/Shiplayer/ExampleJsonData/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, roditelInterfaces);  //item это как бы данные указанных переменных
        recyclerView.setAdapter(myAdapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonUrlPost retrofitController = retrofit.create(JsonUrlPost.class);

        Call<List<News>> callNews = retrofitController.getNews();
        Call<List<Pub>>callPub = retrofitController.getPub();


        //Создаем объект, при помощи которого будем выполнять запросы, асинхроный вариант(.enqueue)
        // для класса News
        callNews.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
//                 listNews.addAll(response.body()); //записываем все приходящие данные в обьект класса
                roditelInterfaces.addAll(response.body());
                myAdapter.updateListNewsInfos(roditelInterfaces);

                // для класса Pub
                callPub.enqueue(new Callback<List<Pub>>() {
                    @Override
                    public void onResponse(Call<List<Pub>> call, Response<List<Pub>> response) {
//                 тут сделали сразу с сортировкой определенной по позициям
//                        int size = roditelInterfaces.size() / 2;
//                        List<Pub> list = response.body();
//                        int min = Math.min(size, list.size());
//                        for(int index = 1; index <= min;index++){
//                            roditelInterfaces.add(index * size, list.get(index));
//                        }
                        roditelInterfaces.addAll(response.body());
                        myAdapter.updateListNewsInfos(roditelInterfaces);
                    }
                    @Override
                    public void onFailure(Call<List<Pub>> call, Throwable t) { }
                });


            }
            @Override
            public void onFailure(Call<List<News>> call, Throwable t) { }
        });


    }




}




