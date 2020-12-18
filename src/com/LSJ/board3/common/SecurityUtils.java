package com.LSJ.board3.common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;

import com.LSJ.board3.model.UserModel;

public class SecurityUtils {
	
//	암호화
	public static String getSecurePassword(String password, String salt) {

        String generatedPassword = null;
        try {
//        	MessageDigest -> 해시 알고리즘 
            MessageDigest md = MessageDigest.getInstance("SHA-512");
//                                   디코딩(암호화 해제)
            byte[] byteSalt = Base64.decodeBase64(salt);
            md.update(byteSalt); // 해시값 업데이트 
            byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static String getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.encodeBase64String(salt); // 인코딩(암호화)
    
// Base64 -> 64진법  https://devuna.tistory.com/41 설명 참조
// Salt -> 원본 데이터의 앞 혹은 뒤에 다른 임의의 데이터를 끼워놓는 것 
//  => 완전히 다른 결과가 나온다 
    }
    
//	true : 로그아웃 / false : 로그인
	public static boolean isLogout(HttpServletRequest request) {
		return getLogin(request) == null;
	}
	
	public static UserModel getLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
//		세션 값 유지
		return (UserModel) session.getAttribute("loginUser");
	}
	
//	작성자 
	public static int getLogin_user(HttpServletRequest request) {
		UserModel m = getLogin(request);
		
		return m.getI_user();
	}
}

