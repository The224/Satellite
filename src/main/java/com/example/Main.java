package com.example;

import com.satellite.Satellite;

public class Main {
    public static void main(String... args) {
        Satellite<UserExample> satellite = new Satellite<UserExample>("","","");

        satellite.insert(new UserExample("Gabriel", 90));
        satellite.insert(new UserExample("Karla", 34));
        satellite.insert(new UserExample("Tyrion", 56));
        satellite.insert(new UserExample("Alec", 78));

        UserExample user = new UserExample("TestName", 100);

        satellite.printClassInformation(user);
    }
}