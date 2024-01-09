package com.example.sakha_programm;


public class Sakha_verb
{
    public String[] dict1 = {"", "и", "ы", "у", "у", "ү", "ү"};
    public String[] dict2 = {"", "э", "а", "а", "о", "э", "ө"};
    public String[] glass_letters = {"а", "ы", "о", "у", "э", "и", "ө", "ү"};

    public String[] glass_usk = {"и", "ы", "у", "ү"};
    public String[] glass_shir = {"э", "а", "о",  "ө"};
    public boolean This_el(String[] arr, String toCheckValue) {
        for (String element : arr) {
            if (element.equals(toCheckValue)) {
                return true;
            }
        }
        return false;
    }
    public int Garmony_of_sl(String v, int n)
    {
        v = v.toLowerCase();
        int len = v.length();
        if (Character.toString(v.charAt(len - n)).equals("и") || Character.toString(v.charAt(len - n)).equals("э")) return 1;
        if (Character.toString(v.charAt(len - n)).equals("ы") || Character.toString(v.charAt(len - n)).equals("а")) return 2;
        if (Character.toString(v.charAt(len - n)).equals("у")) return 3;
        if (Character.toString(v.charAt(len - n)).equals("о")) {
            if (len-(n+1) >= 0) {
                if (Character.toString(v.charAt(len - n -1)).equals("у")) return 3;
                else return 4; }
            else return 4;
        }
        if (Character.toString(v.charAt(len - n)).equals("ү")) return 5;
        if (Character.toString(v.charAt(len - n)).equals("ө")) {
            if (len-(n+1) >= 0) {
                if (Character.toString(v.charAt(len - n-1)).equals("ү")) return 5;
                else return 6; }
            else return 6;
        }
        return -1;
    }

    public int Garmony(String v){
        v = v.toLowerCase();
        int len = v.length();
        if (This_el(glass_letters, Character.toString(v.charAt(len-1)))) {
            if (v.charAt(len-1)==v.charAt(len-2)) {
                if (v.length() >= 4 && Garmony_of_sl(v, 4) != -1) return Garmony_of_sl(v, 4);
                else {
                    if (len >= 5 && Garmony_of_sl(v, 5) != -1) return Garmony_of_sl(v, 5);
                    else return Garmony_of_sl(v, 2);
                }
            }
            else if (This_el(glass_shir, Character.toString(v.charAt(len-1))) && This_el(glass_usk, Character.toString(v.charAt(len-2))))
                return Garmony_of_sl(v, 2);
            else return Garmony_of_sl(v, 1);
        }
        else {
            for (int i = 1; i < v.length()+1; i++) {
                if (This_el(glass_letters, Character.toString(v.charAt(len-i)))) return Garmony_of_sl(v, i);
            }
        }
        return -1;
    }

