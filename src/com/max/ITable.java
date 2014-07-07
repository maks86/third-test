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

    void add(Map<String, String> row);

    void sort(String sortBy);

    int size();

    List<Map<String, String>> getPage(int page, int pageSize);

    Iterator<Map<String, String>> getPageIterator(int page, int pageSize);

}
