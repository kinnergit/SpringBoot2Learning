package com.kinner.anno;

import com.kinner.anno.anno.Service;
import com.kinner.anno.anno.Subway;
import com.kinner.anno.entity.Request;
import com.kinner.anno.entity.Response;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        var map = new HashMap<String, Object>();
        map.put("param1", "value1");
        map.put("param2", "value2");

        var request = new Request();
        request.setCode("code-a");
        request.setName("test-method-1");
        request.setMap(map);

        var main = new Main();

        @SuppressWarnings("unused")
        var response = main.run(request);
    }

    public Response run(Request request) {
        var response = new Response();
        var reflections = new Reflections("com.kinner.anno.service");

        // 获取带Service注解的类
        var typesAnnotatedWith = reflections.getTypesAnnotatedWith(Service.class);
        for (var clazz : typesAnnotatedWith) {
            var methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Subway.class)) {
                    var annotation = method.getAnnotation(Subway.class);
                    if (annotation.code().equals(request.getCode())) {
                        try {
                            response = (Response)method.invoke(clazz.getConstructor().newInstance(), request.getMap());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }

        return response;
    }

}
