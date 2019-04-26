package com.fs.algorithm.compress;

import org.xerial.snappy.Snappy;

import java.io.IOException;

public class SnappyCompress extends AbstractBaseCompress{
    public byte[] press(byte[] source) {
        try {
            return Snappy.compress(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] unPress(byte[] source) {
        try {
            return Snappy.uncompress(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
