package com.atguigu.springcloud;

import org.junit.Test;

import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class TestSocket {
    @Test
    public void testInetAddress() throws Exception{
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getAddress());
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
        int str = 245;
        int i = 1;
        byte b = (byte)str;
        char c = (char)i;
        System.out.println(b);
        System.out.println(c);
        InetAddress address1 = InetAddress.getByAddress(new byte[]{(byte)144,(byte)34,(byte)240,(byte)118});
        System.out.println(address1.getHostName()+"-----144.34.240.118");
    }
    @Test
    public void test(){
        System.out.println(2<<3);//00000010-->00010000左移三位
        int i = 10;//int是4个字节32为 00000000 00000000 000000000 00001010
        byte[] result=new byte[4];
        result[0]=(byte)((i >> 24)& 0xFF);
        result[1]=(byte)((i >> 16)& 0xFF);
        result[2]=(byte)((i >> 8)& 0xFF);
        result[3]=(byte)(i & 0xFF);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        byte[] bytes = result;
        int num =    bytes[3] & 0xFF;
        num |=((bytes[2] <<8)& 0xFF00);//按位或并赋值给num
        num |=((bytes[1] <<16)& 0xFF0000);
        num |=((bytes[0] <<24)& 0xFF000000);
        System.out.println(num);
    }
    @Test
    public void test2(){
        byte[] a = new byte[10];
        a[0]= -127; //111111111
        System.out.println(a[0]);
        int c = a[0]&0xff;
        System.out.println(c);
    }
    @Test
    public void test3(){
        char c = 'a';
        int i = (int)c<<1;//10进制为194 16进制为\u00c2
        System.out.println((char)i);//char和int之间的转换 是通过Unicode
        System.out.println((int)c<<1);
        System.out.println((int)c);
    }
    @Test
    public void test4(){
        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection urlConnection = url.openConnection();
            System.out.println(urlConnection.getContent());
            System.out.println(url.getHost());
            System.out.println(url.getPath());
            System.out.println(url.getAuthority());
            urlConnection.getInputStream();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
