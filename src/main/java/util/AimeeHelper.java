package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.fullexception.entity.LoginInfo;
import com.fullexception.entity.Visitor;
import com.fullexception.service.VisitorService;

public class AimeeHelper {

	public static Visitor visitor;
	
	/**
	 * 登录信息
	 */
	private static Map<String, Integer> loginInfo = new HashMap<String, Integer>();
	
	/**
	 * 访问人数
	 */
	public static Map<String, Integer> visitNumber = new HashMap<String, Integer>();
	/**
	 * 维护登陆信息
	 * 
	 * @param ip
	 */
	private static void putLoginInfo(String ip) {
		if (loginInfo.containsKey(ip)) {
			loginInfo.put(ip, loginInfo.get(ip) + 1);
		} else {
			loginInfo.put(ip, 1);
		}
	}

	/**
	 * 获取访问者ip
	 * 
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
			ipAddress = "";
		}
		// ipAddress = this.getRequest().getRemoteAddr();

		return ipAddress;
	}

	/**
	 * EDS的加密解密代码
	 */
	private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };

	/**
	 * 加密
	 * 
	 * @param data
	 * @return
	 */
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

	/**
	 * 解密
	 * 
	 * @param cryptData
	 * @return
	 */
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

	public static Cookie putCookie(Visitor visitor) {
		String loginInfo = String.format("%s#%s#%s", visitor.getVisitorId(), visitor.getLoginName(),
				visitor.getLoginPassword());
		Cookie c = new Cookie("loginInfo", loginInfo);
		c.setPath("/");
		c.setMaxAge(7 * 24 * 60 * 60);
		return c;
	}

	public static String[] getCookie(Cookie[] cs) {
		if (cs == null)
			return null;
		for (Cookie c : cs) {
			if ("loginInfo".equals(c.getName())) {
				String[] results = c.getValue().split("#");
				return results;
			}
		}
		return null;
	}

	/**
	 * 分别根据session和cookie判断登录状态
	 * 
	 * @param request
	 * @return
	 */
	public static Visitor checkLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(20 * 60);
		Visitor visitor = session.getAttribute("myVisitor") == null ? null
				: (Visitor) session.getAttribute("myVisitor");
		if (visitor == null) {
			Cookie[] cookies = request.getCookies();
			String[] loginInfo = getCookie(cookies);
			if (loginInfo != null) {
				visitor = new Visitor();
				visitor.setVisitorId(Integer.parseInt(loginInfo[0]));
				visitor.setLoginName(loginInfo[1]);
				visitor.setLoginPassword(loginInfo[2]);
			}
		}
		return visitor;
	}

	/**
	 * 判断登录及初始化session
	 * 
	 * @param request
	 * @param model
	 * @param visitorService
	 * @return loginInfoOrNot 是否进行进村登记 loginOrNot 是否登录 visitor 访问者或者默认访问用户
	 */
	public static Map<String, Object> loginSystem(HttpServletRequest request, ModelMap model,
			VisitorService visitorService) {
		Visitor visitor = AimeeHelper.checkLogin(request);
		String ip = AimeeHelper.getIpAddr(request);
		Boolean loginInfoOrNot = false; // 是否记录登录信息
		Boolean loginOrNot = true;
		// session和cookies中都没有登录信息
		if (visitor == null) {
			visitor = visitorService.tourist();
			putLoginInfo(ip);
			loginOrNot = false;
		} else {
			// 创建时间为空，说明cookie有值，session没值，需要重新登录，计次
			if (visitor.getCreateDate() == null) {
				String ln = visitor.getLoginName();
				String lp = visitor.getLoginPassword();
				visitor = visitorService.login(ln, lp);
				// cookie中记载的账号或密码错误，无法找到访问者信息，访问我的博客
				if (visitor == null) {
					visitor = visitorService.tourist();
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("myVisitor", visitor);
					appendLoginInfo(ip, visitor, visitorService);
					loginInfoOrNot = true;
				}
			}
		}
		if (model != null)
			model.addAttribute("tourist", visitor);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginInfoOrNot", loginInfoOrNot);
		map.put("loginOrNot", loginOrNot);
		map.put("visitor", visitor);
		return map;
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 */
	public static void quitLogin(HttpServletRequest request) {
		Cookie[] cs = request.getCookies();
		for (Cookie c : cs) {
			if ("loginInfo".equals(c.getName())) {
				c.setMaxAge(0);
			}
		}
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(0);
		session.removeAttribute("myVisitor");
	}

	/**
	 * 添加登录记录
	 * 
	 * @param ip
	 * @param visitor
	 * @param visitorService
	 */
	public static void appendLoginInfo(String ip, Visitor visitor, VisitorService visitorService) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setIp(ip);
		loginInfo.setVisitorId(visitor.getVisitorId());
		loginInfo.setLoginTime(new Date());
		visitorService.appendLoginInfo(loginInfo);
	}

	/**
	 * 获取内容中-汉字个数
	 * 
	 * @param content
	 *            - 内容
	 * @return int
	 */
	public static int getChineseSize(String content) {
		int count = 0;// 汉字数量
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(content);
		int len = m.groupCount();
		while (m.find()) {
			for (int i = 0; i <= len; i++) {
				count = count + 1;
			}
		}
		return count;
	}
	
	/**
	 * 将日期按指定格式化为字符串
	 * @param formatDate
	 * @return
	 */
	public static String formatDate(Date targetDate, String formatDate){
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		return sdf.format(targetDate);
	}
}
