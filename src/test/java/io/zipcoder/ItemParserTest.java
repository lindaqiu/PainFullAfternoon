package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemParserTest {

    private String nothing = "";
    private String rawSingleItem =    "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";

    private String rawSingleItemIrregularSeperatorSample = "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
    //instead of semi-colon separating keys its a carrot

    private String rawBrokenSingleItem =    "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";


    private String rawMultipleItems = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##"
                                      +"naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##"
                                      +"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
    private ItemParser itemParser;


    @Before
    public void setUp(){
        itemParser = new ItemParser();
    }

    @Test
    public void parseRawDataIntoStringArrayTest(){
        Integer expectedArraySize = 3;
        ArrayList<String> items = itemParser.parseRawDataIntoStringArray(rawMultipleItems);
        Integer actualArraySize = items.size();
        assertEquals(expectedArraySize, actualArraySize);
    }

//    @Test
//    public void parseStringIntoItemTest() throws ItemParseException{
//        Item expected = new Item("milk", 3.23, "food","1/25/2016");
//        Item actual = itemParser.parseStringIntoItem(rawSingleItem);
//        assertEquals(expected.toString(), actual.toString());
//    }

    @Test
    public void getStringValuePairTest(){
    String expected = "name:milk";
    String actual = itemParser. getStringValuePair(rawSingleItem);
    Assert.assertEquals(expected,actual);
    }

    @Test
    public void getStringValueAndItem(){
        String expected = "milk";
        String actual = itemParser.getStringValueAndItem(rawSingleItem);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void namePatternMatcherTest(){
        boolean expected = true;
        boolean actual =itemParser.namePatternMatcher(rawSingleItem);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void namePatternMatcherFalseTest() {
        boolean expectedName = false;
        boolean actualName = itemParser.namePatternMatcher(nothing);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void pricePatternMatcherTest(){
        boolean expected = true;
        boolean actual = itemParser.pricePatternMatcher(rawSingleItem);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void pricePatternMatcherFalseTest(){
        boolean expectedPrice = false;
        boolean actualPrice = itemParser.namePatternMatcher(nothing);
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void typePatternMatcherTest(){
        boolean expected = true;
        boolean actual = itemParser.typePatternMatcher(rawSingleItem);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void typePatternMatcherFalseTest(){
        boolean expectedType = false;
        boolean actualType = itemParser.typePatternMatcher(nothing);
        Assert.assertEquals(expectedType, actualType);
    }

    @Test
    public void expirationPatternMatcherTest(){
        boolean expected = true;
        boolean actual = itemParser.expirationPatternMatcher(rawSingleItem);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void expirationPatternMatcherFalseTest(){
        boolean expectedExpiration = false;
        boolean actualExpiration = itemParser.expirationPatternMatcher(nothing);
        Assert.assertEquals(expectedExpiration,actualExpiration);
    }


//    @Test
//            (expected = ItemParseException.class)
//    public void parseBrokenStringIntoItemTest() throws ItemParseException{
//        itemParser.parseStringIntoItem(rawBrokenSingleItem);
//    }

    @Test
    public void findKeyValuePairsInRawItemDataTest()throws ItemParseException{
        Integer expected = 4;
        Integer actual = itemParser.findKeyValuePairsInRawItemData(rawSingleItem).size();
        assertEquals(expected, actual);
    }

    @Test
    public void findKeyValuePairsInRawItemDataTestIrregular()throws ItemParseException{
        Integer expected = 4;
        Integer actual = itemParser.findKeyValuePairsInRawItemData(rawSingleItemIrregularSeperatorSample).size();
        assertEquals(expected, actual);
    }
}
