package com.example.kali.test2;
//
///**
// * Created by root on 9/14/16.
// */
//public class Product
//{
//    private int _id;
//    private String _productname;
//
//    public Product (){
//
//    }
//
//    public Product(String _productname) {
//        this._productname = _productname;
//    }
//
//    public void set_id(int _id) {
//        this._id = _id;
//    }
//
//    public void set_productname(String _productname) {
//        this._productname = _productname;
//    }
//
//    public int get_id() {
//        return _id;
//    }
//
//    public String get_productname() {
//        return _productname;
//    }
//}
public class Product {
    private int _id;
    private String _productname;

    //Added this empty constructor in lesson 50 in case we ever want to create the object and assign it later.
    public Product(){

    }
    public Product(String productName) {
        this._productname = productName;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_productname() {
        return _productname;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }
}