package com.example.lizhixin.mvp_shixun2_mod;

import com.example.lizhixin.mvp_shixun2_mod.Bean.Manager.Book;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBook(@Query("q") String name,
                                   @Query("tag") String tag,
                                   @Query("start") int start,
                                   @Query("count") int count);
}
