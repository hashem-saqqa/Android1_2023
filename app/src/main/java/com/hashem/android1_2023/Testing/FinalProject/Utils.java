package com.hashem.android1_2023.Testing.FinalProject;

import android.content.Context;

import java.util.ArrayList;

public class Utils {
    public static final ArrayList<User> users = new ArrayList<>();
    public static String strSeparator = "__,__";

    public static void generateData(Context context){

        MyDataBase db = new MyDataBase(context);
//        users.add(new User(120180001,2,"s1","123456","Ahmed Ali","1/1/2000","Male"));
//        users.add(new User(120190001,2,"s2","123456","Heba Ahmed","1/1/2001","Female"));
//        users.add(new User(120100001,2,"s3","123456","Dalia Mohammed","1/1/2002","Female"));
//
//        users.add(new User(1,"jafarAgha","112233","Jafar Al-Agha","1/1/1997","Male",2000,"Eng"));
//        users.add(new User(1,"MohDalo","112233","Mohammed Al-Dalo","1/1/1998","Male",1000,"Eng"));
//        users.add(new User(1,"EtafHadda","112233","Etaf Abu Hadda","1/1/1999","female",3000,"Eng"));
//        users.add(new User(1,"HashemSaqqa","112233","Hashem Al-Saqqa","1/1/2000","Male",1500,"IT"));

        db.insertUser(new User(120180001,2,"s1","123456","Ahmed Ali","1/1/2000","Male"));
        db.insertUser((new User(120190001,2,"s2","123456","Heba Ahmed","1/1/2001","Female")));
        db.insertUser(new User(120100001,2,"s3","123456","Dalia Mohammed","1/1/2002","Female"));

        db.insertUser(new User(1,"jafarAgha","112233","Jafar Al-Agha","1/1/1997","Male",2000,"Eng"));
        db.insertUser(new User(1,"MohDalo","112233","Mohammed Al-Dalo","1/1/1998","Male",1000,"Eng"));
        db.insertUser(new User(1,"EtafHadda","112233","Etaf Abu Hadda","1/1/1999","female",3000,"Eng"));
        db.insertUser(new User(1,"HashemSaqqa","112233","Hashem Al-Saqqa","1/1/2000","Male",1500,"IT"));

        db.insertQuestion(new Question(1,1,"Does Java can build GUI?",2,null,"Yes"));
        db.insertQuestion(new Question(2,1,"Java doesn't support OOP?",2,null,"Yes"));
        db.insertQuestion(new Question(3,2,"Which Type is not primitive",2,null,
                "0",new String[]{"String","int","double","char"}));
        db.insertQuestion(new Question(4,2,"Which class is super class for all classes",2,null,
                "1",new String[]{"String","Object","number","Exception"}));
        db.insertQuestion(new Question(5,3,"What is the keywords that used to call super class constructor? ",
                2,null,"super"));
        db.insertQuestion(new Question(6,3,"What is the keywords that used to inherit from a class?",
                2,null,"extends"));

    }
    public static String convertArrayToString(String[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str = str + array[i];
            // Do not append comma at the end of last element
            if (i < array.length - 1) {
                str = str + strSeparator;
            }
        }
        return str;
    }

    public static String[] convertStringToArray(String str) {
        String[] arr = str.split(strSeparator);
        return arr;
    }
    public static int[] stringToIntegerArray(String[] arr){
        int [] intArr = new int [arr.length];
        for (int i = 0; i < arr.length ; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }
    public static String[] intToStringArray(int[] arr){
        String [] strArr = new String [arr.length];
        for (int i = 0; i < arr.length ; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }
        return strArr;
    }
}
