import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import DataLayer.CSVReader;
import PresentationLayer.Controller.CompositeController;
import PresentationLayer.View.ClientView;
import PresentationLayer.View.CompositeProductView;
import PresentationLayer.View.RaportView;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        BaseProduct bp1 = new BaseProduct(1,"asd" , 2,3,33,4,5,2);
        BaseProduct bp5 = new BaseProduct(4,"asd" , 2,3,33,4,5,2);
        BaseProduct bp2 = new BaseProduct(3,"asd" , 2,3,33,4,5,2);
        BaseProduct bp3 = new BaseProduct(2,"asd" , 2,3,33,4,5,2);

        int [] date = new int[3];
        date[0] = 1 ;
        date[1] = 2 ;
        date[2] = 3 ;
        List<MenuItem> list = new ArrayList<>();
        list.add(bp1);
        list.add(bp2);
        list.add(bp3);
        list.add(bp5);
        Calendar calendar = Calendar.getInstance();
        Order order = new Order(1,2,calendar);
        Map<Order,List<MenuItem>> productsMap = new HashMap<>();
        productsMap.put(order,list);


        BaseProduct bp11 = new BaseProduct(1,"vasd" , 22,3,33,4,5,2);
        BaseProduct bp55 = new BaseProduct(4,"vasd" , 32,3,33,4,5,2);
        BaseProduct bp22= new BaseProduct(3,"vasd" , 42,3,33,4,5,2);
        BaseProduct bp33 = new BaseProduct(2,"vasd" , 52,3,33,4,5,2);


        List<MenuItem> list1 = new ArrayList<>();
        list1.add(bp11);
        list1.add(bp22);
        list1.add(bp33);
        list1.add(bp55);

        Order order1 = new Order(2,2,calendar);
        productsMap.put(order1,list1);

        System.out.println(productsMap);
        for(Order i : productsMap.keySet())
        {
            System.out.println(productsMap.get(i));
        }
        System.out.println("@@");
        productsMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "\n " + entry.getValue());
        });
    }
}

