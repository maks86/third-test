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

    class Table  {
       public String column;
       public String line;

        Table(String column, String line) {
            this.column = column;
            this.line = line;
        }
        public String getLine(){
            return line;
        }

        public void add(String a,String b){
            this.column=a;
            line+=" "+b;
        }
    }
public class ThirdTest{
    public static void main(String[] args) {
        Table table=new Table("123","321");
        Table table1=new Table("12345","54321");
        table.add("123","555654654");
        table.add("123","77777");
        table1.add("13456","654321");

        String maks=table.getLine();
        System.out.println(maks);
    }
}







/*
************************************************************************************************************
//массив объектов
int[] a = new int[] {1, 2};
//перебор элементов
for (int i = 0; i < myArray.length; i++) {
for (long val : myArray)

Collection – группа объектов, Map – ассоциативный массив объектов
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	map.put(5, 42);
	System.out.println(map.get(new Integer(5)));
//List – упорядоченный список; Set – множество
ArrayList массив; LinkedList двусвязный список
//По умолчанию при создании нового объекта ArrayList создается внутренний массив длиной 10 элементов
List l = new ArrayList();
//Доступ к элементам списка
по индексу
for (int i = 0; i < list.size(); i++){
	MyClass elem = (MyClass)list.get(i); // Коллекция не типизированная
	elem.doSome();
}
//при большом количестве объектов Итератор – это вспомогательный объект
boolean hasNext() – проверяет  есть ли еще элементы в коллекции
Object next() – выдает  очередной элемент коллекции
void remove() – удаляет  последний выбранный элемент из коллекции
//Получить итератор
с помощью метода iterator()
for (Iterator iter = collection.iterator(); iter.hasNext();) {
            MyClass element = (MyClass) iter.next();
            element.doSome();}
//ArrayList реализует интерфейс java.util.RandomAccess
операции по произвольному доступу к нему осуществляются быстрее
//Добавить и взять значения
 ArrayList list = new ArrayList();
     for (int i=0; i<100000; i++)
       list.add(i);
     long a = System.currentTimeMillis();
     for (int i=0, n=list.size(); i < n; i++)
         list.get(i);
     System.out.println(System.currentTimeMillis()-a);
     a = System.currentTimeMillis();
     for (Iterator i=list.iterator(); i.hasNext(); )
         i.next();
     System.out.println(System.currentTimeMillis()-a);
//Добавить и взять значения
LinkedList list2 = new LinkedList();
     for (int i=0; i<100000; i++)
       list2.add(i);
     a = System.currentTimeMillis();
     for (int i=0, n=list2.size(); i < n; i++)
         list2.get(i);
     System.out.println(System.currentTimeMillis()-a);
     a = System.currentTimeMillis();
     for (Iterator i=list2.iterator(); i.hasNext(); )
         i.next();
     System.out.println(System.currentTimeMillis()-a);
//HashSet произвольном порядке, LinkedHashSet в порядке их добавления
//Set sorted = new TreeSet();
sorted.add(new Integer(2));
sorted.add(new Integer(3));
sorted.add(new Integer(1));
System.out.println(sorted); // Распечатает [1, 2, 3]
//Пример с использованием Comparable(сравнения объектов по зарплате
public class Employee implements Comparable{
	private String name; // имя
	private int salary; // зарплата
	…
	public int compareTo(Object obj){
		// Задает функцию сравнения объектов по зарплате
		int otherSalary = ((Employee)obj).getSalary();
		if (salary == otherSalary)
			return 0;
		else
			return (salary > otherSalary) ? 1 : -1;
	}

	public static void main(String[] args) {
		Set emps = new TreeSet();
		emps.add(new Employee("Vasya", 500));
		emps.add(new Employee("Sanya", 1000));
		emps.add(new Employee("Petya", 300));
		System.out.println(emps); // Распечатает [Petya: 300, Vasya: 500, Sanya: 1000]
	}
}
//когда compareTo() переопределен но еще сортировка
создается класс реализующий интерфейс Comparator, и уже на основании объекта сортировка
реализовать метод compare(Object o1, Object o2)
//Map <ключ, значение>
public void put(Object key, Object value) - добавляет новую пару <ключ, значение>
public Object get(Object key) – возвращает value по заданному ключу, или null, если ничего не найдено
public Set keySet() – возвращает множество ключей
boolean	containsKey(Object key) – возвращает true, если Map содержит пару с заданным ключем
//LinkedHashMap в порядке их добавления
//использованием HashMap
Map<String, String> map = new HashMap <String, String>();
   // Заполнить его чем-нибудь
   map.put("one", "111");
   map.put("two", "222");
   map.put("three", "333");
   map.put("four", "333");
  // Получить и вывести все ключи
  System.out.println("Set of keys: " + map.keySet());
   // Получить и вывести значение по ключу
   String val = map.get("one");
   System.out.println("one=" + val);
   // Получить и вывести все значения
  System.out.println("Collection of values: " + map.values());
   // Получить и вывести все пары
  System.out.println("Set of entries: " + map.entrySet());

//Map.Entry позволяет работать с объектом, который представляет собой пару <ключ, значение>
boolean equals(Object o)  - проверяет эквивалентность двух пар
Object getKey() – возвращает ключ пары.
Object getValue() – возвращает значение пары.
Object setValue(Object value) – изменяет значение пары
Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		// …
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
//Создание заполненного списка:
List myList = Arrays.asList(new String[] {"1", "2", "3"});
Получение массива объектов списка:
Object[] arr = myList.toArray();
создает массив типа Object[] и копирует в него все элементы
String[] strings = (String [])myList.toArray(new String[myList.size()])
копирует элементы в переданный массив и возвращает его
*************************************************************************************************************



  Map<String,ArrayList<String>> map= new HashMap<String, ArrayList<String>>();
        map.put("111", new ArrayList<String>());
        map.put("222", new ArrayList<String>());
        map.put("333", new ArrayList<String>());
        map.put("444", new ArrayList<String>());
        System.out.println(map);
        map.remove("222"); //удалить
        //staff.put("444",new Table("Francesca Miller"));
       // System.out.println(staff.get("444"));
        for (Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
            String key=entry.getKey();
            ArrayList value=entry.getValue();
            System.out.println("key="+key+", value="+value);
        }

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
        Collections.sort(test, new StringLengthComparator());   //sorting by string length
        for (String t : test) {
            System.out.println(t);
        }
        System.out.println("---------------------");
  }
*/










