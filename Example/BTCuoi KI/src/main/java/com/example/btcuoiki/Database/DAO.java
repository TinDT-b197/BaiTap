package com.example.btcuoiki.Database;

import com.example.btcuoiki.Order;
import com.example.btcuoiki.Product;

import java.util.ArrayList;

public interface DAO<T> {
    public int Add(T t);

    public int Remove(T t);
    public int Update(T t);
    public ArrayList<T> selectAll();

}
