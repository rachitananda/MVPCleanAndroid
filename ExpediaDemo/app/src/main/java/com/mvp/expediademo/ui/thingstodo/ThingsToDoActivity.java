package com.mvp.expediademo.ui.thingstodo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mvp.expediademo.BaseApplication;
import com.mvp.expediademo.R;
import com.mvp.expediademo.http.thingstodo.SearchAPIService;
import com.mvp.expediademo.http.thingstodo.model.ThingItem;
import com.mvp.expediademo.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThingsToDoActivity extends BaseActivity implements ThingsToDoMVP.View {

    @Inject
    ThingsToDoMVP.Presenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView thingsRecyclerView;

    @Inject
    SearchAPIService searchAPIService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.things_to_do_layout);

        setUnbinder(ButterKnife.bind(this));

        ((BaseApplication) getApplication()).createThingsToDoComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getLoadFromAPI(searchAPIService);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BaseApplication) getApplication()).releaseMovieComponent();
        presenter.rxUnbind();
    }

    @OnClick(R.id.fetch_btn)
    public  void fetchFromAPI(){
        presenter.getLoadFromAPI(searchAPIService);
    }


    @Override
    public void showError(String message) {

    }


    @Override
    public void showMessage(String message) {

    }

    @Override
    public void populateList(List<ThingItem> things) {
        LinearLayoutManager lLayout = new LinearLayoutManager(this);
        thingsRecyclerView.setLayoutManager(lLayout);

        ThingsAdapter rcAdapter = new ThingsAdapter(this, things);
        thingsRecyclerView.setAdapter(rcAdapter);
    }
}
