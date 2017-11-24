package com.satellite;

import com.example.UserExample;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Satellite<T> extends Linker {

    private List<T> pendingList;

    public Satellite(String hostIp, String hostName, String hostPassword) {
        super(hostIp, hostName, hostPassword);
        pendingList = new ArrayList<T>();

    }

    public void create(T t) {
        pendingList.add(t);
    }

    public T read(int i) {
        return pendingList.get(i);
    }

    public void update(int t) {

    }

    public void delete(T t) {
        pendingList.remove(t);
    }

    public void printClassInformation(T t) {
        try {
            UserExample test = new UserExample("",2);

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
