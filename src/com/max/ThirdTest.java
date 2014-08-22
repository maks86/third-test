/*Разработать класс, позволяющий работать с табличными данными.
Каждая строка таблицы представляется в виде объекта Map.
Каждая колонка таблицы характеризуется строковым названием (ключ объекта Map)
Добавлять строки в данную таблицу можно с помощью метода add(Map map)
Для данной таблицы должно быть возможно указывать порядок сортировки по заданной колонке
Должен быть реализован механизм    разбиения данной таблицы на страницы с заданным количество строк
(должно возвращаться общее количество страниц и получение итератора на данную страницу).
К реализации написать тесткейсы с помощью JUnit и консольный интерфейс с примером использования*/
package com.max;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Table implements ITable {
    List<Map<String, String>> maps  = new LinkedList<Map<String, String>>();
    @Override
    public void add(Map<String,String> row) {
           maps.add(row);
        for (Map.Entry<String, String> me : row.entrySet()) {
             System.out.print(me.getKey() + ": ");
             System.out.println(me.getValue());
        }
//        String value = map.get(key);
//       System.out.println("value="+value);
//        map.put(key, value + "!!!!");
//        System.out.println(key +"="+ map.get(key);
    }
    @Override
    public void sort(String sortBy) {
        System.out.println("Sorting in the " + sortBy + " :");
        List <String> str=new ArrayList<String>();
        for (Map<String, String> pair : maps) {
            if (pair.containsKey(sortBy)) {
                System.out.println(sortBy +" contains:" + pair.values());
                str.add(String.valueOf(pair.values()));
                Collections.sort(str);
            }
        }System.out.println("sort=" + str);
        System.out.println("-------------");
    }
    @Override
    public int size() {
        System.out.println("maps.size()="+maps.size());
        System.out.println("-------------");
        return maps.size();
    }

    @Override
    public void getPage(int page, int el) {
//        entryList = new ArrayList(map.entrySet());
//        Collections.sort(entryList, new Comparator() {
//            public int compare(Object o1, Object o2) {
//                Map.Entry e1 = (Map.Entry) o1;
//                Map.Entry e2 = (Map.Entry) o2;
//                Comparable c1 = (Comparable) e1.getValue();
//                Comparable c2 = (Comparable) e2.getValue();
//
//                return c1.compareTo(c2);
//            }
//        });
        System.out.println("Pagination Value:");
        int mapsSize = maps.size();
        double allPage = Math.ceil((double)mapsSize/page);//по allPage(строк) на 1 стр.

        if (mapsSize < page){ // просто вывести...
            for (int i=0; i<mapsSize; i++){
                System.out.println(maps.get(i));
            }
        }
        if (allPage<el){
            System.out.println("Cause is not possible, Maximum number of items per page: " + allPage);
        }
        else{
            if (mapsSize >= page){
                System.out.println("Total number of pages: " + mapsSize);
                System.out.println("Possible to infer on " + page + " page " + el + " elements");
            }System.out.println("-------------");
        }
    }
    @Override
    public void getPageIterator(int page, int el) {
        int mapsSize = maps.size();
        int count=0;
        double allPage = Math.ceil((double)mapsSize/page);//по allPage(строк) на 1 стр.

        if (mapsSize < page){ // simply print the contents of
            for (int i=0; i<mapsSize; i++){
                System.out.println(maps.get(i));
            }
        }
        if (allPage<el){
            System.out.println("Cause is not possible, Maximum number of items per page: " + allPage);
        }
        else{
            if (mapsSize >= page){
                count = (el*page)-el;
                System.out.println("Output begins with " + (count+1) + " element ");
                for (int i=0; i<el; i++){
                    System.out.println(maps.get(count));
                    count++;
                    if (count==maps.size()){
                        return;
                    }
                }
            }
        }
    }
}
public class ThirdTest{
    public static void main(String[] args) {
        Map<String,String> row1=new HashMap<String, String>();
        row1.put("column1","row1");

        Table table=new Table();
        table.add(row1);

        Map<String,String> row2=new HashMap<String, String>();
        row2.put("column2","row2");
        table.add(row2);

        Map<String,String> row3=new HashMap<String, String>();//можно убрать...
        row3.put("column1","row3");
        table.add(row3);

        table.size();

        table.sort("column1");

        table.getPage(3,1);//page, el
        table.getPageIterator(3,1);
    }
}/*
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
	}}
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
boolean equals(Object o)  - проверяет эквивалентность двух пар
Object getKey() – возвращает ключ пары.
Object getValue() – возвращает значение пары.
Object setValue(Object value) – изменяет значение пары
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
************************************************************************************************************
*/