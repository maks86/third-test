/*Разработать класс, позволяющий работать с табличными данными.
Каждая строка таблицы представляется в виде объекта Map.
Каждая колонка таблицы характеризуется строковым названием (ключ объекта Map)
Добавлять строки в данную таблицу можно с помощью метода add(Map map)
Для данной таблицы должно быть возможно указывать порядок сортировки по заданной колонке

Должен быть реализован механизм разбиения данной таблицы на страницы с заданным количество строк
(должно возвращаться общее количество страниц и получение итератора на данную страницу).
К реализации написать тесткейсы с помощью JUnit и консольный интерфейс с примером использования*/
package com.max;
import java.util.*;
import java.util.Comparator;
import java.util.Collections;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return 1;
        } else if (len1 < len2) {
            return -1;
        }
        return 0;

    }
    public static void main(String[] args) {
        LinkedHashMap<String, ArrayList> map = new LinkedHashMap<String, ArrayList>();
        ArrayList<String> page1 = new ArrayList<String>();
        ArrayList<String> page2 = new ArrayList<String>();
        ArrayList<String> page3 = new ArrayList<String>();
        map.put("one column", page1);
        map.put("two column", page2);
        map.put("three column", page3);

        page1.add("second string1");
        page1.add("third string1");

        page2.add("second string2");
        page2.add("third string2");

        page3.add("second string3");
        page3.add("first string3"); //adding link

        page1.add("first string1"); //adding at key
        page2.add("first string2");
        page3.add("third string3");
        System.out.println(map);
        Collections.sort(map.get("three column"));      //sorting by column (by the specified key)
        Collections.sort(page1);                         //Sorting link
        Collections.sort(page2);
        System.out.println(page1);
        System.out.println(page2);
        System.out.println(page3);
       /* Collections.sort(test, new StringLengthComparator());   //sorting by string length
        for (String t : test) {
            System.out.println(t);
        }*/
        System.out.println("---------------------");

        //разбиения данной таблицы на страницы с заданным количество строк пока не получается придумать...
        System.out.println("Number of pages in map is "+map.size());
        int count=0;
        for (String element : page1){
                if (count<2){
                System.out.println(element);
                count++;
                }
            }
        System.out.println("-----------");
        System.out.println("Set of entries: " + map.entrySet());

        //с массивом связать...
 }
 }









