package com.company.temp.user.service;

import java.util.List;

import com.company.temp.user.service.UserVO;

public interface UserService {
	// 조회
	public List<UserVO> getSearchUser(UserVO vo);

	// 단건 조회
	public UserVO getUser(UserVO vo);

	// 삽입
	public int insertUser(UserVO vo);

	// 삭제
	public int deleteUser(UserVO vo);
	
	// 수정
	public int updateUser(UserVO vo);
	
	// 로그인
	// int 타입으로 정의하면 다양한 로그인 처리 구현이 가능
	// boolean 타입은 단순 로그인 처리마 가능
	public boolean loginUser(UserVO vo);
	
	// 패스워드 변경
	public int updatePwd(UserVO vo);

}
