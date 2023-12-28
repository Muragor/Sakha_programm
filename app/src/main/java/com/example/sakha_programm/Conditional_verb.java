package com.example.sakha_programm;

public class Conditional_verb extends Sakha_verb{
    public String not_in_time(String verb, int a, int b, int c){
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return not_in_time(verb1, a, b, c)+"-"+not_in_time(verb2, a, b, c);
        }
        String g1 = dict2[Garmony(verb)];
        String g2 = dict1[Garmony_of_sl(g1, 1)];
        if (c == 0) {
        verb = upod_sogl_of_verb_and_verb_time(verb,verb+"т"+g1+"р"); }
        else { verb = upod_sogl_of_verb_and_verb_time(verb,verb+"б"+g1+"т"+g1+"р"); }
        if (a == 2 && b == 3) return skaz(verb.substring(0, verb.length()-1)+"л", a ,b);
        return skaz(verb, a ,b);
    }
    public String real_time_conditional(String verb, int a, int b, int c, int d){
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return real_time_conditional(verb1, a, b, c, d)+"-"+real_time_conditional(verb2, a, b, c, d);
        }
        String g1 = dict2[Garmony(verb)];
        String g2 = dict1[Garmony_of_sl(g1, 1)];
        if (c==0) {
            if (b==3 && a == 2) {
                if (d==0)
                   return real_time(verb, 1, 3).substring(0,real_time(verb, 1, 3).length()-1 ) + "лл" + g1 + "р" + g1 + " буоллар";
                else return real_time(verb, 1, 3).substring(0,real_time(verb, 1, 3).length()-1 ) + "лл" + g1 + "р" + g1 + " буоллаҕына";
            }
            if (d == 0) {
                if (b==2 && a==2) return real_time(verb, 1, 3)+"г" + g2 + "т" +" буоллар";
               return face(real_time(verb, 1, 3), a , b) + " буоллар"; }
            else {
                if (b==2 && a==2) return real_time(verb, 1, 3)+"г" + g2 + "т" +" буоллаҕына";
                return face(real_time(verb, 1, 3), a , b) + " буоллаҕына";
            }
        }
        else {
            if (d==0)
               return upod_sogl_of_verb_time_and_lic(minus_real_time(verb, 1, 3), face(minus_real_time(verb, 1, 3), a , b)) + " буоллар";
            else return upod_sogl_of_verb_time_and_lic(minus_real_time(verb, 1, 3), face(minus_real_time(verb, 1, 3), a , b)) + " буоллаҕына";
        }
    }
    public String past_time_conditional(String verb, int a, int b, int c, int d){
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return past_time_conditional(verb1, a, b, c, d)+"-"+past_time_conditional(verb2, a, b, c, d);
        }
        if (c==0) {
            if (d==0)
               return past_time(verb, a, b) + " буоллар";
            else
                return past_time(verb, a, b) + " буоллаҕына";
        }
        else { if (d==0)
            return minus_past_time(verb, a, b) + " буоллар";
        else
            return minus_past_time(verb, a, b) + " буоллаҕына"; }
    }

    public String not_in_time_2(String verb, int a, int b, int c) {
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return not_in_time_2(verb1, a, b, c)+"-"+not_in_time_2(verb2, a, b, c);
        }
        String g1 = dict2[Garmony(verb)];
        String g2 = dict1[Garmony_of_sl(g1, 1)];
        String g3 = dict2[Garmony_of_sl(g2, 1)];
        if (c==0) {
            verb = upod_sogl_of_verb_and_verb_time(verb, verb+"т"+g1+"х");}
        else {
            verb = minus_past_time(verb, 2, 1).substring(0, minus_past_time(verb, 2, 1).length()-3);
        }
        if (a==1 && (b==1 || b==2)) return skaz(verb, a ,b)+g3;
        return upod_sogl_of_verb_and_verb_time(skaz(verb, a ,b), skaz(verb, a ,b)+g2+"н"+g3);
    }
}
