package com.liukainan.service;

import java.util.List;
import java.util.Map;

import com.liukainan.pojo.Books;
import com.liukainan.pojo.Error_Msg;
import com.liukainan.pojo.Type;

public interface BooksService {
	
	/**
	 * 查询类型方法
	 * @return
	 */
	List<Type> getTypeList();
	
	/**
	 * 删除图书
	 * @param bid
	 * @return
	 */
	int deleteBooks(String bid);
	
	/**
	 * 查询图书列表, 包含图书名称模糊查询
	 * @param map
	 * @return
	 */
	List<Books> getBooksList(Map<String, Object> map);
	
	/**
	 * 通过类型名称查询Tid
	 * @param tname
	 * @return
	 */
	Type getTypeIdByTname(String tname);
	
	/**
	 * 向图书表中添加内容
	 * @param books
	 * @return
	 */
	int insertBooks(Books books);
	
	/**
	 * 将不符合内容要求的记录添加到t_error表中
	 * @param em
	 * @return
	 */
	int insertErrorMsg(Error_Msg em);
	
}
