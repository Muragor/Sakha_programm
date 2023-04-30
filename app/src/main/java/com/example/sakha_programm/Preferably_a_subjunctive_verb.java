package com.example.sakha_programm;

public class Preferably_a_subjunctive_verb extends Sakha_verb {
    public String Pr_a_sub_verb(String verb, int a, int b){
        if (a==1) {
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
