package com.example.lizhixin.mvp_shixun2_mod.view;

import com.example.lizhixin.mvp_shixun2_mod.Bean.Manager.Book;

public interface GetView extends View {
    void onSueccess(Book book);
    void onError(String error);
}
