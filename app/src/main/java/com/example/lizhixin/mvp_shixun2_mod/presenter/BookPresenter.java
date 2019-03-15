package com.example.lizhixin.mvp_shixun2_mod.presenter;

public interface BookPresenter extends Presenter{
    void getSearchBooks(String name,String tag,int start,int count);
}
