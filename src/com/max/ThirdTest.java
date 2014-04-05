/*Разработать класс, позволяющий работать с табличными данными.
Каждая строка таблицы представляется в виде объекта Map.
Каждая колонка таблицы характеризуется строковым названием (ключ объекта Map)
Добавлять строки в данную таблицу можно с помощью метода add(Map map)
Для данной таблицы должно быть возможно указывать порядок сортировки по заданной колонке
Должен быть реализован механизм разбиения данной таблицы на страницы с заданным количество строк
(должно возвращаться общее количество страниц и получение итератора на данную страницу).
К реализации написать тесткейсы с помощью JUnit и консольный интерфейс с примером использования
*/
package com.max;
import java.util.*;
class Employee implements Comparable<Employee>{
    private String name; // имя
    private int salary; // зарплата
    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    public String toString(){
        return name+","+salary;
    }
    public int compareTo(Employee obj){
        // Задает функцию сравнения объектов по зарплате
        int otherSalary = ((Employee)obj).getSalary();
        if (salary == otherSalary)
            return 0;
        else
            return (salary > otherSalary) ? 1 : -1;
    }
    public int getSalary(){
        return salary;
    }
    public static void main(String[] args) {
        Set emps = new TreeSet();
        emps.add(new Employee("Vasya", 500));
        emps.add(new Employee("Sanya", 1000));
        emps.add(new Employee("Petya", 300));
        System.out.println(emps);

        List<String> staff=  new LinkedList<String>();
        staff.add("first column ");
        staff.add("second column ");
        staff.add("third column ");
        ListIterator<String> iterator=staff.listIterator();
        iterator.next();
        iterator.add("7777");
        System.out.println(staff);
    }
}
