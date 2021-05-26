package DataLayer;

import BusinessLayer.BaseProduct;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
public class CSVReader {
    private final String PATH = "/Users/emili/Desktop/__FACULTATE___/AN 2 Sem 2/TP/Tema 4/products.csv";
    private List<BaseProduct> productsList ;
    private Set<String> checkDuplicates ;
    private int id = 0;
    public CSVReader(List<BaseProduct> productsList , Set<String> checkDuplicates){
        this.productsList = productsList;
        this.checkDuplicates = checkDuplicates ;
    }

    public void readFromCSV()
    {
        List<String> lines  ;
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH));
            lines = br.lines().skip(1).collect(Collectors.toList()); /// collect a list of lines from csv
            lines = lines.stream().distinct().collect(Collectors.toList()); // eliminate duplicate lines

            productsList = lines.stream().distinct().map((currentRow)-> {
                String[] columns = currentRow.split(",");
                if (checkDuplicates.add(columns[0])){
                    BaseProduct newBaseProduct = new BaseProduct(id,columns[0] ,Float.parseFloat(columns[1]), Integer.parseInt(columns[2])
                            ,Integer.parseInt(columns[3]) ,Integer.parseInt(columns[4]) ,Integer.parseInt(columns[6]) ,Integer.parseInt(columns[6]));
                    id++;
                    return newBaseProduct;
                }
                else
                    return null ;

            }).collect(Collectors.toList());
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        productsList.removeIf(Objects::isNull); /// remove items from list that are null
        productsList.forEach(System.out::println);
    }

    public List<BaseProduct> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<BaseProduct> productsList) {
        this.productsList = productsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
