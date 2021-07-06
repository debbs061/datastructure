package crc32;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

/**
 * Java 에서 지원하는 crc32 객체를 이용해보자. (crc32 알고리즘)
 */
public class Program {
    public static void main(String[] args) {
        String input1 = "My text";
        String input2 = "My text";
        String input3 = "My different text";

        byte[] input1Bytes = input1.getBytes();
        byte[] input2Bytes = input2.getBytes();
        byte[] input3Bytes = input3.getBytes();

        CRC32 crc32 = new CRC32();

        crc32.update(input1Bytes);
        long checksum1 = crc32.getValue();
        System.out.println(String.format("input1: %d", checksum1));

        crc32.reset();

        crc32.update(input2Bytes);
        long checksum2 = crc32.getValue();

        System.out.println(String.format("input2: %d", checksum2));

        crc32.reset();

        crc32.update(input3Bytes);
        long checksum3 = crc32.getValue();

        System.out.println(String.format("input3: %d", checksum3));

        String input = "My long long text";
        byte[] inputArray = input.getBytes(StandardCharsets.UTF_8);
//        InputStream inputStream = new ByteArrayInputStream();

    }

}
