package com.example.retrofit_multiple_recyclerview_v2.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_multiple_recyclerview_v2.Model.Pub;
import com.example.retrofit_multiple_recyclerview_v2.Model.RoditelInterface;
import com.example.retrofit_multiple_recyclerview_v2.R;

public class HolderPub  extends RecyclerView.ViewHolder {
    TextView textPub;

    public HolderPub(@NonNull View itemView) {
        super(itemView);
        textPub = itemView.findViewById(R.id.textPub);
}

    // мы делаем тут bind чтобы сразу прописать все поля в этом holdere и уже
    // в адаптере добавляем их всех сразу (а не прописываем каждое поле отдельно)
    //в адаптере пишем-((HolderNews) holder).bind(x); вместо-holder.textTitle.setText(newnews.getTitle());
    public  void bind(RoditelInterface roditelInterface){
        if(roditelInterface instanceof Pub){
            Pub pub = ((Pub) roditelInterface);
            textPub.setText(pub.getText());
        }



}

}