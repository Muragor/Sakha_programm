package com.example.sakha_programm;

public class Must_verb_1 {
    protected Sakha_verb sakha_verb = new Sakha_verb();
    protected boolean This_el(String[] arr, String check_value) {
        return sakha_verb.This_el(arr, check_value);
    }
    protected String[] dict1 = {"", "и", "ы", "у", "у", "ү", "ү"};
    protected String[] dict2 = {"", "э", "а", "а", "о", "э", "ө"};

    protected String[] glass_letters = {"а", "ы", "о", "у", "э", "и", "ө", "ү"};

    protected int Garmony(String w) {
        return sakha_verb.Garmony(w);
    }
    protected String upod_of_sogl1(String w, String w2) {
        return sakha_verb.upod_sogl_of_verb_and_verb_time(w, w2);
    }
    protected String upod_of_sogl2(String w, String w2) {
        return sakha_verb.upod_sogl_of_verb_time_and_lic(w, w2);
    }
    public String must_verb(String verb, int a, int b) {
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return must_verb(verb1, a, b)+"-"+must_verb(verb2, a, b);
        }
        String g1 = dict2[sakha_verb.Garmony(verb)];
        String g2 = dict1[sakha_verb.Garmony_of_sl(g1, 1)];
        verb = sakha_verb.future_time(verb, 2, 1).substring(0,sakha_verb.future_time(verb, 2, 1).length()-3);
        verb = verb + "т" + g1 + g1 + "х";
        return sakha_verb.skaz(verb, a, b);
    }
    public String must_verb_minus(String verb, int a, int b) {
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return must_verb_minus(verb1, a, b)+"-"+must_verb_minus(verb2, a, b);
        }
        String g1 = dict2[sakha_verb.Garmony(verb)];
        String g2 = dict1[sakha_verb.Garmony_of_sl(g1, 1)];
        verb = sakha_verb.future_time(verb, 1, 3).substring(0,sakha_verb.future_time(verb, 1, 3).length()-2 );
        return sakha_verb.skaz(verb+" суохтаах", a, b);
    }
}
