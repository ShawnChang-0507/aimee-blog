package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.HttpServletRequest;

public class AimeeHelper {
	/**
	 * 获取访问者ip
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                                                                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
        }
        // ipAddress = this.getRequest().getRemoteAddr();
        
        return ipAddress;
    }
	
	/**
     *  EDS的加密解密代码
     */
    private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };
      @SuppressWarnings("restriction")
      public static String encryptBasedDes(String data) {
          String encryptedData = null;
          try {
              // DES算法要求有一个可信任的随机数源
              SecureRandom sr = new SecureRandom();
              DESKeySpec deskey = new DESKeySpec(DES_KEY);
              // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
              SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
              SecretKey key = keyFactory.generateSecret(deskey);
              // 加密对象
              Cipher cipher = Cipher.getInstance("DES");
              cipher.init(Cipher.ENCRYPT_MODE, key, sr);
              // 加密，并把字节数组编码成字符串
              encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
          } catch (Exception e) {
              // log.error("加密错误，错误信息：", e);
              throw new RuntimeException("加密错误，错误信息：", e);
          }
          return encryptedData;
      }
      @SuppressWarnings("restriction")
      public static String decryptBasedDes(String cryptData) {
          String decryptedData = null;
          try {
              // DES算法要求有一个可信任的随机数源
              SecureRandom sr = new SecureRandom();
              DESKeySpec deskey = new DESKeySpec(DES_KEY);
              // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
              SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
              SecretKey key = keyFactory.generateSecret(deskey);
              // 解密对象
              Cipher cipher = Cipher.getInstance("DES");
              cipher.init(Cipher.DECRYPT_MODE, key, sr);
              // 把字符串进行解码，解码为为字节数组，并解密
              decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
          } catch (Exception e) {
              throw new RuntimeException("解密错误，错误信息：", e);
          }
          return decryptedData;
      }
}
