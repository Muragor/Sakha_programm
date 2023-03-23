package com.example.sakha_programm;

public class Sakha_noun {
    public Sakha_verb sakha_verb = new Sakha_verb();

    public boolean This_el(String[] arr, String check_value) {
        return sakha_verb.This_el(arr, check_value);
    }
    public String[] dict1 = {"", "и", "ы", "у", "у", "ү", "ү"};
    public String[] dict2 = {"", "э", "а", "а", "о", "э", "ө"};

    public String[] glass_letters = {"а", "ы", "о", "у", "э", "и", "ө", "ү"};

    public int Garmony(String w) {
        return sakha_verb.Garmony(w);
    }
    public String upod_of_sogl1(String w, String w2) {
        return sakha_verb.upod_sogl_of_verb_and_verb_time(w, w2);
    }
    public String upod_of_sogl2(String w, String w2) {
        return sakha_verb.upod_sogl_of_verb_time_and_lic(w, w2);
    }
    public String Imen_p(String w, int face, int count) {
        String c1 = dict1[Garmony(w)];
        if (face < 4 && face!=0) return upod_of_sogl1(w, sakha_verb.face(w, 1, face));
        else  {
            switch (face) {
                case 4:
                    return upod_of_sogl1(w, w+"б"+ c1 + "т");
                case 5:
                    return upod_of_sogl2(w, w+"ҕ"+ c1 + "т");
                case 6:
                    if (count == 1) return upod_of_sogl1(w, sakha_verb.face(w, 1, 3));
                    else return upod_of_sogl1(plural(w, count), sakha_verb.face(plural(w, count), 1, 3));
                default: return w;
            }
        }


    }
    public String Dat_p(String w, int face, int count) {
        String c1 = dict2[Garmony(w)];
        String c2 = dict1[Garmony(w)];
        String c3 = dict2[sakha_verb.Garmony_of_sl(c2, 1)];
        String c4 = dict1[sakha_verb.Garmony_of_sl(c3, 1)];
        switch (face){
            case 1:
                return upod_of_sogl1(w, w+"б"+c1+"р");
            case 2:
                return upod_of_sogl2(w, w+"ҕ"+c1+"р");
            case 3:
                if (w.charAt(w.length()-1) == 'к' || w.charAt(w.length()-1) == 'х' || w.charAt(w.length()-1) == 'м')
                    return upod_of_sogl1(w, w+c1+"р");
                else if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"т"+c2+"г"+c1+"р";
                return upod_of_sogl1(w, w+c2+"г"+c3+"р");
            case 4:
                return upod_of_sogl1(w, w+"б"+c2+"т"+c2+"г"+c3+"р");
            case 5:
                return upod_of_sogl2(w, w+"ҕ"+c2+"т"+c2+"г"+c3+"р");
            case 6:
                if (count == 1) return w+c2+"г"+c3+"р";
                else return plural(w, 1)+c4+"г"+c3+"р";
            default: return upod_of_sogl2(w, w+"ҕ"+c1);
        } }

    public String Vin_p(String w, int face, int count) {
        String c1 = dict1[Garmony(w)];
        switch (face){
            case 1:
                return upod_of_sogl1(w, w+"б"+c1+"н");
            case 2:
                return upod_of_sogl2(w, w+"ҕ"+c1+"н");
            case 3:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"т"+c1+"н";
                return upod_of_sogl1(w, w+c1+"н");
            case 4:
                return upod_of_sogl1(w, w+"б"+c1+"т"+c1+"н");
            case 5:
                return upod_of_sogl2(w, w+"ҕ"+c1+"т"+c1+"н");
            case 6:
                if (count == 1) return w+c1+"н";
                else return plural(w, 1)+dict1[Garmony(plural(w, 1))]+"н";
            default:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"н"+c1;
                else return upod_of_sogl1 (w, w+c1);
        }

    }
    public String Ish_p(String w, int face, int count) {
        String c1 = dict1[Garmony(w)];
        String c2 = dict2[Garmony(w)];
        String c3 = dict2[sakha_verb.Garmony_of_sl(c1, 1)];
        String c4 = dict1[sakha_verb.Garmony_of_sl(c3, 1)];
        switch (face){
            case 1:
                return upod_of_sogl1(w, w+"б"+c1+"тт"+c3+"н");
            case 2:
                return upod_of_sogl2(w, w+"ҕ"+c1+"тт"+c3+"н");
            case 3:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"т"+c1+"тт"+c3+"н";
                return upod_of_sogl1(w, w+c1+"тт"+c3+"н");
            case 4:
                return upod_of_sogl1(w, w+"б"+ c1 + "т" +c1+"тт"+c3+"н");
            case 5:
                return upod_of_sogl2(w, w+"ҕ"+ c1 + "т" +c1+"тт"+c3+"н");
            case 6:
                if (count == 1) return w+c1+"тт"+c3+"н";
                else return plural(w, 1)+c4+"тт"+c3+"н";
            default:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"тт"+c2+"н";
                else return w+"т"+c2+"н";
        }

    }
    public String Chast_p(String w, int face, int count) {
        if (face != 0)
                return Vin_p(w, face, count)+dict2[Garmony(Vin_p(w, face, count))];
        else
                return sakha_verb.verb_recent_time(w, 1, 3);
        }

