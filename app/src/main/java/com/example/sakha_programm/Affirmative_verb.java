package com.example.sakha_programm;

public class Affirmative_verb extends Sakha_verb{
    public String Aff_verb(String verb, int a, int b) {
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return Aff_verb(verb1, a, b)+"-"+Aff_verb(verb2, a, b);
        }
        String g1 = dict1[Garmony(verb)];
        if (This_el(glass_letters, Character.toString(verb.charAt(verb.length()-1))))
            verb += "һ" + g1;
        else {
            verb = check_for_irregular_verbs(verb);
            verb = upod_sogl_of_verb_and_verb_time(verb, verb + g1 + g1 + "һ" + g1); }
        return skaz(verb, a, b);
    }
    public String Aff_verb_minus(String verb, int a, int b, int c) {
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return Aff_verb_minus(verb1, a, b, c)+"-"+Aff_verb_minus(verb2, a, b, c);
        }
        String g1 = dict1[Garmony(verb)];
        if (c==0) {
        if (This_el(glass_letters, Character.toString(verb.charAt(verb.length()-1))))
            verb += "м"+ g1 + g1 + "һ" + g1;
        else {
            verb = check_for_irregular_verbs(verb);
            verb = upod_sogl_of_verb_and_verb_time(verb, verb+g1+"м"+ g1 + g1 + "һ" + g1);}
        return skaz(verb, a, b); }
        else {
            return future_time(verb, 1, 3).substring(0, future_time(verb, 1, 3).length()-2) + skaz(" суох", a, b);
        }
    }
}
