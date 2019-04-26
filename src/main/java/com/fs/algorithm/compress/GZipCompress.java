package com.fs.algorithm.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipCompress extends AbstractBaseCompress{
    public byte[] press(byte[] source) {
        ByteArrayOutputStream out = null;
        GZIPOutputStream gzip=null;
        byte[] result = null;
        try {
            out = new ByteArrayOutputStream();
            gzip = new GZIPOutputStream(out);
            gzip.write(source);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                gzip.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }


    public byte[] unPress(byte[] source) {
        ByteArrayOutputStream out= new ByteArrayOutputStream();
        ByteArrayInputStream in=null;
        GZIPInputStream ginzip=null;
        try {
            in=new ByteArrayInputStream(source);
            ginzip=new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            return out.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ginzip.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }

}