    public String check_for_irregular_verbs(String v) {
        v = v.toLowerCase();
        int len = v.length();
        if (len < 3) return v;
        String[] arr1 = {"р", "й", "л"};
        String[] arr2 = {"ҥ", "н", "м"};
        if (v.toLowerCase().equals("илт")) return "илдь";
        else if (v.charAt(len-1) == 'т' && v.charAt(len-2) == 'р') return v.substring(0, v.length()-1)+ "д";
        else if (v.toLowerCase().equals("ыарый")) return "ыалдь";
        else if (v.toLowerCase().equals("сырыт")) {return "сылдь";}
        else if (v.toLowerCase().equals("уһул")) {return "уст";}
        else if (v.charAt(len-1) == 'с' && This_el(glass_usk, Character.toString(v.charAt(len-2))) && This_el(arr1, Character.toString(v.charAt(len-3))))
        {return v.substring(0, len-2) + v.charAt(len-1);}
        else if (v.charAt(len-1) == 'н' && This_el(glass_usk, Character.toString(v.charAt(len-2))) && This_el(arr2, Character.toString(v.charAt(len-3))))
        {return v.substring(0, len-2) + v.charAt(len-1);}
        else if (v.charAt(len-1) == 'н' && This_el(glass_usk, Character.toString(v.charAt(len-2))) && v.charAt(len-3) == 'т')
        {return v.substring(0, len-2) + "т";}
        else if (v.charAt(len-1) == 'н' && This_el(glass_usk, Character.toString(v.charAt(len-2))) && v.charAt(len-3) == 'л')
        {return v.substring(0, len-2) + "л";}
        else if (v.charAt(len-1) == 'т' && This_el(glass_usk, Character.toString(v.charAt(len-2))) && v.charAt(len-3) == 'й')
        {return v.substring(0, len-2) + "д";}
        else if (v.charAt(len-1) == 'н' && This_el(glass_usk, Character.toString(v.charAt(len-2))) && v.charAt(len-3) == 'г') {
            v = v.substring(0, len-2) + " т";
            for (int i = 0; i < v.length(); i++) {
            if (v.charAt(i) == 'г')
                return v.substring(0, i) + "к" + v.substring(i+1);
        } return v;}
        else if (v.charAt(len-1) == 'н' && This_el(glass_usk, Character.toString(v.charAt(len-2))) && v.charAt(len-3) == 'һ') {
            v = v.substring(0, len-2) + " т";
            for (int i = 0; i < v.length(); i++) {
            if (v.charAt(i) == 'һ')
                return v.substring(0, i) + "с" + v.substring(i+1);
        } return v;}
        else if (v.charAt(len-1) == 'с' && This_el(glass_usk, Character.toString(v.charAt(len-2))) && v.charAt(len-3) == 'ҕ') {
            v = v.substring(0, len-2) + "с";
            for (int i = 0; i < v.length(); i++) {
                if (v.charAt(i) == 'ҕ')
                    return v.substring(0, i) + "х" + v.substring(i+1);
            } return v;}
        else return v;
    }
    public String face(String v, int a, int b) {
        v = v.toLowerCase();
        String c1 = dict1[Garmony(v)];
        String c2 = dict2[Garmony(v)];
        int len = v.length();
        if (a==1) {
            if (b==1) {
                if (This_el(glass_letters, Character.toString(v.charAt(len-1))))return v+"м";
                else return v + c1 + "м";
            }
            if (b==2) {
                if (This_el(glass_letters, Character.toString(v.charAt(len-1)))) return v+"ҥ";
                else return v + c1 + "ҥ";
            }
            if (b==3) {
                if (This_el(glass_letters, Character.toString(v.charAt(len-1)))) return v+"т"+c2;
                else return v+c2;}

            else return "?";
        }
        if (a==2) {
            if (b==1) {
                return v + "б" + c1 + "т";
            }
            if (b==2) {
                return v + "ҕ" + c1 + "т";
            }
            if (b==3) return v+"л" + c2 + "р" + c2;

            else return "?";
        }
        else return "?";
    }

    public String upod_sogl_sl(String v, char d1, String v_afficks, char d2, String replacement) {
        v = v.toLowerCase();
        int len = v.length();
        String c1 = v_afficks.substring(len);
        if (v.charAt(len-1) == d1 && c1.charAt(0)==d2) {
            if (replacement.length() > 1 && !replacement.equals("нь") && !replacement.equals("дь")) return v.substring(0, len-1) + replacement + c1.substring(1, c1.length());
            else return v+replacement+c1.substring(1, c1.length());
        }
        else return "?";

    }

