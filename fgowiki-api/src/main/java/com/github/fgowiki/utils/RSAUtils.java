package com.github.fgowiki.utils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public abstract class RSAUtils {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    public static final String PUBLIC_KEY = "RSAPublicKey";
    public static final String PRIVATE_KEY = "RSAPrivateKey";

    public static final int KEY_SIZE = 1024;


    /**
     * 私钥签名
     *
     * @param data       待签名数据
     * @param privateKey 私钥
     * @return 签名数据的base64字符串
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = Base64.getDecoder().decode(privateKey);
        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // 指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);
        return Base64.getEncoder().encodeToString(signature.sign());
    }


    /**
     * 私钥签名
     *
     * @param data       待签名文本
     * @param privateKey 私钥
     * @return 签名数据的base64字符串
     * @throws Exception
     */
    public static String sign(String data, String privateKey) throws Exception {
        return sign(data.getBytes(), privateKey);
    }

    /**
     * 校验数字签名
     *
     * @param data      数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        // 解密由base64编码的公钥
        byte[] keyBytes = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
        // 验证签名是否正常
        return signature.verify(Base64.getDecoder().decode(sign));
    }

    /**
     * 校验数字签名
     *
     * @param data      加密数据的base64字符串
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     */
    public static boolean verify(String data, String publicKey, String sign) throws Exception {
        return verify(data.getBytes(), publicKey, sign);
    }

    /**
     * 用私钥解密
     *
     * @param data 待解密的字节数组
     * @param key  私钥
     * @return 解密后的字节数组
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        // 对密钥解密
        byte[] keyBytes = Base64.getDecoder().decode(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 用私钥解密
     *
     * @param data 待解密的文本
     * @param key  私钥
     * @return 解密后的字节数组
     * @throws Exception
     */
    public static byte[] decrypt(String data, String key) throws Exception {
        return decrypt(Base64.getDecoder().decode(data), key);
    }

    /**
     * 用公钥加密
     *
     * @param data 待加密的字节数据
     * @param key  公钥
     * @return 加密后的字节数组
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        // 对公钥解密
        byte[] keyBytes = Base64.getDecoder().decode(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 用公钥加密
     *
     * @param data 待加密的文本
     * @param key  公钥
     * @return 加密后的字节数组
     * @throws Exception
     */
    public static byte[] encrypt(String data, String key) throws Exception {
        return encrypt(data.getBytes(), key);
    }


    /**
     * 取得私钥
     *
     * @param keyMap 存放key的map
     * @return 私钥base64单行字符串
     */
    public static String getPrivateKey(Map<String, Key> keyMap) {
        return getKey(keyMap, PRIVATE_KEY);
    }

    /**
     * 取得公钥
     *
     * @param keyMap 存放key的map
     * @return 公钥base64单行字符串
     */
    public static String getPublicKey(Map<String, Key> keyMap) {
        return getKey(keyMap, PUBLIC_KEY);
    }

    private static final String[] PRIVATE_KEY_FORMAT = {"-----BEGIN RSA PRIVATE KEY-----", "-----END RSA PRIVATE KEY-----"};
    private static final String[] PUBLIC_KEY_FORMAT = {"-----BEGIN PUBLIC KEY-----", "-----END PUBLIC KEY-----"};

    /**
     * 获取key
     *
     * @param keyMap 存放key的map
     * @param keyType
     * @return
     */
    private static String getKey(Map<String, Key> keyMap, String keyType) {
        return Base64.getEncoder().encodeToString(keyMap.get(keyType).getEncoded());
    }

    /**
     * 取得格式化的私钥
     *
     * @param keyMap 存放key的map
     * @return 格式化后的私钥
     */
    public static String getFormattedPrivateKey(Map<String, Key> keyMap) {
        String privateKey = getKey(keyMap, PRIVATE_KEY);
        return PRIVATE_KEY_FORMAT[0] + "\n" + getFromattedBase64String(privateKey) + PRIVATE_KEY_FORMAT[1];
    }

    /**
     * 取得格式化的公钥
     *
     * @param keyMap 存放key的map
     * @return 格式化后的公钥
     */
    public static String getFormattedPublicKey(Map<String, Key> keyMap) {
        String publicKey = getKey(keyMap, PUBLIC_KEY);
        return PUBLIC_KEY_FORMAT[0] + "\n" + getFromattedBase64String(publicKey) + PUBLIC_KEY_FORMAT[1];
    }

    /**
     * 将base64字符串按每行64个字符分割
     *
     * @param str base64 单行字符串
     * @return 格式化后的base64字符串
     */
    private static String getFromattedBase64String(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i += 64) {
            sb.append(str, i, i + 64 > length ? length : i + 64).append("\n");
        }
        return sb.toString();
    }

    /**
     * 还原格式化的key
     *
     * @param key 格式化的key文本
     * @return key的单行base64字符串
     */
    public static String deformatKey(String key) {
        return key.replaceAll("(\\s*-.+-\\s*)|\\n", "");
    }

    /**
     * 初始化密钥 默认kysize为 {@value KEY_SIZE}
     *
     * @return 存放key的map
     * @throws Exception
     */
    public static Map<String, Key> initKey() throws Exception {
        return initKey(KEY_SIZE);
    }

    /**
     * 初始化密钥
     *
     * @param keySize key大小
     * @return 存放key的map
     * @throws Exception
     */
    public static Map<String, Key> initKey(int keySize) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom secureRandom = new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes());
        keyPairGen.initialize(keySize, secureRandom);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        Map<String, Key> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, keyPair.getPublic());// 公钥
        keyMap.put(PRIVATE_KEY, keyPair.getPrivate());// 私钥
        return keyMap;
    }

}