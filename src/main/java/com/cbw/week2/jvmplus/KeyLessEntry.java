package com.cbw.week2.jvmplus;

import java.util.HashMap;

/**
 * @author chenbowen
 * @date 2021/8/14 12:27
 */
public class KeyLessEntry {
    static class Key{

        Integer id;
        Key(Integer id){
            this.id = id;
        }

        @Override
        public int hashCode(){
            return id.hashCode();
        }

    }


    public static void main(String[] args) {
        HashMap<Object, String> map = new HashMap<>(16384);
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 5; i++) {
                if(!map.containsKey(new Key(i))){
                    map.put(new Key(i),"num:"+i);
                    //System.out.println(map.keySet());
                }
            }
            System.out.println("size:["+ map.size()+"] ");
        }

//        Integer a = 1;
//        map.put(new Key(a),"1");
//
//        Integer b = 1;
//        int j = new Key(b).hashCode();
//
//
//        System.out.printf(String.valueOf(map.containsKey(new Key(b))));
//        System.out.printf(String.valueOf(a.hashCode()));
//        System.out.printf(String.valueOf(b.hashCode()));




    }
}
