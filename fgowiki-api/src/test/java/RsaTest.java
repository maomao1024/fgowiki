import com.github.fgowiki.utils.RSAUtils;
import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Base64;
import java.util.Map;

/**
 * 功能描述： RSA加密算法测试
 *
 * @author 蒋经
 * @version 1.0
 * @since 2018/2/2
 */
public class RsaTest {

    private String publicKey;
    private String privateKey;
    private static final String id = "id_rsa";

    @Before
    public void init() throws Exception {
        File publicKeyFile = new File(id + ".pub");
        File privateKeyFile = new File(id);
        if (!publicKeyFile.exists() || !privateKeyFile.exists()) {
            Map<String, Key> keyMap = RSAUtils.initKey();
            publicKey = RSAUtils.getFormattedPublicKey(keyMap);
            privateKey = RSAUtils.getFormattedPrivateKey(keyMap);
            Files.write(publicKey.getBytes(), publicKeyFile);
            Files.write(privateKey.getBytes(), privateKeyFile);
        } else {
            publicKey = Files.toString(publicKeyFile, Charset.forName("UTF-8"));
            privateKey = Files.toString(privateKeyFile, Charset.forName("UTF-8"));
        }
        publicKey = RSAUtils.deformatKey(publicKey);
        privateKey = RSAUtils.deformatKey(privateKey);
    }

    /**
     * 测试rsa解密
     *
     * @throws Exception
     */
    @Test
    public void test_rsa_encrypt() throws Exception {
        String data = "123456";
        //加密后的字节数组
        byte[] encryptBytes = RSAUtils.encrypt(data, publicKey);
        //加密后的BASE64字符串
        String encryptBase64 = Base64.getEncoder().encodeToString(encryptBytes);
        //准备解密的字节数组
        byte[] decryptBase64 = Base64.getDecoder().decode(encryptBase64);
        //base64 转换前后数据一致
        Assert.assertArrayEquals(encryptBytes, decryptBase64);
        //解密后的字节数组
        byte[] decryptBytes = RSAUtils.decrypt(decryptBase64, privateKey);
        //解密结果
        String result = new String(decryptBytes);
        Assert.assertEquals(data, result);
    }

    /**
     * 测试rsa签名
     *
     * @throws Exception
     */
    @Test
    public void test_rsa_sign() throws Exception {
        String data = "2223";
        String sign = RSAUtils.sign(data, privateKey);
        //验证签名
        Assert.assertTrue(RSAUtils.verify(data, publicKey, sign));
        //验证篡改数据
        Assert.assertFalse(RSAUtils.verify("2233", publicKey, sign));
    }

}
