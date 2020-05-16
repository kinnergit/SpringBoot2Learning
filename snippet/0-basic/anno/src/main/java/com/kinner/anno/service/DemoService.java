package com.kinner.anno.service;

import com.kinner.anno.anno.Service;
import com.kinner.anno.anno.Subway;
import com.kinner.anno.entity.Response;

import java.util.HashMap;

@Service
public class DemoService
{
    @Subway(code = "code-a", name = "test-method-1")
    public Response demo1(HashMap<String, Object> map) {
        var res = new Response();
        res.setId("1000001");
        res.setName("demo1");

        System.out.print("call demo1: param1=" + map.get("param1"));

        return res;
    }

    @Subway(code = "code-b", name = "test-method-2")
    public Response demo2(HashMap<String, Object> map) {
        var res = new Response();
        res.setId("1000002");
        res.setName("demo2");

        System.out.print("call demo2: param2=" + map.get("param2"));

        return res;
    }

    @Subway
    public Response demo3(HashMap<String, Object> map) {
        var res = new Response();
        res.setId("1000003");
        res.setName("demo3");

        System.out.print("call demo3: param3=" + map.get("param3"));

        return res;
    }

    public Response demo4(HashMap<String, Object> map) {
        var res = new Response();
        res.setId("1000004");
        res.setName("demo4");

        System.out.print("call demo4: param4=" + map.get("param4"));

        return res;
    }
}
