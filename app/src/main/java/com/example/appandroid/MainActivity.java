package com.example.appandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.appandroid.model.TypeOfFood;
import com.example.appandroid.model.TypeOfFoodAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Animation left_to_right,right_to_left;
    private RecyclerView recycleView_listTypeFood;
    private TypeOfFoodAdapter typeOfFoodAdapter;
    LinearLayout linearLayout_account;
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
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView,navController);
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