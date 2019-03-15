package com.example.lizhixin.mvp_shixun2_mod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lizhixin.mvp_shixun2_mod.Bean.Manager.Book;
import com.example.lizhixin.mvp_shixun2_mod.presenter.BookPresenter_;
import com.example.lizhixin.mvp_shixun2_mod.view.GetView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView main_text;
    private Button main_btn;
    BookPresenter_ bookPresenter_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bookPresenter_ = new BookPresenter_(this,"https://api.douban.com/v2/");
        bookPresenter_.attachView(getView);
    }
    private  GetView getView = new GetView(){

        @Override
        public void onSueccess(Book book) {
            main_text.setText(book.toString());
        }

        @Override
        public void onError(String error) {
            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
        }
    };
    private void initView() {
        main_text = (TextView) findViewById(R.id.main_text);
        main_btn = (Button) findViewById(R.id.main_btn);

        main_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn:
              bookPresenter_.getSearchBooks("金瓶梅",null,0,1);
                break;
        }
    }
}
