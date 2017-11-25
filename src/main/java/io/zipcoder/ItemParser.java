package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class ItemParser {

    //public static Integer errorCount;


    public ArrayList<String> parseRawDataIntoStringArray(String rawData) {
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern, rawData);
        return response;
    }

//    public Item parseStringIntoItem(String rawItem) throws ItemParseException {
//return new Item(name, Double.parseDouble(price), type, expiration);
//
//    }



public String getStringValuePair(String rawItem){
    ArrayList<String> toFind = findKeyValuePairsInRawItemData(rawItem);
    String toReturn = toFind.get(0).toLowerCase();
    return toReturn;
}

    public String getStringValueAndItem(String rawItem){
        ArrayList<String> name = new ArrayList<String>();
        if(namePatternMatcher(rawItem)){
            ArrayList<String>keyValue =findKeyValuePairsInRawItemData(rawItem);
            name = splitStringWithRegexPattern(":", keyValue.get(0));
        }
        return name.get(1).toLowerCase();
    }




        public boolean namePatternMatcher(String rawItem){

        String regexName = "n..e:\\w+;";
        Pattern patternName = Pattern.compile(regexName, Pattern.CASE_INSENSITIVE);
        Matcher nameMatcher = patternName.matcher(rawItem);
        return nameMatcher.find();
    }


    public boolean pricePatternMatcher(String rawItem){
        String regexPrice = "p...e:\\d...";
        Pattern patternPrice = Pattern.compile(regexPrice, Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = patternPrice.matcher(rawItem);
        return priceMatcher.find();

    }


    public boolean typePatternMatcher(String rawItem){
        String regexType = "t..e:\\w...";
        Pattern patternType = Pattern.compile(regexType, Pattern.CASE_INSENSITIVE);
        Matcher typeMatcher = patternType.matcher(rawItem);
        return typeMatcher.find();

    }

    public boolean expirationPatternMatcher(String rawItem){
        String regexExpiration = "e........n:\\d.......6";
        Pattern patternExpiration = Pattern.compile(regexExpiration, Pattern.CASE_INSENSITIVE);
        Matcher expirationMatcher = patternExpiration.matcher(rawItem);
        return expirationMatcher.find();
    }

    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;|^]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }



}
