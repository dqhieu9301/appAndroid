package com.example.appandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ViewFlipper;

import com.example.appandroid.model.TypeOfFood;
import com.example.appandroid.model.TypeOfFoodAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Animation left_to_right,right_to_left;
    private RecyclerView recycleView_listTypeFood;
    private TypeOfFoodAdapter typeOfFoodAdapter;
    private List<TypeOfFood> getList() {
        List<TypeOfFood> typeOfFoodList = new ArrayList<>();
        typeOfFoodList.add(new TypeOfFood(R.drawable.pizza, "Pizaa"));
        typeOfFoodList.add(new TypeOfFood(R.drawable.humbeger, "Hamburger"));
        typeOfFoodList.add(new TypeOfFood(R.drawable.khoai_tay_chien, "Potato chips"));
        typeOfFoodList.add(new TypeOfFood(R.drawable.ga_ran, "Fried chicken"));
        return  typeOfFoodList;
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inital();
        actionViewFlipper();
        actionListTypeOfFood();
    }

    private void inital() {
        viewFlipper = findViewById(R.id.viewFlipper);
        recycleView_listTypeFood = findViewById(R.id.recycleView_listTypeFood);
    }

    private void actionViewFlipper() {
        left_to_right = AnimationUtils.loadAnimation(this,R.anim.left_to_right);
        right_to_left = AnimationUtils.loadAnimation(this,R.anim.right_to_left);
        viewFlipper.setInAnimation(left_to_right);
        viewFlipper.setOutAnimation(right_to_left);
        viewFlipper.setFlipInterval(4500);
        viewFlipper.setAutoStart(true);
    }

    private void actionListTypeOfFood() {
        typeOfFoodAdapter = new TypeOfFoodAdapter(getList());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recycleView_listTypeFood.setLayoutManager(gridLayoutManager);
        recycleView_listTypeFood.setAdapter(typeOfFoodAdapter);
    }



}