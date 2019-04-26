package com.fs.algorithm.compress;

public abstract class AbstractBaseCompress implements Compress{

    public String press(String source) {
        try {
            byte[] sourceBytes = source.getBytes();
            byte[] pressBytes = press(sourceBytes);
            return new sun.misc.BASE64Encoder().encode(pressBytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public String unPress(String source) {
        try {
            byte[] sourceBytes = new sun.misc.BASE64Decoder().decodeBuffer(source);
            byte[] unPressBytes = unPress(sourceBytes);
            return new String(unPressBytes);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
