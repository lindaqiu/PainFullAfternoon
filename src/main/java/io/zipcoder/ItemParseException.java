package io.zipcoder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemParseException extends Exception {

    Logger logger = Logger.getLogger("io.zipcoder");

    public ItemParseException(){
            logger.setLevel(Level.ALL);
          }


}




//forgot "private static final  Logger logger = Logger.getLogger("io.zipcoder");" for classes with a lot of logging activity


//log... memory of how many items have failed