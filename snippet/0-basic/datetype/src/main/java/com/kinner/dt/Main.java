package com.kinner.dt;

public class Main {

    public static void main(String[] args)
    {
        // cast to unsigned byte
        byte b = (byte)(127+128);
        System.out.println(b);

        int i = (b & 0xFF);
        System.out.println(i);

        // bytes array
        byte[] bs = {65,66,67,97,98,99};
        System.out.println(bs.length);

        // bytes array to string
        var s = new String(bs);
        System.out.println(s);

        byte[] bs1 = "hello world 你好".getBytes();
        for (var lb: bs1) {
            System.out.print(lb + ",");
        }
    }

}
