package com.mybatis.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private int memberNo;
	private String memberID;
	private String memberPW;
	private String memberName;
	
	private List<MemberEmail> emailList;
	private List<MemberAuth> authList;
}
