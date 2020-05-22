package com.kinner.cmp.vms;

import com.kinner.cmp.service.MyHTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class VM {

    public static JSONArray queryVmInstance(String vmName)
    {
        String str = "{\n" +
                "    \"baseInfo\": {\n" +
                "        \"userId\": \"\",\n" +
                "        \"accountId\": \"\",\n" +
                "        \"pageSize\": 20,\n" +
                "        \"pageNum\": 1\n" +
                "    },\n" +
                "    \"properties\": {\n" +
                "        \"zoneId\": \"\",\n" +
                "        \"cloudRegionId\": \"\",\n" +
                "        \"cloudId\": \"\",\n" +
                "        \"regionId\": \"\",\n" +
                "        \"azId\": \"\",\n" +
                "        \"productNo\": \"\",\n" +
                "        \"virtualMachineName\": \"" + vmName + "\",\n" +
                "        \"status\": \"\",\n" +
                "        \"networkId\": \"\",\n" +
                "        \"subNetworkId\": \"\",\n" +
                "        \"netCardId\": \"\",\n" +
                "        \"floatingIpAddress\": \"\",\n" +
                "        \"virtualMachineIp\": \"\",\n" +
                "        \"startTime\": \"\",\n" +
                "        \"endTime\": \"\"\n" +
                "         \n" +
                "    }\n" +
                "}";

        var json = new JSONObject(str);

        try {
            var res = MyHTTP.post("http://172.20.47.90:31101/v1/yc/cmp-resource/queryVmInstance", json);

            var oJson = new JSONObject(res);

            return oJson.getJSONObject("retObj").getJSONArray("list");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

}
