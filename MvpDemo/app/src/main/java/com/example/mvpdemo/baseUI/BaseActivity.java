package com.example.mvpdemo.baseUI;


import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import butterknife.Unbinder;

public class BaseActivity extends AppCompatActivity implements BaseMvpView {

    private Unbinder unbinder;
//    private ActivityComponent activityComponent;


//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
////        activityComponent  = DaggerActivityComponent.builder()
////                .activityModule(new ActivityModule(this))
////                .applicationComponent(((App) getApplication()).getComponent())
////                .build();
//
//
//    }

    @Override
    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public ActivityComponent getActivityComponent() {
//        return null;
//    }
}
