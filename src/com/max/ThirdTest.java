package com.max;
import java.util.*;
import java.util.Comparator;
import java.util.Collections;
class StringLengthComparator implements Comparator<String>{
    @Override
    public int compare(String s1,String s2){
        int len1=s1.length();
        int len2=s2.length();

        if (len1>len2){
            return 1;
        }
        else if (len1<len2){
            return -1;
        }
        return 0;
    }
}
public class ThirdTest{

    public static void main( String[] args ){

        LinkedHashMap<String, ArrayList> map = new LinkedHashMap<String, ArrayList>();
        ArrayList<String> te = new ArrayList<String>();
        ArrayList<String> tes = new ArrayList<String>();
        ArrayList<String> test = new ArrayList<String>();
        map.put("one column", te );
        map.put("two column", tes);
        map.put("three column", test);

        test.add("second string");
        test.add("first string"); //добавление по ссылке

        map.get("one column").add("first string");//добавление по ключу
        map.get("two column").add("first string");
        map.get("three column").add("third string");
        System.out.println(map);
        Collections.sort(test);                                //простая сортировка
        Collections.sort(test,new StringLengthComparator());   //ортировка по длинне строк
        for (String t : test){
            System.out.println(t);
        }
        System.out.println();
        Iterator iterator = te.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //разбиения данной таблицы на страницы с заданным количество строк пока не получается придумать...
    }
}





