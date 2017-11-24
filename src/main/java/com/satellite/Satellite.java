package com.satellite;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Satellite<T> {

    private List<T> pendingList;
    private Linker linker;

    public Satellite(String hostIp, String hostName, String hostPassword) {
        linker = new Linker(hostIp, hostName, hostPassword);
        pendingList = new ArrayList<T>();

    }

    public void insert(T t) {
        pendingList.add(t);
    }

    public void insertNow(T t) {// Bypass le pending et va directement dans la db
    }

    public T read(int i) {
        return pendingList.get(i);
    }

    public void update(int t) {
    }

    public void updateNow(int t) {// Bypass le pending et va directement dans la db
    }

    public void delete(T t) {
        pendingList.remove(t);
    }

    public void deleteNow(T t) {// Bypass le pending et va directement dans la db
    }

    // Envoie toute les modifications au serveur
    public void push() {

    }











    public void printClassInformation(T t) {
        try {
            for(Field field : t.getClass().getDeclaredFields()){
                Class type = field.getType();
                String name = field.getName();
                Annotation[] annotations = field.getDeclaredAnnotations();

                System.out.println(type);
                System.out.println(name);

                System.out.println(Arrays.toString(annotations));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}