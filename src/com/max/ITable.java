package com.max;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * .
 *
 * @author Maksym_Mukhanov
 */
public interface ITable {

    void add(Map<String,String> row);

    void sort(String sortBy);

    int size();

    void getPage(int page, int el);

    void getPageIterator(int page, int el);

}
