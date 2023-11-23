package com.example.sakha_programm;

public class Affirmative_verb extends Sakha_verb{
    public String Aff_verb(String verb, int a, int b) {
        String g1 = dict1[Garmony(verb)];
        if (This_el(glass_letters, Character.toString(verb.charAt(verb.length()-1))))
            verb += "һ" + g1;
        else verb = upod_sogl_of_verb_and_verb_time(verb, verb + g1 + g1 + "һ" + g1);
        return skaz(verb, a, b);
    }
    public String Aff_verb_minus(String verb, int a, int b, int c) {
        String g1 = dict1[Garmony(verb)];
        if (c==0) {
        if (This_el(glass_letters, Character.toString(verb.charAt(verb.length()-1))))
            verb += "м"+ g1 + g1 + "һ" + g1;
        else verb = upod_sogl_of_verb_and_verb_time(verb, verb+g1+"м"+ g1 + g1 + "һ" + g1);
        return skaz(verb, a, b); }
        else {
            return future_time(verb, 1, 3).substring(0, future_time(verb, 1, 3).length()-2) + skaz(" суох", a, b);
        }
    }
}
