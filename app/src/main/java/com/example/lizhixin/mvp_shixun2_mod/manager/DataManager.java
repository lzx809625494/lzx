package com.example.lizhixin.mvp_shixun2_mod.manager;

import android.content.Context;

import com.example.lizhixin.mvp_shixun2_mod.Bean.Manager.Book;
import com.example.lizhixin.mvp_shixun2_mod.RetrofitHelper;
import com.example.lizhixin.mvp_shixun2_mod.RetrofitService;

import java.util.Observable;

public class DataManager {
    private RetrofitService retrofitService;
    public DataManager(Context context,String url){
        this.retrofitService = RetrofitHelper.getInstance(context,url).getService();
    }
    public io.reactivex.Observable<Book> getSearchBook(String name, String tag, int start, int count){
        return retrofitService.getSearchBook(name,tag,start,count);
    }
}
