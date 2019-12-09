package com.hw.test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public class Question1 {

    //1.使用延迟加载
    static class Singleton1{
        private static volatile Singleton1 s;
        private Singleton1() {}
        public Singleton1 getSingleton(){
            if (s == null){
                synchronized (Singleton1.class){
                    if (s == null){
                        s = new Singleton1();
                    }
                }
            }
            return s;
        }
    }
    //2.利用内部类
    static class Singleton2 {
        private static  class SingletonHolder{
            public static Singleton2 s = new Singleton2();
        }

        public static Singleton2 getSingleton(){
            return SingletonHolder.s;
        }
    }



}
