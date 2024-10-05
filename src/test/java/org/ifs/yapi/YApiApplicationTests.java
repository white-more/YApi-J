package org.ifs.yapi;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;


public class YApiApplicationTests {

    @Test
    public void testMd5(){
        byte[] bytes = DigestUtils.md5("ajdfkajdk");
        System.out.println(new String(Hex.encodeHex(bytes)));
    }
}
