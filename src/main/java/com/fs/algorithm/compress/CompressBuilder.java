package com.fs.algorithm.compress;

public class CompressBuilder {

    public static Compress builder(String compressType){
        if (compressType.equals("GZIP")){
            return new GZipCompress();
        }
        if ("Deflater".equals(compressType)){
            return new DeflaterCompress();
        }
        if ("Snappy".equals(compressType)){
            return new SnappyCompress();
        }
        if ("LZ4".equals(compressType)){
            return new LZ4Compress();
        }
        return null;
    }
}
