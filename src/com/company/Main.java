package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("From which file do you want to load this information?");
        String fileName=scan.next();
        System.out.println("Data loaded.");
        System.out.println("Data sorted.");
        List<String> cars = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<String> year=new ArrayList<>();
        List<String> sortedList=new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get("src/com/company/"+fileName))) {

              cars = stream.filter(line -> line.startsWith("\tMake: ") || line.startsWith("\tModel: ") || line.startsWith("\tYear: ") || line.startsWith("\tLicense: ") ).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cars);
         for (int i=0; i<cars.size(); i=i+4){
             Car record=
                     new Car(cars.get(i).substring(7),
                             cars.get(i+1).substring(8),
                             Integer.parseInt(cars.get(i+2).substring(7)),
                             cars.get(i+3).substring(10));
         list.add(record.toString());
         year.add(cars.get(i+2).substring(7));

         }
        Collections.sort(year);

        for (int i=0;i<year.size();i++)
        {
            for(int j=0; j<year.size(); j++){
                if (list.get(j).contains(year.get(i)))  {
                    sortedList.add(list.get(j));
                }
            }
//-----------------------------------------------------------
        }
        System.out.println(sortedList);
    }
}
