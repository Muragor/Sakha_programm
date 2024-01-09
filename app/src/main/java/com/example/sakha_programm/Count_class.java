package com.example.sakha_programm;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;

public class Count_class extends Sakha_verb{

    public int Garmony(String c) {
        return super.Garmony(c);
    }
    @Override
    public boolean This_el(String[] arr, String toCheckValue) {
        return super.This_el(arr, toCheckValue);
    }



    @Override
    public String check_for_irregular_verbs(String v) {
        return super.check_for_irregular_verbs(v);
    }

    public String OrdinalNumbers(String c) {
        c = c.toLowerCase(Locale.ROOT);
        String[] parts = c.split(" ");
        String lastWord = parts[parts.length - 1];
        String pochti_word = c.substring(0, c.length()- lastWord.length());
        if (lastWord.equals("биир")) {
            if (pochti_word.isEmpty()) return "бастакы";
            else return pochti_word + "биирис";
        }

        if (lastWord.equals("икки")) return pochti_word + "иккис";
        if (lastWord.equals("үc")) return pochti_word +"үhүc";
        if (lastWord.equals("түөрт"))  return pochti_word + "төрдүс";
        if (lastWord.equals("биэс"))   return pochti_word +"бэhис";
        if (lastWord.equals("сэттэ"))  return pochti_word +"алтыс";
        if (lastWord.equals("аҕыс"))   return pochti_word +"ахсыс";
        if (lastWord.equals("тоҕус"))  return pochti_word +"тохсус";
        if (lastWord.equals("уон"))    return pochti_word +"онус";
        if (lastWord.equals("сүүрбэ")) return pochti_word +"сүүрбэhис";
        if (lastWord.equals("отут"))   return pochti_word +"отутус";
        if (lastWord.equals("сүүс") || lastWord.equals("тыыhынча")) return pochti_word + lastWord;
        else return "Такого числительного нет!";

    }
    public String SobirNumbers(String c, int a) {
        c = c.toLowerCase(Locale.ROOT);
        c = check_for_irregular_verbs(c);
        String[] parts = c.split(" ");
        String lastWord = parts[parts.length - 1];
        String pochti_word = c.substring(0, c.length()- lastWord.length());
        if (lastWord.equals("биэс"))  lastWord = "бэс";
        if (lastWord.equals("уон"))   lastWord = "он";
        if (lastWord.equals("түөрд")) lastWord = "төрд";
        if (lastWord.equals("биир") || lastWord.equals("сүүрбэ") || lastWord.equals("отут") || lastWord.equals("сүүc") ) {
            return c;
        }
        String g1 = dict1[Garmony(c)];
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
                break;
        }
        if (This_el(glass_letters, Character.toString(c.charAt(c.length()-1)))) {c = pochti_word+lastWord.substring(0, lastWord.length()-1)+g1;}
        else {c = upod_sogl_of_verb_and_verb_time(pochti_word+lastWord, pochti_word+lastWord+g1);}
        if (a==2) return c+"н";
        if (a==3) return c+"й"+ dict2[Garmony(c)]+"х";
        return c;
    }
    public String KratNumbers(String c) {
        c = c.toLowerCase(Locale.ROOT);
        String g1 = "т" + dict2[Garmony(c)];
        if (c.charAt(c.length()-1)=='т' && c.charAt(c.length()-2)=='р')
            return c + dict2[Garmony(c)];
        else return upod_sogl_of_verb_and_verb_time(c, c+g1);
    }
    public String RazdNumbers(String c) {
        String c2 = dict1[Garmony(c)];
        if (c.charAt(c.length()-1)=='т' && c.charAt(c.length()-2)=='р')
            return c + c2+c2;
        if (This_el(glass_letters, Character.toString(c.charAt(c.length()-1))))
            return c+"л"+c2+c2;
        else return upod_sogl_of_verb_and_verb_time(c, c+"т"+c2+c2);
    }
    public String PriblizNumbers(String c) {
        if (This_el(glass_letters, Character.toString(c.charAt(c.length()-1)))) return c+"чч"+dict2[Garmony(c)];
        else return c+"ч"+dict2[Garmony(c)];
    }

}
