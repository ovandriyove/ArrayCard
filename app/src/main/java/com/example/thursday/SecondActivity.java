package com.example.thursday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager mLayout;
    private ArrayList<DayModel> mDayModel;
    private SharedPreferences sharedPreferences;
    private SessionMananger sharedPrefManager;

    private void initializedData (){
        mDayModel = new ArrayList<>();
        mDayModel.add(new DayModel("Sunday","Sny","sunday@gmail.com", R.mipmap.ic_sunday));
        mDayModel.add(new DayModel("Monday","Mny","monday@gmail.com", R.mipmap.ic_monday));
        mDayModel.add(new DayModel("Tuesday","Tsy","tuesday@gmail.com", R.mipmap.ic_tuesday));
        mDayModel.add(new DayModel("Wednesday","Wdy", "wednesday@gmail.com",R.mipmap.ic_wednesday));
        mDayModel.add(new DayModel("Thursday","Try","thursday@gmail.com",R.mipmap.ic_thursday));
        mDayModel.add(new DayModel("Friday","Fry","friday@gmail.com",R.mipmap.ic_friday));
        mDayModel.add(new DayModel("Saturday","Sty","saturday.gmail.com",R.mipmap.ic_saturday));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        mLayout = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(mLayout);
        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);


        initializedData();

        DayAdapter dayAdapter = new DayAdapter(mDayModel);
        recyclerView.setAdapter(dayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        Toast.makeText(this,"" + menuItem.getTitle(),Toast.LENGTH_SHORT).show();
        switch (menuItem.getItemId()){
            case R.id.logout_item:
                sharedPrefManager = new SessionMananger(this);
                sharedPrefManager.saveSharedPrefBoolean(SessionMananger.IS_LOGIN,false);
                startActivity(new Intent(SecondActivity.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
                sharedPrefManager.logOutUser();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
