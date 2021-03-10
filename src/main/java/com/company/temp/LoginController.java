package com.company.temp;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.common.KakaoAPI;

@Controller
public class LoginController {
	
	@Autowired KakaoAPI kakaoAPI;
	
	@RequestMapping("/callback") // 카카오 로그인 구현
	public String callback(@RequestParam Map<String, Object> map, HttpSession session) {
		String code = (String)map.get("code");
		String access_token = kakaoAPI.getAccessToken(code);
		System.out.println("===== access_token =====" + access_token);
		
		// 사용자 정보 가져오기(https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info)
		Map<String, Object> userInfo = kakaoAPI.getUserInfo(access_token);
		System.out.println("===== userInfo =====" + userInfo);
		
		// token을 session에 저장(DB 저장)
		session.setAttribute("access_token", access_token);
		session.setAttribute("nickName", userInfo.get("nickname"));
		System.out.println("===== 로그인 세션 확인 =====" + access_token);
		
		return "/home";
	}
	
	// 로그아웃(https://antdev.tistory.com/37)
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// session에서 token 읽고 -> 로그아웃 진행
		kakaoAPI.kakaoLogout((String)session.getAttribute("access_token"));
		String nickName = (String) session.getAttribute("nickName");
		session.invalidate(); // 세션 무효화(실질적인 로그아웃 처리)
		System.out.println(nickName+"님 로그아웃 확인");
		return "/home";
	}
}
