package com.example.pokemon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public  class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> implements Filterable {
    private ArrayList<String> mExampleList;
    private ArrayList<String> mExampleListFull;
    ArrayList<String>[][] arrayListAllData;
    private ItemClickListener clickListener;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(android.R.id.text1);

        }
    }

        public ExampleAdapter(ArrayList<String> exampleList,ItemClickListener clickListener) {
            super();
            this.mExampleList = exampleList;
            this.clickListener = clickListener;
            mExampleListFull = new ArrayList<>(mExampleList);
        }

        @Override
        public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
            ExampleViewHolder evh = new ExampleViewHolder(view);
            return evh;
        }

        @Override
        public void onBindViewHolder(ExampleViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.mTextView1.setText(mExampleList.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    clickListener.onItemClick(mExampleList.get(position));
                }
            });
        }

        @Override
        public int getItemCount() {
            return mExampleList.size();
        }

        public Filter getFilter() {
            return exampleFilter;
        }
        Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ExampleItem> filteredList0 = new ArrayList<>();
            ArrayList<String> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mExampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase();
                for (String pokemons : mExampleListFull) {
                    if (pokemons.toLowerCase().contains(filterPattern)) {
                        filteredList.add(pokemons);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mExampleList.clear();
            mExampleList.addAll((Collection<? extends String>) results.values);
            notifyDataSetChanged();
        }
    };

        public interface ItemClickListener {
            public void onItemClick(String mExampleList);
        }
}
