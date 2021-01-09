package com.example.retrofit_multiple_recyclerview_v2.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_multiple_recyclerview_v2.Model.News;
import com.example.retrofit_multiple_recyclerview_v2.Model.RoditelInterface;
import com.example.retrofit_multiple_recyclerview_v2.R;

public class HolderNews extends RecyclerView.ViewHolder {
    TextView textTitle, textAuthor,description;

    public HolderNews(@NonNull View itemView) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.textTitle);
        textAuthor = itemView.findViewById(R.id.textAuthor);
        description = itemView.findViewById(R.id.description);
    }


    // мы делаем тут bind чтобы сразу прописать все поля в этом holdere и уже
   // в адаптере добавляем их всех сразу (а не прописываем каждое поле отдельно)
  //в адаптере пишем-((HolderPub)holder).bind(x); ; вместо-holder.textTitle.setText(newnews.getTitle());
    public void bind(RoditelInterface roditel) {
        if(!(roditel instanceof News)){
            return;
        }
        News item = (News) roditel;
        textTitle.setText(item.getTitle());
        textAuthor.setText(item.getAuthor());
        description.setText(item.getDescription());
    }

}