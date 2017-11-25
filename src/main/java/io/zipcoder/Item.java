package io.zipcoder;

public class Item {
    private String name;
    private Double price;
    private String type;
    private String expiration;

    public Item(String name){
        this.name = name;
    }
//
//    public Item(String name, Double price, String type, String expiration){
//        this.name = name;
//        this.price = price;
//        this.type = type;
//        this.expiration = expiration;
//    }

    public String getName() {
        return name;
    }


    public Double getPrice() {
        return price;
    }


    public String getType() {
        return type;
    }


    public String getExpiration() {
        return expiration;
    }

//    public boolean equals(Object o ){
//
//        return((Item)o).name.equals(this.name);
//    }
//
//    public int hashCode(){
//        return name.length();
//    }

//public String toString(){
//
//        return name + "Item:";
//    }
    @Override
    public String toString(){
        return "name:" + name + " price:" + price + " type:" + type + " expiration:" + expiration;
    }
}
