package com.company.temp.user.service.impl;

import java.util.List;

import com.company.temp.user.service.UserVO;

public interface UserMapper {
	
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

}
