package com.liufan;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myClass {
    public static void main(String args[]) {
        /*String allString = "12pag/abc";
        String regEx="[^0-9]";
        Pattern p   =   Pattern.compile(regEx);
        Matcher m   =   p.matcher(allString);
        System.out.print(".............."+m.replaceAll("").trim());*/
      /*  StringBuffer var1 = new StringBuffer();
        Map<String,String> aMap = new HashMap<>();
        aMap.put("a","aaaaa");
        aMap.put("b","bbbbb");
        aMap.put("c","ccccc");

        for (Map.Entry<String, String> entry : aMap.entrySet()){

            System.out.println("key= " + entry.getKey() + " and value= "+ entry.getValue());
            var1.append(entry.getKey());
            var1.append(":");
            var1.append(entry.getValue());
            var1.append("\n");

        }
        System.out.print(var1.toString());*/
//        new Gson().toJson(aMap);
//        System.out.print(".............."+new Gson().toJson(aMap));
        String uri = "storage/emulated/0/server.log.5";
        String [] abc = uri.split("/");///
        System.out.print(".............."+abc[abc.length-1]);
    }
}
