package com.example.sakha_programm;

public class Sakha_word {
    Sakha_verb v = new Sakha_verb();
    public int Garmony(String w) {
        return v.Garmony(w);
    }
    public boolean This_el(String[] arr, String check_value) {
        return v.This_el(arr, check_value);
    }
    public String[] dict1 = {"", "и", "ы", "у", "у", "ү", "ү"};
    public String[] dict2 = {"", "э", "а", "а", "о", "э", "ө"};
    public String[] glass_letters = {"а", "ы", "о", "у", "э", "и", "ө", "ү"};

    public String upod_of_sogl1(String w, String w2) {
        return v.upod_sogl_of_verb_and_verb_time(w, w2);
    }
    public String upod_of_sogl2(String w, String w2) {
        return v.upod_sogl_of_verb_time_and_lic(w, w2);
    }
    public String Noune_human(String w) {
           String c1 = dict1[Garmony(w)];
           return upod_of_sogl1(w, w+"һ"+c1+"т");
    }
    public String Noune_love_human(String w) {
        String c1 = dict1[Garmony(w)];
        String c2 = dict2[Garmony(w)];
        int f = 0;
        int len = w.length();
        for (int i = 1; i < len+1; i++) {
            if (This_el(dict1, Character.toString(w.charAt(len-i)))) {
                f = 1;
                break; }
            if (This_el(dict2, Character.toString(w.charAt(len-i)))) {
                f = 2;
                break; }
        }
        if (f==1) {
            if (This_el(glass_letters, Character.toString(w.charAt(len-1)))) {
                return w+"мс"+c1+"к";}
            else return upod_of_sogl1(w, w+c1+"мс"+c1+"к");
        }
        else if (f==2) {
            if (This_el(glass_letters, Character.toString(w.charAt(len-1)))) {
                return w+"мс"+c2+"х";}
            else return upod_of_sogl1(
                    w, w+c1+"мс"+dict2[v.Garmony_of_sl(c1, 1)]+"х");
        }
        else return "Ошибка";
    }
    public String Noune_verb(String w) {
        String c2 = dict2[Garmony(w)];
        if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
            return w+"л"+c2+c2;
        else return upod_of_sogl1(w, w+"т"+c2+c2);
    }
    public String word_finally(int w1, String w) {
        switch (w1) {
            case 0:
                return Noune_human(w);
            case 1:
                return Noune_love_human(w);
            case 2:
                return Noune_verb(w);
            case 3:
                return Noune_verb_fill(w);
            case 4:
                return Verb_noune(w);
            case 5:
                return Verb_human(w);
        }
        return "Ошибка";
    }
    public String Verb_noune(String w) {
        String c2 = dict1[Garmony(w)];
        if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
            return Noune_human(w).substring(0, Noune_human(w).length()-1) + "н";
        else return upod_of_sogl1(w, w+c2+c2);
    }
    public String Noune_verb_fill(String w) {
        String c2 = dict1[Garmony(w)];
        String c1 = dict2[Garmony(w)];
        String c3 = dict2[v.Garmony_of_sl(c2, 1)];
        if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
            return w+"рҕ"+c1+c1;
        else return upod_of_sogl1(w, w+c2+"рг"+c3+c3);
    }
    public String Verb_human(String w) {
        String c2 = dict1[Garmony(w)];
        String c1 = dict2[Garmony(w)];
        String c3 = dict1[v.Garmony_of_sl(c1, 1)];
        if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
            return w+"чч"+c2;
        else return upod_of_sogl1(w, w+c1+c1+"чч"+c3);
    }
}
