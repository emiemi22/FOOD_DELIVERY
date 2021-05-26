import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.Order;
import DataLayer.CSVReader;
import PresentationLayer.Controller.CompositeController;
import PresentationLayer.View.ClientView;
import PresentationLayer.View.CompositeProductView;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        //date.set(1900,23,3,3,3);
        System.out.println(date.getTime());
        Order order1 = new Order(1,2,date);
        order1.printOrderDate();
    }
}
