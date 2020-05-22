package com.kinner.cmp.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import org.apache.http.client.methods.HttpPost;

public class MyHTTP {

    public static String post(String url, JSONObject json) throws IOException {
        // 解决中文乱码问题
        var se = new StringEntity(json.toString(), "UTF-8");
        se.setContentEncoding("UTF-8");

        var post = new HttpPost(url);
        post.addHeader("Source", "cmp");
        post.addHeader("Content-Type", "application/json;charset=UTF-8");
        post.setEntity(se);

        var resHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(final HttpResponse response) throws IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();

                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };

        var client = HttpClients.createDefault();
        String res = client.execute(post, resHandler);

        return res;
    }

}
