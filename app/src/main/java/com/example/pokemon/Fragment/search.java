package com.example.pokemon.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentManager;

import com.example.pokemon.ExampleAdapter;
import com.example.pokemon.R;
import com.example.pokemon.data;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class search extends Fragment implements ExampleAdapter.ItemClickListener{
    @Nullable
    public ArrayList<String> mExampleList;
    ExampleAdapter mAdapter;

    public static Fragment newInstance() {
        Fragment f = new Fragment();
        return f;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search,null);
        setHasOptionsMenu(true);
        createExampleList();

        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mAdapter = new ExampleAdapter(mExampleList,this);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    private void createExampleList() {
        mExampleList = new ArrayList();
        for (int i = 0; i < data.pokemonname().length; i++) {
            mExampleList.add(data.pokemonname()[i]);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onItemClick(String mExampleList) {
        Fragment f = pokedex.newInstance(mExampleList);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_bottom, f).commit();
    }
}
