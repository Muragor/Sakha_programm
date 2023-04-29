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
        String g1 = dict2[sakha_verb.Garmony(verb)];
        String g2 = dict1[sakha_verb.Garmony_of_sl(g1, 1)];
        verb = sakha_verb.future_time(verb, 2, 1).substring(0,sakha_verb.future_time(verb, 2, 1).length()-3);
        verb = verb + "т" + g1 + g1 + "х";
        if (a==1) {
            switch (b) {
                case 1:
                    verb = verb + "п" + g2 + "н";
                    break;
                case 2:
                    verb = verb + "х" + g2 + "н";
                    break;
                default:
                    return verb;
            } }
        else {
            switch (b) {
                case 1:
                    verb = verb + "п" + g2 + "т";
                    break;
                case 2:
                    verb = verb + "х" + g2 + "т";
                    break;
                default:
                    verb = verb + "т" + g1 + "р";
            }
        }
        return verb;
    }
    public String must_verb_minus(String verb, int a, int b) {
        String g1 = dict2[sakha_verb.Garmony(verb)];
        String g2 = dict1[sakha_verb.Garmony_of_sl(g1, 1)];
        verb = sakha_verb.future_time(verb, 1, 3).substring(0,sakha_verb.future_time(verb, 1, 3).length()-2 );
        if (a==1) {
            switch (b) {
                case 1:
                    verb = verb + " " + "суохтаахпын";
                    break;
                case 2:
                    verb = verb + " " + "суохтааххын";
                    break;
                default:
                    return verb + " " + "суохтаах";
            } }
        else {
            switch (b) {
                case 1:
                    verb = verb + " " + "суохтаахпыт";
                    break;
                case 2:
                    verb = verb + " " + "суохтааххыт";
                    break;
                default:
                    return verb + " " + "суохтаахтар";
            }
        }
        return verb;
    }
}
