package com.kinner.cmp;

import com.kinner.cmp.vms.VM;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args)
    {
        var jsonArray = VM.queryVmInstance("czz521_R_vm_勿删-调试");

        // virtualMachineId
        if (jsonArray != null) {
            for (var el: jsonArray) {
                System.out.println(((JSONObject)el).get("virtualMachineId"));
            }
        }

    }

}
