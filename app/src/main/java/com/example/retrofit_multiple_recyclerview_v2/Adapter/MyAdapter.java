package com.example.retrofit_multiple_recyclerview_v2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_multiple_recyclerview_v2.MainActivity;
import com.example.retrofit_multiple_recyclerview_v2.Model.Pub;
import com.example.retrofit_multiple_recyclerview_v2.Model.RoditelInterface;
import com.example.retrofit_multiple_recyclerview_v2.R;
import java.util.List;



//Чет в итоге так и не получилось расставить как хотел
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "MyAdapter";
    public List<RoditelInterface> listRoditelUpdate;

    public MyAdapter(MainActivity mainActivity, List<RoditelInterface> listRoditelUpdate) {
        this.listRoditelUpdate = listRoditelUpdate;
    }

    @Override
    public int getItemCount() {
        return listRoditelUpdate.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 2){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardpub, parent,false);//стандартная запись
            return new HolderPub(view);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent,false);
            return new HolderNews(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RoditelInterface x =listRoditelUpdate.get(position);
        if(holder instanceof  HolderPub){
            ((HolderPub)holder).bind(x);
        }
        else{
            ((HolderNews) holder).bind(x);
        }
    }



    public void updateListNewsInfos(List<RoditelInterface> listRoditelUpdate){
        this.listRoditelUpdate = listRoditelUpdate;
        // Уведомляем адаптор о том, что у нас поменялись данные и необходимо заново слинковать данные из bind
        notifyDataSetChanged();
    }


    //создаем типы чтобы можно было выводить то что нам нужно по типу
    @Override
    public int getItemViewType(int position) {
        RoditelInterface item = listRoditelUpdate.get(position);
        if(item instanceof Pub){
            return 2;
        } else {
            return 0;
        }

//        return position % 2 * 2;
//                int viewType = 0; //Default is 1
//                if (position == 2) viewType = 2; //if zero, it will be a header view
//                return viewType;
    }




}
