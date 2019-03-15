package com.example.lizhixin.mvp_shixun2_mod.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.lizhixin.mvp_shixun2_mod.Bean.Manager.Book;
import com.example.lizhixin.mvp_shixun2_mod.manager.DataManager;
import com.example.lizhixin.mvp_shixun2_mod.view.GetView;
import com.example.lizhixin.mvp_shixun2_mod.view.View;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BookPresenter_ implements BookPresenter{
    private Context context;
    private  String url;
    private  Book book;
    DataManager manager;
    GetView getView;
    public BookPresenter_(Context context, String url){
        this.context = context;
        this.url = url;
    }
    @Override
    public void getSearchBooks(String name, String tag, int start, int count) {
        manager = new DataManager(context,url);

        manager.getSearchBook(name,tag,start,count)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<Book>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(Book book) {
                         BookPresenter_.this.book = book;
                     }

                     @Override
                     public void onError(Throwable e) {
                         getView.onError("获取失败！");
                     }

                     @Override
                     public void onComplete() {
                         if (book != null){
                             getView.onSueccess(book);
                         }
                     }
                 });
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
          getView = (GetView) view;
    }

    @Override
    public void attachIncommingIntent(Intent intent) {

    }
}
