package com.myboard.aop;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface AOPMapper {
	
	public int insert(AOPModel aop);
	
	
	@Select("SELECT * FROM aoptable")
	public List<AOPModel> selectAll();
}
