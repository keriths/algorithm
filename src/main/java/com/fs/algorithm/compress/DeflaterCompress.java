package com.fs.algorithm.compress;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DeflaterCompress extends AbstractBaseCompress{
    public byte[] press(byte[] source) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        Deflater compressor = new Deflater();

        try {
            compressor.setLevel(9);  //将当前压缩级别设置为指定值。
            compressor.setInput(source, 0, source.length);
            compressor.finish(); //调用时，指示压缩应当以输入缓冲区的当前内容结尾。

            // Compress the data
            final byte[] buf = new byte[1024];
            while (!compressor.finished()) {
                //如果已到达压缩数据输出流的结尾，则返回 true。
                int count = compressor.deflate(buf);
                // 使用压缩数据填充指定缓冲区。
                bos.write(buf, 0, count);
            }
        } finally {
            compressor.end(); //关闭解压缩器并放弃所有未处理的输入。
        }

        return bos.toByteArray();
    }

    public byte[] unPress(byte[] source) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        Inflater decompressor = new Inflater();

        try {
            decompressor.setInput(source);

            final byte[] buf = new byte[1024];
            while (!decompressor.finished()) {
                int count = decompressor.inflate(buf);
                bos.write(buf, 0, count);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            decompressor.end();
        }

        return bos.toByteArray();
    }
}