    public String upod_sogl_of_verb_and_verb_time(String v, String v_time) {
        v = v.toLowerCase();
        String c3 = v_time.substring(v.length());
        if (!upod_sogl_sl(v, 'т', v_time, 'б', "пп").equals("?"))
            return upod_sogl_sl(v, 'т', v_time, 'б', "пп");
        else if (!upod_sogl_sl(v, 'н', v_time, 'б', "мм").equals("?")) {
            return upod_sogl_sl(v, 'н', v_time, 'б', "мм");
        }
        else if (!upod_sogl_sl(v, 'м', v_time, 'б', "м").equals("?")) {
            return upod_sogl_sl(v, 'м', v_time, 'б', "м");
        }
        else if (!upod_sogl_sl(v, 'к', v_time, 'һ', "с").equals("?")) {
            return upod_sogl_sl(v, 'к', v_time, 'һ', "с");
        }
        else if (!upod_sogl_sl(v, 'х', v_time, 'һ', "с").equals("?")) {
            return upod_sogl_sl(v, 'х', v_time, 'һ', "с");
        }
        else if (!upod_sogl_sl(v, 'с', v_time, 'һ', "ч").equals("?")) {
            return upod_sogl_sl(v, 'с', v_time, 'һ', "ч");
        }
        else if (!upod_sogl_sl(v, 'п', v_time, 'һ', "ч").equals("?")) {
            return upod_sogl_sl(v, 'п', v_time, 'һ', "ч");
        }
        else if (!upod_sogl_sl(v, 'т', v_time, 'һ', "ч").equals("?")) {
            return upod_sogl_sl(v, 'т', v_time, 'һ', "ч");
        }
        else if (!upod_sogl_sl(v, 'й', v_time, 'һ', "дь").equals("?")) {
            return upod_sogl_sl(v, 'й', v_time, 'һ', "дь");
        }
        else if (!upod_sogl_sl(v, 'л', v_time, 'һ', "дь").equals("?")) {
            return upod_sogl_sl(v, 'л', v_time, 'һ', "дь");
        }
        else if (!upod_sogl_sl(v, 'р', v_time, 'һ', "дь").equals("?")) {
            return upod_sogl_sl(v, 'р', v_time, 'һ', "дь");
        }
        else if (!upod_sogl_sl(v, 'м', v_time, 'һ', "нь").equals("?")) {
            return upod_sogl_sl(v, 'м', v_time, 'һ', "нь");
        }
        else if (!upod_sogl_sl(v, 'н', v_time, 'һ', "нь").equals("?")) {
            return upod_sogl_sl(v, 'н', v_time, 'һ', "нь");
        }
        else if (!upod_sogl_sl(v, 'ҥ', v_time, 'һ', "нь").equals("?")) {
            return upod_sogl_sl(v, 'ҥ', v_time, 'һ', "нь");
        }
        else if (!upod_sogl_sl(v, 'ҥ', v_time, 'б', "м").equals("?")) {
            return upod_sogl_sl(v, 'ҥ', v_time, 'б', "м");
        }
        else if (!upod_sogl_sl(v, 'х', v_time, 'б', "п").equals("?")) {
            return upod_sogl_sl(v, 'х', v_time, 'б', "п");
        }
        else if (!upod_sogl_sl(v, 'п', v_time, 'б', "п").equals("?")) {
            return upod_sogl_sl(v, 'п', v_time, 'б', "п");
        }
        else if (!upod_sogl_sl(v, 'с', v_time, 'б', "п").equals("?")) {
            return upod_sogl_sl(v, 'с', v_time, 'б', "п");
        }
        else if (!upod_sogl_sl(v, 'к', v_time, 'б', "п").equals("?")) {
            return upod_sogl_sl(v, 'к', v_time, 'б', "п");
        }
        else if (!upod_sogl_sl(v, 'л', v_time, 'т', "л").equals("?")) {
            return upod_sogl_sl(v, 'л', v_time, 'т', "л");
        }
        else if (!upod_sogl_sl(v, 'й', v_time, 'т', "д").equals("?")) {
            return upod_sogl_sl(v, 'й', v_time, 'т', "д");
        }
        else if (!upod_sogl_sl(v, 'р', v_time, 'т', "д").equals("?")) {
            return upod_sogl_sl(v, 'р', v_time, 'т', "д");
        }
        else if (!upod_sogl_sl(v, 'н', v_time, 'т', "н").equals("?")) {
            return upod_sogl_sl(v, 'н', v_time, 'т', "н");
        }
        else if (!upod_sogl_sl(v, 'ҥ', v_time, 'т', "н").equals("?")) {
            return upod_sogl_sl(v, 'ҥ', v_time, 'т', "н");
        }

        //гласные с согалсными
        char c2 = c3.charAt(0);
        if (This_el(glass_letters, Character.toString(c2))) {
            if (!upod_sogl_sl(v, 'х', v_time, c2, "ҕ").equals("?"))
                return v_time.substring(0, v.length()-1) + "ҕ" + c3;
            if (!upod_sogl_sl(v, 'с', v_time, c2, "һ").equals("?")) {
                String[] arr = {"р", "й", "х", "л"};
                if (This_el(arr, Character.toString(v.charAt(v.length()-2)))) return v_time;
                else return v_time.substring(0, v.length()-1) + "һ" + c3; }
            if (!upod_sogl_sl(v, 'п', v_time, c2, "б").equals("?"))
                return v_time.substring(0, v.length()-1) + "б" + c3;
            if (!upod_sogl_sl(v, 'к', v_time, c2, "г").equals("?"))
                return v_time.substring(0, v.length()-1) + "г" + c3;
            if (v.charAt(v.length()-2) == 'р' && v.charAt(v.length()-1) == 'т')
                return v_time.substring(0, v.length()-1) + "д" + c3;
            else return v_time;
        }
        else return v_time;
    }

