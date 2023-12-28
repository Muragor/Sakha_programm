package com.example.sakha_programm;

public class Preferably_a_subjunctive_verb extends Sakha_verb {
    public String Pr_a_sub_verb(String verb, int a, int b){
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return Pr_a_sub_verb(verb1, a, b).substring(0,Pr_a_sub_verb(verb1, a, b).length()-4)+"-"+Pr_a_sub_verb(verb2, a, b);
        }
        if (a==1) {
            verb = check_for_irregular_verbs(verb);
            if (b==3) {
                if (This_el(glass_letters, Character.toString(verb.charAt(verb.length()-1))))
                    return future_time(verb, a, b).substring(0, verb.length()) + " этэ";
                return future_time(verb, a, b).substring(0, verb.length()+2) + " этэ"; }
            else {
                if (This_el(glass_letters, Character.toString(verb.charAt(verb.length()-1))))
                    return face(future_time(verb, a, b).substring(0, verb.length()), a, b) + " этэ";
                return face(future_time(verb, a, b).substring(0, verb.length()+2), a, b) + " этэ";
            }
        }
        else {
        return future_time(verb, a, b) + " этэ"; }
    }
    public String Pr_a_sub_verb_minus(String verb, int a, int b){
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            if (a==1 && b == 3) {
                return Pr_a_sub_verb_minus(verb1, a, b).substring(0, Pr_a_sub_verb_minus(verb1, a, b).length()-9)+"-"+Pr_a_sub_verb_minus(verb2, a, b);
            }
            if (a==2) {
                return Pr_a_sub_verb_minus(verb1, a, b).substring(0, Pr_a_sub_verb_minus(verb1, a, b).length()-12)+"-"+Pr_a_sub_verb_minus(verb2, a, b);
            }
            return Pr_a_sub_verb_minus(verb1, a, b).substring(0, Pr_a_sub_verb_minus(verb1, a, b).length()-10)+"-"+Pr_a_sub_verb_minus(verb2, a, b);
        }
        verb = future_time(verb, 1, 3).substring(0, future_time(verb, 1, 3).length()-2) + " суох ";
        if (a==1) {
            switch (b) {
                case 1:
                    return verb + "этим";
                case 2:
                    return verb + "этиҥ";
                default:
                    return verb + "этэ";
            }
        }
        else {
            switch (b) {
                case 1:
                    return verb + "этибит";
                case 2:
                    return verb + "этигит";
                default:
                    return verb + "этилэр";
            }
        }
    }
}
