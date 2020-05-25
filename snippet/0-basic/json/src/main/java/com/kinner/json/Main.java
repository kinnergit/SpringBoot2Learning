package com.kinner.json;

import com.google.gson.Gson;
import com.kinner.json.entity.Person;

public class Main {

    public static void main(String[] args)
    {
        var gs = new Gson();
        String json = gs.toJson(new Person());
        System.out.println(json);

        var o = gs.fromJson(json, Person.class);

        System.out.println(o.name);
        System.out.println(o.age);
    }

}
