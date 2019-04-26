package com.fs.algorithm.compress;

import net.jpountz.lz4.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class LZ4Compress extends AbstractBaseCompress{
    public byte[] press(byte[] source) {
        try {
            LZ4Factory factory = LZ4Factory.fastestInstance();
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            LZ4Compressor compressor = factory.fastCompressor();
            LZ4BlockOutputStream compressedOutput = new LZ4BlockOutputStream(byteOutput, 1024*1024, compressor);
            compressedOutput.write(source);
            compressedOutput.close();
            return byteOutput.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public byte[] unPress(byte[] source) {
        try {
            LZ4Factory factory = LZ4Factory.fastestInstance();
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024*1024);
            LZ4FastDecompressor decompresser = factory.fastDecompressor();
            LZ4BlockInputStream lzis = new LZ4BlockInputStream(new ByteArrayInputStream(source), decompresser);
            int count;
            byte[] buffer = new byte[1024*1024];
            while ((count = lzis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            lzis.close();
            return baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
