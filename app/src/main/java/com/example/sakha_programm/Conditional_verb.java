package com.example.sakha_programm;

public class Conditional_verb extends Sakha_verb{
    public String not_in_time(String verb, int a, int b, int c){
        String g1 = dict2[Garmony(verb)];
        String g2 = dict1[Garmony_of_sl(g1, 1)];
        if (c == 0) {
        verb = upod_sogl_of_verb_and_verb_time(verb,verb+"т"+g1+"р"); }
        else { verb = upod_sogl_of_verb_and_verb_time(verb,verb+"б"+g1+"т"+g1+"р"); }
        if (a==1) {
            switch (b) {
                case 1:
                    return verb+"б"+g2+"н";
                case 2:
                    return verb+"г"+g2+"н";
                default:
                    return verb;
            }
        }
        else {
            switch (b) {
                case 1:
                    return verb+"б"+g2+"т";
                case 2:
                    return verb+"г"+g2+"т";
                default:
                    return verb.substring(0, verb.length()-1)+"лл" + g1 + "р";
            }

    } }
    public String real_time_conditional(String verb, int a, int b, int c){
        String g1 = dict2[Garmony(verb)];
        if (c==0) {
            if (b==3 && a == 2)
                return real_time(verb, 1, 3).substring(0,real_time(verb, 1, 3).length()-1 ) + "лл" + g1 + "р" + g1 + " буоллар";
            return face(real_time(verb, 1, 3), a , b) + " буоллар"; }
        else return upod_sogl_of_verb_time_and_lic(minus_real_time(verb, 1, 3), face(minus_real_time(verb, 1, 3), a , b)) + " буоллар";
    }
    public String past_time_conditional(String verb, int a, int b, int c){
        if (c==0) return past_time(verb, a, b) + " буоллар";
        else return minus_past_time(verb, a, b) + " буоллар";
    }

}