    public String Tvor_p(String w, int face, int count) {
        String c1 = dict1[Garmony(w)];
        String c2 = dict2[Garmony(w)];
        String c3 = dict2[sakha_verb.Garmony_of_sl(c1, 1)];
        String c4 = dict1[sakha_verb.Garmony_of_sl(c3, 1)];
        switch (face){
            case 1:
                return upod_of_sogl1(w, w+"б"+c1+"н"+c3+"н");
            case 2:
                return upod_of_sogl2(w, w+"ҕ"+c1+"н"+c3+"н");
            case 3:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"т"+c1+"н"+c3+"н";
                return upod_of_sogl1(w, w+c1+"н"+c3+"н");
            case 4:
                return upod_of_sogl1(w, w+"б"+c1 +"т"+c1+"н"+c3+"н");
            case 5:
                return upod_of_sogl2(w, w+"ҕ"+c1 +"т"+c1+"н"+c3+"н");
            case 6:
                if (count == 1) return w+c1+"н"+c3+"н";
                else return plural(w, 1)+c4+"н"+c3+"н";
            default:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"н"+c2+"н";
                else return upod_of_sogl1(w, w+c1+"н"+c3+"н");
        }

    }
    public String Sovm_p(String w, int face, int count) {
        String c1 = dict1[Garmony(w)];
        String c2 = dict1[Garmony(plural(w, 1))];
        switch (face){
            case 1:
                return upod_of_sogl1(w, w+"б"+c1+"н"+c1+c1+"н");
            case 2:
                return upod_of_sogl2(w, w+"ҕ"+c1+"н"+c1+c1+"н");
            case 3:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"т"+c1+"н"+c1+c1+"н";
                return upod_of_sogl1(w, w+c1+"н"+c1+c1+"н");
            case 4:
                return upod_of_sogl1(w, w+"б"+c1+"т"+c1+"н"+c1+c1+"н");
            case 5:
                return upod_of_sogl2(w, w+"ҕ"+c1+"т"+c1+"н"+c1+c1+"н");
            case 6:
                if (count == 1) return w+c1+"н"+c1+c1+"н";
                else return plural(w, 1)+c2+"н"+c2+c2+"н";
            default:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"л"+c1+c1+"н";
                else return upod_of_sogl1(w, w+"т"+c1+c1+"н");
        }


    }
    public String Srav_p(String w, int face, int count) {
        String c1 = dict2[Garmony(w)];
        String c2 = dict1[Garmony(w)];
        String c3 = dict2[sakha_verb.Garmony_of_sl(c2, 1)];
        String c4 = dict1[sakha_verb.Garmony_of_sl(c3, 1)];
        switch (face){
            case 1:
                return upod_of_sogl1(w, w+"б"+c2+"н"+c3+c3+"ҕ"+c3+"р");
            case 2:
                return upod_of_sogl2(w, w+"ҕ"+c2+"н"+c3+c3+"ҕ"+c3+"р");
            case 3:
                if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                    return w+"т"+c2+"н"+c3+c3+"ҕ"+c3+"р";
                return upod_of_sogl1(w, w+c2+"н"+c3+c3+"ҕ"+c3+"р");
            case 4:
                return upod_of_sogl1(w, w+"б"+c2+"т"+c2+"н"+c3+c3+"ҕ"+c3+"р");
            case 5:
                return upod_of_sogl2(w, w+"ҕ"+c2+"т"+c2+"н"+c3+c3+"ҕ"+c3+"р");
            case 6:
                if (count == 1) return w+c2+"н"+c3+c3+"ҕ"+c3+"р";
                else return plural(w, 1)+c4+"н"+c3+c3+"ҕ"+c3+"р";
            default:
                return upod_of_sogl1(w, w+"т"+c1+c1+"ҕ"+c1+"р");
        }
    }
    public String plural(String w, int c) {
        String c1 = dict2[Garmony(w)];
        if (c==1){
        if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
            return w+"л"+c1+"р";
        else return upod_of_sogl1(w, w+"т"+c1+"р"); }
        else return w;
    }

}
