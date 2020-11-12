package com.genta.myapplication.server;

public class BaseURL {
    public static String baseUrl = "http://192.168.43.11:5050/";

    public static String login = baseUrl + "user/login";
    public static String register =  baseUrl + "user/registrasi";

    //kacamata
    public static String dataKacamata = baseUrl +"kacamata/datakacamata";
    public static String editDataKacamata = baseUrl +"kacamata/ubah/";
    public static String hapusData = baseUrl +"kacamata/hapus/";
    public static String inputKacamata = baseUrl +"kacamata/input";
}
