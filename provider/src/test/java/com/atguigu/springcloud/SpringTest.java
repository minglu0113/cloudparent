package com.atguigu.springcloud;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SpringTest {
    @Test
    public void testBuffer(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byteBuffer.put("zhangluming".getBytes());
        System.out.println(byteBuffer.position());
        Byte b = new Byte("123");
        System.out.println(b+"-----------");
        byteBuffer.put(b);
        byteBuffer.flip();
        System.out.println("--------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] b1 = new byte[byteBuffer.limit()];
        byteBuffer.get(b1);
        System.out.println(new String(b1,0,b1.length));
        System.out.println("get----------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("rewind_________");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byteBuffer.clear();//数据还在
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }
    @Test
    public void testmark(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("12345".getBytes());
        byteBuffer.flip();
        byte[] b = new byte[byteBuffer.limit()];
        byteBuffer.get(b,0,2);
        System.out.println(new String(b));
        System.out.println(byteBuffer.position());
        byteBuffer.mark();
        byteBuffer.get(b,2,2);
        System.out.println(new String(b,2,2));
        System.out.println(byteBuffer.position());
        byteBuffer.reset();
        System.out.println(byteBuffer.position());
        byteBuffer.get(b,0,2);
        System.out.println(new String(b));
        if(byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.remaining());
        }
    }
    @Test
    public void testchannel(){
        FileInputStream fis = null;
        FileOutputStream fos =null;
        FileChannel fic = null;
        FileChannel foc =null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\1.pdf");
            fos = new FileOutputStream("3.pdf");
            fic = fis.getChannel();
            foc = fos.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fic.read(byteBuffer)!=-1){
                byteBuffer.flip();
                foc.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(foc!=null){
                try {
                    foc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fic!=null){
                try {
                    fic.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testniotwo(){
        FileChannel fileChannel =null;
        FileChannel outChannel = null;
        try {
            fileChannel = FileChannel.open(Paths.get("1.pdf"),StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("5.pdf"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            MappedByteBuffer mappedByteBuffer1 = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
            byte[] bytes = new byte[mappedByteBuffer.limit()];
            mappedByteBuffer.get(bytes);
            mappedByteBuffer1.put(bytes);
            fileChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test4(){
        FileChannel fileChannel =null;
        FileChannel outChannel = null;
        try {
            fileChannel = FileChannel.open(Paths.get("1.pdf"),StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("6.pdf"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
            //直接缓存区
            fileChannel.transferTo(0,fileChannel.size(),outChannel);
            fileChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5(){
        char c = new Character('张');
        System.out.println((byte)c);
        byte b = new Byte("32");
        System.out.println(b);
    }
    @Test
    public void test6() throws CharacterCodingException {
        Charset charset = Charset.forName("GBk");//设置编码解码方式
        CharsetEncoder charsetEncoder = charset.newEncoder();//获取编码器
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("张路明");
        charBuffer.flip();
        ByteBuffer encode = charsetEncoder.encode(charBuffer);
        for(int i=0;i<encode.limit();i++){
            System.out.println(encode.get());
        }
        encode.flip();
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer decode = charsetDecoder.decode(encode);
        System.out.println(decode.toString());
    }
    public void testmulparm(String... strings){

    }

    @Test
    public void test7(){
        byte b = new Byte("12");
    }
}
