package com.fs.algorithm.compress;

public interface Compress {
    /**
     * 压缩
     * @param source
     * @return
     */
    byte[] press(byte[] source);

    String press(String source);

    /**
     * 解压
     * @param source
     * @return
     */
    byte[] unPress(byte[] source);
    String unPress(String source);
}
