package com.github.mehrdadf7.easyokhttp;

import android.app.Activity;

import com.github.mehrdadf7.okhttp.OkHttpInjector;
import com.github.mehrdadf7.okhttp.OnResultCallback;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiService {

    public void getArticles(Activity activity, OnResultCallback<ArticleList> onResultCallback) {
        OkHttpInjector.getHttpClient().makeRequest(
                "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=847968758fc443dcbef779b238029441",
                ArticleList.class
        ).send(activity, onResultCallback);
    }

    public void getArticles(Observer<ArticleList> observer) {
        OkHttpInjector.getHttpClient().makeRequest(
                "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=847968758fc443dcbef779b238029441",
                ArticleList.class
        ).send().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread())
                .subscribe(observer);
    }

}