    public String upod_sogl_of_verb_time_and_lic(String v_time, String v_time_lico) {
        v_time = v_time.toLowerCase();
        if (!upod_sogl_sl(v_time, 'т', v_time_lico, 'б', "пп").equals("?"))
            return upod_sogl_sl(v_time, 'т', v_time_lico, 'б', "пп");
        else if (!upod_sogl_sl(v_time, 'т', v_time_lico, 'ҕ', "кк").equals("?"))
            return upod_sogl_sl(v_time, 'т', v_time_lico, 'ҕ', "кк");
        else if (!upod_sogl_sl(v_time, 'т', v_time_lico, 'л', "т").equals("?"))
            return upod_sogl_sl(v_time, 'т', v_time_lico, 'л', "т");

        else if (!upod_sogl_sl(v_time, 'х', v_time_lico, 'ҕ', "х").equals("?"))
            return upod_sogl_sl(v_time, 'х', v_time_lico, 'ҕ', "х");
        else if (!upod_sogl_sl(v_time, 'к', v_time_lico, 'ҕ', "к").equals("?"))
            return upod_sogl_sl(v_time, 'к', v_time_lico, 'ҕ', "к");
        else if (!upod_sogl_sl(v_time, 'п', v_time_lico, 'ҕ', "к").equals("?"))
            return upod_sogl_sl(v_time, 'п', v_time_lico, 'ҕ', "к");
        else if (!upod_sogl_sl(v_time, 'с', v_time_lico, 'ҕ', "к").equals("?"))
            return upod_sogl_sl(v_time, 'с', v_time_lico, 'ҕ', "к");
        else if (!upod_sogl_sl(v_time, 'х', v_time_lico, 'б', "п").equals("?"))
            return upod_sogl_sl(v_time, 'х', v_time_lico, 'б', "п");
        else if (!upod_sogl_sl(v_time, 'х', v_time_lico, 'л', "т").equals("?"))
            return upod_sogl_sl(v_time, 'х', v_time_lico, 'л', "т");

        else if (!upod_sogl_sl(v_time, 'л', v_time_lico, 'ҕ', "г").equals("?"))
            return upod_sogl_sl(v_time, 'л', v_time_lico, 'ҕ', "г");
        else if (!upod_sogl_sl(v_time, 'й', v_time_lico, 'ҕ', "г").equals("?"))
            return upod_sogl_sl(v_time, 'й', v_time_lico, 'ҕ', "г");
        else if (!upod_sogl_sl(v_time, 'р', v_time_lico, 'ҕ', "г").equals("?"))
            return upod_sogl_sl(v_time, 'р', v_time_lico, 'ҕ', "г");

        else if (!upod_sogl_sl(v_time, 'м', v_time_lico, 'ҕ', "ҥ").equals("?"))
            return upod_sogl_sl(v_time, 'м', v_time_lico, 'ҕ', "ҥ");
        else if (!upod_sogl_sl(v_time, 'ҥ', v_time_lico, 'ҕ', "ҥ").equals("?"))
            return upod_sogl_sl(v_time, 'ҥ', v_time_lico, 'ҕ', "ҥ");
        else if (!upod_sogl_sl(v_time, 'н', v_time_lico, 'ҕ', "ҥҥ").equals("?"))
            return upod_sogl_sl(v_time, 'н', v_time_lico, 'ҕ', "ҥҥ");

        char c1 = v_time.charAt(v_time.length()-1);
        if (This_el(glass_usk, Character.toString(c1)))
        {
            if (!upod_sogl_sl(v_time, c1, v_time_lico, 'ҕ', "г").equals("?")) return upod_sogl_sl(v_time, c1, v_time_lico, 'ҕ', "г");
            else return v_time_lico;
        }
        else return v_time_lico;
    }
    public String skaz(String w, int a, int b){
        String g1 = dict1[Garmony(w)];
        String g2 = dict2[Garmony(w)];
        if (a==1) {
            switch (b) {
                case 1:
                    return upod_sogl_of_verb_and_verb_time(w, w+"б"+g1+"н");
                case 2:
                    return upod_sogl_of_verb_time_and_lic(w, w+"ҕ"+g1+"н");
                default:
                    return w;
            }
        }
        else {
            switch (b) {
                case 1:
                    return upod_sogl_of_verb_and_verb_time(w, w+"б"+g1+"т");
                case 2:
                    return upod_sogl_of_verb_time_and_lic(w, w+"ҕ"+g1+"т");
                default:
                    if (This_el(glass_letters, Character.toString(w.charAt(w.length()-1))))
                        return w+"л"+g2+"р";
                    else return upod_sogl_of_verb_and_verb_time(w, w+"т"+g2+"р");
            }
        }
    }

