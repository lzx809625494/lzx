package com.example.lizhixin.mvp_shixun2_mod;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper instance = null;
    private Context context;
    private  String url;
    private Retrofit retrofit = null;
    private RetrofitHelper(Context context,String url){
        this.context = context;
        this.url = url;
        init();
    }

    private void init() {
       retrofit = new Retrofit.Builder()
               .baseUrl(url)
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .addConverterFactory(GsonConverterFactory.create())
               .build();
    }
    public RetrofitService getService(){
        return  retrofit.create(RetrofitService.class);
    }
    //
    public static synchronized RetrofitHelper getInstance(Context context,String url){
        if (instance == null){
            instance = new RetrofitHelper(context,url);
        }
        return instance;
    }
}
