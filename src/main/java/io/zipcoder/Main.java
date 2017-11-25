package io.zipcoder;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();


        ItemParser item = new ItemParser();
//        ArrayList<String> outputParse = item.parseStringIntoItem(output);
//
//        for(String itemString: outputParse){
//           System.out.println(itemString);
//       }

        // TODO: parse the data in output into items, and display to console.




    }
}
