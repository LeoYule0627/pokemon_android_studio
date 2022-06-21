package com.example.pokemon;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.Fragment.search;
import com.example.pokemon.Fragment.type;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity{
    public ArrayList<String> mExampleList;
    ExampleAdapter mAdapter;
    BottomNavigationView bottomNavigationView;
    TextView welcome;
    private NavigationBarView.OnItemSelectedListener navigation = new NavigationBarView.OnItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f = new type();
            switch (item.getItemId()) {
                case R.id.type:
                    f = new type();
                    welcome.setVisibility(View.INVISIBLE);
                    break;
                case R.id.search:
                    f = new search();
                    welcome.setVisibility(View.INVISIBLE);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom, f).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.welcome);
        bottomNavigationView = findViewById(R.id.bottom_menu0);
        bottomNavigationView.setOnItemSelectedListener(navigation);

        Fragment fragment  = search.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_bottom, fragment, "main_fragment");
        transaction.commit();
    }

}
