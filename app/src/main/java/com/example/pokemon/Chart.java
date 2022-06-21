package com.example.pokemon;

import android.app.Application;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;

/*
 * 一般	Normal
 * 火	Fire
 * 水	Water
 * 電	Electric
 * 草	Grass
 * 冰	Ice
 * 格鬥	Fighting
 * 毒	Poison
 * 地面	Ground
 * 飛行	Flying
 * 超能力Psychic
 * 蟲	Bug
 * 岩石	Rock
 * 幽靈	Ghost
 * 龍	Dragon
 * 惡	Dark
 * 鋼	Steel
 * 妖精	Fairy
 */
public class Chart extends Application {
    public static double[] whichType(String type) {
        // TODO Auto-generated method stub
        double[] result = null;
        //效果絕佳 = 2, 效果普通=1 , 效果不佳 = .5, 沒有效果 = 0
        // 般,火,水, 電,草,冰, 鬥,毒,地, 飛,超, 蟲,岩,幽,龍, 惡,鋼,妖
        // No,Fr,Wa,El,Gr,Ic,Ft,Po,Gd,Fy,Ps,Bu,Ro,Gh,Dr,Dk,St,Fa
        double[] normal 	= { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1};
        double[] fire		= { 1,.5, 2, 1,.5,.5, 1, 1, 2, 1, 1,.5, 2, 1, 1, 1,.5,.5};
        double[] water		= { 1,.5,.5, 2, 2,.5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,.5, 1};
        double[] electric	= { 1, 1, 1,.5, 1, 1, 1, 1, 2,.5, 1, 1, 1, 1, 1, 1,.5, 1};
        double[] grass 		= { 1, 2,.5,.5,.5, 2, 1, 2,.5, 2, 1, 2, 1, 1, 1, 1, 1, 1};
        double[] ice	 	= { 1, 2, 1, 1, 1,.5, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1};
        double[] fighting	= { 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2,.5,.5, 1, 1,.5, 1, 2};
        double[] poison 	= { 1, 1, 1, 1,.5, 1,.5,.5, 2, 1, 2,.5, 1, 1, 1, 1, 1,.5};
        double[] ground 	= { 1, 1, 2, 0, 2, 2, 1,.5, 1, 1, 1, 1,.5, 1, 1, 1, 1, 1};
        double[] flying 	= { 1, 1, 1, 2,.5, 2,.5, 1, 0, 1, 1,.5, 2, 1, 1, 1, 1, 1};
        double[] psychic 	= { 1, 1, 1, 1, 1, 1,.5, 1, 1, 1,.5, 2, 1, 2, 1, 2, 1, 1};
        double[] bug	 	= { 1, 2, 1, 1,.5, 1,.5, 1,.5, 2, 1, 1, 2, 1, 1, 1, 1, 1};
        double[] rock		= {.5,.5, 2, 1, 2, 1, 2,.5, 2,.5, 1, 1, 1, 1, 1, 1, 2, 1};
        double[] ghost 		= { 0, 1, 1, 1, 1, 1, 0,.5, 1, 1, 1,.5, 1, 2, 1, 2, 1, 1};
        double[] dragon 	= { 1,.5,.5,.5,.5, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2};
        double[] dark		= { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 2, 1,.5, 1,.5, 1, 2};
        double[] steel 		= {.5, 2, 1, 1,.5,.5, 2, 0, 2,.5,.5,.5,.5, 1,.5, 1,.5,.5};
        double[] fairy 		= { 1, 1, 1, 1, 1, 1,.5, 2, 1, 1, 1,.5, 1, 1, 0,.5, 2, 1};
        double[] none       = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        switch (type) {
            case "一般":
            case "normal":
                result = normal;
                break;
            case "火":
            case "fire":
                result = fire;
                break;
            case "水":
            case "water":
                result = water;
                break;
            case "電":
            case "electric":
                result = electric;
                break;
            case "草":
            case "grass":
                result = grass;
                break;
            case "冰":
            case "ice":
                result = ice;
                break;
            case "格鬥":
            case "fighting":
                result = fighting;
                break;
            case "毒":
            case "poison":
                result = poison;
                break;
            case "地面":
            case "ground":
                result = ground;
                break;
            case "飛行":
            case "flying":
                result = flying;
                break;
            case "超能":
            case "psychic":
                result = psychic;
                break;
            case "蟲":
            case "bug":
                result = bug;
                break;
            case "岩石":
            case "rock":
                result = rock;
                break;
            case "幽靈":
            case "ghost":
                result = ghost;
                break;
            case "龍":
            case "dragon":
                result = dragon;
                break;
            case "惡":
            case "dark":
                result = dark;
                break;
            case "鋼":
            case "steel":
                result = steel;
                break;
            case "妖精":
            case "fairy":
                result = fairy;
                break;
            case "None":
                result = none;
                break;
        }
        return result;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static double[] typeCalculate(String typeI, String typeII) {
        List<Double> resultList = new ArrayList<Double>();
        double[] dTypeI = whichType(typeI);
        double[] dTypeII = whichType(typeII);
        for(int i = 0; i<dTypeI.length; i++) {
            double n = dTypeI[i] * dTypeII[i];
            resultList.add(n);
        }
        double[] resultArray = resultList.stream().mapToDouble(Double::doubleValue).toArray();
        return resultArray;
    }

    public static int seticon(String type){
        switch (type){
            case "normal":
                return R.drawable.normal;
            case "fighting":
                return R.drawable.fighting;
            case "flying":
                return R.drawable.flying;
            case "water":
                return R.drawable.water;
            case "fire":
                return R.drawable.fire;
            case "grass":
                return R.drawable.grass;
            case "bug":
                return R.drawable.bug;
            case "poison":
                return R.drawable.poison;
            case "electric":
                return R.drawable.electric;
            case "rock":
                return R.drawable.rock;
            case "ground":
                return R.drawable.ground;
            case "steel":
                return R.drawable.steel;
            case "dark":
                return R.drawable.dark;
            case "ghost":
                return R.drawable.ghost;
            case "psychic":
                return R.drawable.psychic;
            case "dragon":
                return R.drawable.dragon;
            case "ice":
                return R.drawable.ice;
            case "fairy":
                return R.drawable.fairy;
        }
        return 0;
    }


}
