package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap <String, Integer> map = new HashMap<>();
        FileReader file = new FileReader( "C:\\Users\\shafi\\OneDrive\\Desktop\\TextFile.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        while (line!=null){
            String s= line.toLowerCase();
            String a= s.replaceAll(",","");
            if (!line.trim().equals("")){
                String [] words = a.split(" ");

                for (String word: words){
                    if (map.containsKey(word)){
                        map.put(word,map.get(word)+1);

                    }else {
                        map.put(word, 1);
                    }
                }
            }

            line = reader.readLine();
        }

        HashMap <String, Integer> sortedmap = sortByValue(map);

        for (Map.Entry<String,Integer> a: sortedmap.entrySet()){
            System.out.println(a.getValue()+ ": "+ a.getKey());
        }

        }

    public static HashMap<String, Integer> sortByValue (HashMap<String, Integer> hmap){
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hmap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp= new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry: list){
            temp.put(entry.getKey(),entry.getValue());
        }
        return temp;
    }

}
