package com.example.pokemon.Fragment;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.pokemon.Chart;
import com.example.pokemon.R;

public class type extends Fragment implements View.OnClickListener {
    @Nullable
    Button bt_no,bt_fight,bt_fly,bt_fire,bt_water,bt_ele,bt_ground,bt_ghost,bt_fairy,bt_dragon,bt_grass,bt_rock,bt_dark,bt_bug,bt_psy,bt_ice,bt_steel,bt_poison;
    TextView type1,type2;
    String firstType;
    int numberOfType=0;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.type, null);
            type1 = (TextView) view.findViewById(R.id.text1);
            type2 = (TextView) view.findViewById(R.id.text2);
            bt_no = (Button) view.findViewById(R.id.normal);
            bt_no.setOnClickListener(this);
            bt_fight = (Button) view.findViewById(R.id.fighting);
            bt_fight.setOnClickListener(this);
            bt_fly = (Button) view.findViewById(R.id.flying);
            bt_fly.setOnClickListener(this);
            bt_bug = (Button) view.findViewById(R.id.bug);
            bt_bug.setOnClickListener(this);
            bt_dark = (Button) view.findViewById(R.id.dark);
            bt_dark.setOnClickListener(this);
            bt_dragon = (Button) view.findViewById(R.id.dragon);
            bt_dragon.setOnClickListener(this);
            bt_ele = (Button) view.findViewById(R.id.electric);
            bt_ele.setOnClickListener(this);
            bt_fairy = (Button) view.findViewById(R.id.fairy);
            bt_fairy.setOnClickListener(this);
            bt_fire = (Button) view.findViewById(R.id.fire);
            bt_fire.setOnClickListener(this);
            bt_ghost = (Button) view.findViewById(R.id.ghost);
            bt_ghost.setOnClickListener(this);
            bt_grass = (Button) view.findViewById(R.id.grass);
            bt_grass.setOnClickListener(this);
            bt_ground = (Button) view.findViewById(R.id.ground);
            bt_ground.setOnClickListener(this);
            bt_water = (Button) view.findViewById(R.id.water);
            bt_water.setOnClickListener(this);
            bt_ice = (Button) view.findViewById(R.id.ice);
            bt_ice.setOnClickListener(this);
            bt_steel = (Button) view.findViewById(R.id.steel);
            bt_steel.setOnClickListener(this);
            bt_poison = (Button) view.findViewById(R.id.poison);
            bt_poison.setOnClickListener(this);
            bt_rock = (Button) view.findViewById(R.id.rock);
            bt_rock.setOnClickListener(this);
            bt_psy = (Button) view.findViewById(R.id.psychic);
            bt_psy.setOnClickListener(this);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.normal:
                setTextForTitle("一般");
                Log.v("msg", "Normal");
                break;
            case R.id.fire:
                setTextForTitle("火");
                Log.v("msg", "Fire");
                break;
            case R.id.water:
                setTextForTitle("水");
                Log.v("msg", "Water");
                break;
            case R.id.electric:
                setTextForTitle("電");
                Log.v("msg", "Electric");
                break;
            case R.id.grass:
                setTextForTitle("草");
                Log.v("msg", "Grass");
                break;
            case R.id.ice:
                setTextForTitle("冰");
                Log.v("msg", "Ice");
                break;
            case R.id.fighting:
                setTextForTitle("格鬥");
                Log.v("msg", "Fighting");
                break;
            case R.id.poison:
                setTextForTitle("毒");
                Log.v("msg", "Poison");
                break;
            case R.id.ground:
                setTextForTitle("地面");
                Log.v("msg", "Ground");
                break;
            case R.id.flying:
                setTextForTitle("飛行");
                Log.v("msg", "Flying");
                break;
            case R.id.psychic:
                setTextForTitle("超能");
                Log.v("msg", "Psychic");
                break;
            case R.id.bug:
                setTextForTitle("蟲");
                Log.v("msg", "Bug");
                break;
            case R.id.rock:
                setTextForTitle("岩石");
                Log.v("msg", "Rock");
                break;
            case R.id.ghost:
                setTextForTitle("幽靈");
                Log.v("msg", "Ghost");
                break;
            case R.id.dragon:
                setTextForTitle("龍");
                Log.v("msg", "Dragon");
                break;
            case R.id.dark:
                setTextForTitle("惡");
                Log.v("msg", "Dark");
                break;
            case R.id.steel:
                setTextForTitle("鋼");
                Log.v("msg", "Steel");
                break;
            case R.id.fairy:
                setTextForTitle("妖精");
                Log.v("msg", "Fairy");
                break;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setTextForTitle(String type){
        if(numberOfType==0){
            type1.setText(type);
            double[] forAttack = Chart.whichType(type);
            firstType = type;
            setTypeValue(forAttack);
            numberOfType++;
        }else if(firstType.equals(type) && numberOfType==1){
            Toast.makeText(getActivity(), "請選另一種屬性", Toast.LENGTH_LONG).show();
        } else if(numberOfType==1){
            type2.setText(type);
            double[] forAttack = Chart.typeCalculate(firstType,type);
            setTypeValue(forAttack);
            numberOfType++;
        }else{
            type1.setText(type);
            type2.setText("");
            double[] forAttack = Chart.whichType(type);
            firstType = type;
            setTypeValue(forAttack);
            numberOfType--;
        }
    }
    public void setTypeValue(double[] list){
        bt_no.setText("一般\n"+list[0]);
        bt_fire.setText("火\n"+list[1]);
        bt_water.setText("水\n"+list[2]);
        bt_ele.setText("電\n"+list[3]);
        bt_grass.setText("草\n"+list[4]);
        bt_ice.setText("冰\n"+list[5]);
        bt_fight.setText("格鬥\n"+list[6]);
        bt_poison.setText("毒\n"+list[7]);
        bt_ground.setText("地面\n"+list[8]);
        bt_fly.setText("飛行\n"+list[9]);
        bt_psy.setText("超能\n"+list[10]);
        bt_bug.setText("蟲\n"+list[11]);
        bt_rock.setText("岩石\n"+list[12]);
        bt_ghost.setText("幽靈\n"+list[13]);
        bt_dragon.setText("龍\n"+list[14]);
        bt_dark.setText("惡\n"+list[15]);
        bt_steel.setText("鋼\n"+list[16]);
        bt_fairy.setText("妖精\n"+list[17]);
    }
}