    public String past_time_result_1(String v, int a, int b, int c) {
        if (c==0) return skaz(past_time(v,a, b).substring(0,past_time(v,1, 1).length()-2), a, b);
        else return skaz(minus_past_time(v,2, 1).substring(0,past_time(v,2, 1).length()-1), a, b);
    }
    public String deep_past_1(String v, int a, int b, int c) {
        v = v.toLowerCase();
        String g1 = dict2[Garmony(v)];
        if (c==0) {
            if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                return v+"н";
            else {
                v = check_for_irregular_verbs(v);
                return upod_sogl_of_verb_and_verb_time(v, v+g1+"н");
            }
        }
        else {
            if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='р')
            {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
            else if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='л')
            {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
            if (!check_for_irregular_verbs(v).equals(v)) {
                v = check_for_irregular_verbs(v)+v.charAt(v.length()-2); }
            return upod_sogl_of_verb_and_verb_time(v, v+"б"+g1+"кк"+g1);
        }
    }
    public String past_time_result_2(String v, int a, int b, int c) {
        return deep_past_1(v, a, b ,c) + " " + real_time("тур", a, b);
    }
    public String past_time_episodic_1(String v, int a, int b, int c) {
        if (c==0) {
        v = past_time(v, 1, 1).substring(0, past_time(v, 1, 1).length()-2); }
        else {  v = minus_past_time(v, 2, 1).substring(0, minus_past_time(v, 2, 1).length()-3);}
        String g1 = dict2[Garmony(v)];
        return skaz(v+"т" + g1 +g1 + "х", a, b);
    }
    public String past_time_episodic_2(String v, int a, int b, int c) {
        v = past_time(v, a, b);
        if (c==0) return v + " баар";
        else return v + " суох";
    }

    public String past_time_episodic_3(String v, int a, int b, int c) {
        return deep_past_1(v, a, b ,c) + " " + skaz("турардаах", a ,b);
    }

    public String past_time_not_finished_1(String v, int a, int b, int c) {
        if (c==0) {
            if (a==2 && b == 3) return face(real_time(v, 2, 3), 1 , 3 );
            else return face(real_time(v, 1, 3), a , b );
        }
        else return upod_sogl_of_verb_time_and_lic(minus_real_time(v, 1, 3), face(minus_real_time(v, 1, 3), a , b ));
    }
    public String past_time_not_finished_2(String v, int a, int b, int c) {
        if (c==0) return real_time(v, 1, 3) + " " + verb_recent_time("э", a , b);
        else return minus_real_time(v, 1, 3) + " " + verb_recent_time("э", a , b);
    }
    public String past_time_long_ago(String v, int a, int b, int c) {
        if (c==0) return past_time(v, 1, 1).substring(0, past_time(v, 1, 1).length()-2) + " " + verb_recent_time("э", a , b);
        else return minus_past_time(v, 2, 1).substring(0, minus_past_time(v, 2, 1).length()-3) + " " + verb_recent_time("э", a , b);
    }

