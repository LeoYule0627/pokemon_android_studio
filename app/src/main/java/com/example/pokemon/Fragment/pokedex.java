package com.example.pokemon.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.pokemon.Chart;
import com.example.pokemon.LoadImg;
import com.example.pokemon.R;
import com.example.pokemon.data;

public class pokedex extends Fragment{
    @Nullable
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    TextView normal,fire,water,grass,eletric,fighting,rock,ground,fairy,psychic,dark,ghost,poison,bug,flying,dragon,steel,ice;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }
    public static pokedex newInstance(String string){
        pokedex f = new pokedex();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, string);
        f.setArguments(args);
        return f;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pokedex, null);
        TextView name = view.findViewById(R.id.name);
        TextView CT_text = view.findViewById(R.id.CT);
        TextView ST_text = view.findViewById(R.id.ST);
        TextView janame_text = view.findViewById(R.id.JA);
        TextView enname_text = view.findViewById(R.id.EN);
        TextView weight_text = view.findViewById(R.id.weight);
        TextView height_text = view.findViewById(R.id.height);
        ImageView type1_view = view.findViewById(R.id.typeI);
        ImageView type2_view = view.findViewById(R.id.typeII);
        ImageView pokemon_view = view.findViewById(R.id.pokemonview);
        ImageView pokemon_view2 = view.findViewById(R.id.pokemonview2);
        normal = view.findViewById(R.id.infor_normal);
        fire = view.findViewById(R.id.infor_fire);
        water = view.findViewById(R.id.infor_water);
        grass = view.findViewById(R.id.infor_grass);
        eletric = view.findViewById(R.id.infor_eletric);
        fighting = view.findViewById(R.id.infor_fighting);
        rock = view.findViewById(R.id.infor_rock);
        ground = view.findViewById(R.id.infor_ground);
        fairy = view.findViewById(R.id.infor_fairy);
        psychic = view.findViewById(R.id.infor_psychic);
        dark = view.findViewById(R.id.infor_dark);
        ghost = view.findViewById(R.id.infor_ghost);
        poison = view.findViewById(R.id.infor_poison);
        bug = view.findViewById(R.id.infor_bug);
        flying = view.findViewById(R.id.infor_flying);
        dragon = view.findViewById(R.id.infor_dragon);
        steel = view.findViewById(R.id.infor_steel);
        ice = view.findViewById(R.id.infor_ice);
        String[][] infor = data.pokemonAll();
        String type2;
        String type1;


        for (int i = 0; i < infor.length; i++) {
            if (infor[i][4].equals(mParam1)) {
                String CT = infor[i][0];
                String ST = infor[i][1];
                String enname = infor[i][2];
                String janame = infor[i][3];
                type1 = infor[i][5];
                type2 = infor[i][6];
                String he = infor[i][7];
                String we = infor[i][8];
                String url= infor[i][9];
                String url2=infor[i][10];
                LoadImg loadImg = (LoadImg) new LoadImg(pokemon_view).execute(url);
                LoadImg loadImg2 = (LoadImg) new LoadImg(pokemon_view2).execute(url2);

                CT_text.setText("全國圖鑑 #" + CT);
                ST_text.setText("洗翠圖鑑 #" + ST);
                janame_text.setText(janame);
                enname_text.setText(enname);
                weight_text.setText("體重" + we + "kg");
                height_text.setText("身高" + he + "cm");
                type1_view.setImageResource(Chart.seticon(type1));
                type2_view.setImageResource(Chart.seticon(type2));

                double[] forAttack = Chart.typeCalculate(type1,type2);
                setTypeValue(forAttack);
                }
            }
        name.setText(mParam1);
        return view;
    }

    public void setTypeValue(double[] list) {
        normal.setText("x"+list[0]);
        fire.setText("x"+list[1]);
        water.setText("x"+list[2]);
        eletric.setText("x"+list[3]);
        grass.setText("x"+list[4]);
        ice.setText("x"+list[5]);
        fighting.setText("x"+list[6]);
        poison.setText("x"+list[7]);
        ground.setText("x"+list[8]);
        flying.setText("x"+list[9]);
        psychic.setText("x"+list[10]);
        bug.setText("x"+list[11]);
        rock.setText("x"+list[12]);
        ghost.setText("x"+list[13]);
        dragon.setText("x"+list[14]);
        dark.setText("x"+list[15]);
        steel.setText("x"+list[16]);
        fairy.setText("x"+list[17]);
    }

}
