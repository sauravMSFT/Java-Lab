package com.lab.model;

/**
 * Created by saurav on 23/10/16.
 */

/**
 * Interface to support comparison of objects for the purpose
 * of sorting and searching.
 * @param <T>
 */
public interface IComparable<T>
{
    int compareTo(T other);
}