    public String past_time_long_ago_episodic_1(String v, int a, int b, int c) {
        return past_time_episodic_1(v, 1, 3, c) + " " + verb_recent_time("э", a , b);
    }
    public String past_time_long_ago_episodic_2(String v, int a, int b, int c) {
        return past_time_episodic_2(v, a, b, c) + " этэ" ;
    }
    public String past_time_long_ago_episodic_3(String v, int a, int b, int c) {
        return past_time_episodic_3(v, 1, 3, c) + " " + verb_recent_time("э", a , b);
    }
    public String past_time(String v, int a, int b) {
        v = v.toLowerCase();
        int len = v.length();
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return past_time(verb1, a, b)+"-"+past_time(verb2, a, b);
        }
        else {
        if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='р')
        {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
        else if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='л')
        {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
        else if (!check_for_irregular_verbs(v).equals(v))
            v = check_for_irregular_verbs(v)+v.charAt(len-2);
        int c = -1;
        for (int i = 1; i < v.length()+1; i++) {
            String s = Character.toString(v.charAt(len-i));
            if (This_el(glass_letters, Character.toString(v.charAt(len-i)))) {
                c = Garmony_of_sl(s, 1);
                break; }
        }
        String g = dict1[c];
        String v_past = v + "б" + g + "т";
        String v_time = upod_sogl_of_verb_and_verb_time(v, v_past);
        String v_lico = face(v_time, a, b);
        return upod_sogl_of_verb_time_and_lic(v_time, v_lico); }

    }

    public String minus_past_time(String v, int a, int b) {
        v = v.toLowerCase();
        int len = v.length();
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return minus_past_time(verb1, a, b)+"-"+minus_past_time(verb2, a, b);
        }
        else {
        if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='р')
        {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
        else if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='л')
        {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
        else if (!check_for_irregular_verbs(v).equals(v)) {
            v = check_for_irregular_verbs(v)+v.charAt(len-2);}
        String g1 = dict2[Garmony(v)];
        String afficks = "б" + g1 + "т" + g1 + "х";
        v = upod_sogl_of_verb_and_verb_time(v, v+afficks);
        if (a==1) return upod_sogl_of_verb_and_verb_time(v , face(v, a, b));
        else return upod_sogl_of_verb_time_and_lic(v , face(v, a, b)); }
    }
    public String real_time(String v, int a, int b) {
        v = v.toLowerCase();
        v = check_for_irregular_verbs(v);
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return real_time(verb1, a, b)+"-"+real_time(verb2, a, b);
        }
        else {
        String v_deep = deep_verb(v, a ,b);
        if (a==2 && b == 3) return skaz(v_deep+"л", a, b);
        if (a==1 && b == 3) return v_deep+"р";
        return skaz(v_deep, a, b); }
    }

    public String minus_real_time(String v, int a, int b) {
        v = v.toLowerCase();
        int len = v.length();
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return minus_real_time(verb1, a, b)+"-"+minus_real_time(verb2, a, b);
        }
        if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='р')
        {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
        else if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='л')
        {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
        else if (!check_for_irregular_verbs(v).equals(v)) {
            v = check_for_irregular_verbs(v)+v.charAt(len-2);}
        String c1 = dict2[Garmony(v)];
        String c2 = dict1[Garmony_of_sl(c1, 1)];
        String afficks = "б" + c1 + "т";
        v = upod_sogl_of_verb_and_verb_time(v, v + afficks);
        return skaz(v, a, b);
    }
    public String future_time(String v, int a, int b) {
        v = check_for_irregular_verbs(v);
        int len = v.length();
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return future_time(verb1, a, b)+"-"+future_time(verb2, a, b);
        }
        String g1 = dict1[Garmony(v)];
        switch (g1) {
            case "ы":
                g1 = "ыах";
                break;
            case "у":
                g1 = "уох";
                break;
            case "и":
                g1 = "иэх";
                break;
            case "ү":
                g1 = "үөх";
                break;
        }

        if (a==1) {

            if (This_el(glass_letters, Character.toString(v.charAt(len-1)))) {v = v.substring(0, len-2)+g1;
                return upod_sogl_of_verb_and_verb_time(v, face(v, a, b)); }
            else {
                v = upod_sogl_of_verb_and_verb_time(v, v+g1);
                return upod_sogl_of_verb_and_verb_time(v, face(v, a, b)); } }
        else {

            if (This_el(glass_letters, Character.toString(v.charAt(len-1)))) {
                v = v.substring(0, len-2)+g1;
                return upod_sogl_of_verb_time_and_lic(v, face(v, a, b)); }
            else {
                v = upod_sogl_of_verb_and_verb_time(v, v+g1);
                return upod_sogl_of_verb_time_and_lic(v, face(v, a, b)); }
        }
    }

    public String minus_future_time(String v, int a, int b) {
        v = check_for_irregular_verbs(v);
        int len = v.length();
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return minus_future_time(verb1, a, b).substring(0, minus_future_time(verb1, a, b).length()-6)+"-"+minus_future_time(verb2, a, b);
        }
        String g1 = dict1[Garmony(v)];
        switch (g1) {
            case "ы":
                g1 = "ыа";
                break;
            case "у":
                g1 = "уо";
                break;
            case "и":
                g1 = "иэ";
                break;
            case "ү":
                g1 = "үө";
                break; }
        if (a==1) {
            if (This_el(glass_letters, Character.toString(v.charAt(len-1)))) {
                switch (b) {
                    case 3:
                        return v.substring(0, len-2) + g1 + " cуоҕа";
                    default:    return face(v.substring(0, len-2) + g1, a, b) + " cуоҕа";
                } }
            else {
                switch (b) {
                    case 3:
                        return v + g1 + " cуоҕа";
                    default:    return face(v + g1, a, b) + " cуоҕа";
                }  } }
        else {
           return future_time(v, a, b) + " суоҕа";
        }

    }

    public String verb_recent_time(String v, int a, int b) {
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return verb_recent_time(verb1, a, b)+"-"+verb_recent_time(verb2, a, b);
        }
        if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='р')
            v = v;
        else if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='л')
            v = v;
        else v = upod_sogl_of_verb_and_verb_time(v, v+'т');
        if (a==1) return face(v, a , b);

        String c = dict1[Garmony(v)];
        String c1 = dict2[Garmony_of_sl(c, 1)];
        switch (b) {
            case 1: v = v+c+"б"+c+"т"; break;
            case 2: v = v+c+"г"+c+"т";break;
            case 3: v = v+c+"л"+c1+"р";break;
             }
        return v;
    }

    public String minus_verb_recent_time(String v, int a, int b) {
        v = v.toLowerCase();
        int len = v.length();
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return minus_verb_recent_time(verb1, a, b)+"-"+minus_verb_recent_time(verb2, a, b);
        }
        if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='р')
        {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
        else if (v.charAt(v.length()-1)=='т' && v.charAt(v.length()-2)=='л')
        {v = check_for_irregular_verbs(v)+dict1[Garmony(v)];}
        else if (!check_for_irregular_verbs(v).equals(v)) {
            v = check_for_irregular_verbs(v)+v.charAt(len-2); }
        String c1 = dict2[Garmony(v)];
        String c2 = dict1[Garmony_of_sl(c1, 1)];
        String afficks = "б" + c1 + "т";
        v = upod_sogl_of_verb_and_verb_time(v, v + afficks);
        if (a==1) return face(v, a, b);
        switch (b) {
            case 1: v = v+c2+"б"+c2+"т"; break;
            case 2: v = v+c2+"г"+c2+"т";break;
            case 3: v = v+c2+"л"+dict2[Garmony_of_sl(c2, 1)]+"р";break;
        }
        return v;
    }

    public String deep_verb(String v, int a, int b) {
        v = check_for_irregular_verbs(v);
        int len = v.length();
        String c1 = dict2[Garmony(v)];
        String c2 = dict1[Garmony(v)];
        String v_deep = v+c1;
        if (This_el(glass_letters, Character.toString(v.charAt(len-1)))) {
            if (This_el(glass_letters, Character.toString(v.charAt(len-2)))) {
                v_deep = v.substring(0, len-2) + c2 + c2; }
            else {
                v_deep = v.substring(0, len-1) + c2 + c2; }
        }
        else v_deep = upod_sogl_of_verb_and_verb_time(v, v_deep);
        return v_deep;
    }
    public String verb_not_finished_time(String v, int a, int b) {
        v = check_for_irregular_verbs(v);
        int len = v.length();
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return deep_verb(verb1, a ,b)+"-"+ deep_verb(verb2, a ,b) +skaz(" илик", a, b);
        }
        return deep_verb(v, a ,b)+skaz(" илик", a, b);
    }

    public String imperative_mood(String v, int t, int a, int b, int c) {
        if (v.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (v.charAt(i) != '-') {
                verb1+=v.charAt(i);
                i++;
            }
            verb2 = v.substring(verb1.length()+1);
            return imperative_mood(verb1, t, a, b, c)+"-"+imperative_mood(verb2,t, a, b, c);
        }
        String c1 = dict2[Garmony(v)];
        String c2 = dict1[Garmony(v)];
        switch (t) {
            case 1:
                if (a==1) {
                    switch (b) {
                        case 1:
                            return "Отсутствует";
                        case 2:
                            if (c==0) {
                            if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                                return upod_sogl_of_verb_and_verb_time(v, v+'р');
                            else {
                                v = check_for_irregular_verbs(v);
                                return upod_sogl_of_verb_and_verb_time(v, v+c1+c1+"р"); } }
                            else {
                                if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                                    return v+'м'+c1+c1+'р';
                                else
                                    v = check_for_irregular_verbs(v);
                                    return upod_sogl_of_verb_and_verb_time(v, v+c2+'м'+dict2[Garmony_of_sl(c2, 1)]+dict2[Garmony_of_sl(c2, 1)]+"р");
                            }
                        case 3:
                            if (c==0) {
                            String v1 = future_time(v, 2, 1);
                            return v1.substring(0, v1.length()-3)+"т"+c2+"н"; }
                            else {
                                if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                                    v = v+"м"+c1+c1;
                                else {
                                    v = check_for_irregular_verbs(v);
                                    v = upod_sogl_of_verb_and_verb_time(v, v+c2+'м'+dict2[Garmony_of_sl(c2, 1)]+dict2[Garmony_of_sl(c2, 1)]); }
                                String v1 = future_time(v, 2, 1);
                                return v1.substring(0, v1.length()-3)+"т"+c2+"н"; }

                        default: return "Отсутствует";

                    }
                }
                else {
                    switch (b) {
                        case 1:
                            return "Отсутствует";
                        case 2:
                            return upod_sogl_of_verb_and_verb_time(imperative_mood(v, t, 1, 2, c), imperative_mood(v, t, 1, 2, c) + dict1[Garmony(imperative_mood(v, t, 1, 2, c))] + "ҥ");
                        case 3:
                            return upod_sogl_of_verb_and_verb_time(imperative_mood(v, t, 1, 3, c), imperative_mood(v, t, 1, 3, c) + "н" +dict2[Garmony_of_sl(c2, 1)] + "р");
                        default: return "Отсутствует";
                    }
                }
            case 2:
                if (a==1) {
                    switch (b) {
                        case 1:
                            if (c==1) {
                                if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                                    v = v+"м"+c1+c1;
                                else {
                                    v = check_for_irregular_verbs(v);
                                    v = upod_sogl_of_verb_and_verb_time(v, v+c2+'м'+c1+c1); }
                            }
                            if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                                return v.substring(0, v.length()-2)+c2+c2+'м';
                            else {
                                v = check_for_irregular_verbs(v);
                                return upod_sogl_of_verb_and_verb_time(v,  v+c2+c2+'м'); }
                        case 2:
                            if (c==1) {
                            if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1)))) {
                            return v+"м"+c1; }
                            else {
                                v = check_for_irregular_verbs(v);
                                return v = upod_sogl_of_verb_and_verb_time(v, v+c2+'м'+dict2[Garmony_of_sl(c2, 1)]); } }
                            else return v;
                        case 3:
                            if (c==1) v = minus_real_time(v, 1, 3).substring(0,minus_real_time(v, 1, 3).length()-1 );
                            return upod_sogl_of_verb_and_verb_time(v, v+"т"+dict1[Garmony(v)]+"н");
                        default: return "Отсутствует";
                    }
                }
                else {
                    switch (b) {
                        case 1:
                            if (c==1) {
                                if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                                    v = v+"м"+c1+c1;
                                else {
                                    v = check_for_irregular_verbs(v);
                                    v = upod_sogl_of_verb_and_verb_time(v, v+c2+'м'+dict2[Garmony_of_sl(c2, 1)]+dict2[Garmony_of_sl(c2, 1)]); }
                            }
                            return future_time(v, 1, 2);
                        case 2:
                            if (c==1) {
                                if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                                    v = v+"м"+c1;
                                else {
                                    v = check_for_irregular_verbs(v);
                                    v = upod_sogl_of_verb_and_verb_time(v, v+c2+'м'+dict2[Garmony_of_sl(c2, 1)]); }
                            }
                            if (This_el(glass_letters, Character.toString(v.charAt(v.length()-1))))
                                return upod_sogl_of_verb_and_verb_time(v, v+'ҥ');
                            else {
                                v = check_for_irregular_verbs(v);
                                return upod_sogl_of_verb_and_verb_time(v, v+c2+"ҥ"); }
                        case 3:
                            return imperative_mood(v, t, 1, 3, c) + "н" +dict2[Garmony_of_sl(c2, 1)] + "р";
                        default: return "Отсутствует";
                    }
                }
            default: return "Отсутствует";
        }
    }
    public String maybe_mood(String verb, int a, int b, int c) {
        if (verb.contains("-")) {
            int i = 0;
            String verb1 = "";
            String verb2;
            while (verb.charAt(i) != '-') {
                verb1+=verb.charAt(i);
                i++;
            }
            verb2 = verb.substring(verb1.length()+1);
            return maybe_mood(verb1, a, b, c)+"-"+maybe_mood(verb2, a, b, c);
        }
        String g1 = dict2[Garmony(verb)];
        String g2 = dict1[Garmony_of_sl(g1, 1)];
        String g3 = dict2[Garmony_of_sl(g2, 1)];
        if (c==0) {
            if (This_el(glass_letters, Character.toString(verb.charAt(verb.length()-1)))) {
                verb = verb + "й";
            }
            else {
                verb = check_for_irregular_verbs(verb);
                verb = upod_sogl_of_verb_and_verb_time(verb, verb + g1+ g1 + "й");
            }
        }
        else { verb = imperative_mood(verb, 2, 1, 2, 1) + g3 + "й"; }
        if (b==3 && a==1) return verb.substring(0, verb.length()-1) + "р" + g3 + "й";
        else
            return real_time(verb, a ,b);
    }
    public String verb_finally(String v, int t, int a, int b) {
        switch (t) {
            case 1: return future_time(v, a, b);
            case 2: return real_time(v, a, b);
            case 3: return past_time(v, a, b);
            case 4: return minus_future_time(v, a ,b);
            case 5: return minus_real_time(v, a, b);
            case 6: return minus_past_time(v, a ,b);
            case 7: return verb_recent_time(v, a, b);
            case 8: return minus_verb_recent_time(v, a, b);
            case 9: return verb_not_finished_time(v, a, b);

        }
        return "Непредвиденная ошибка";
    }
    }

