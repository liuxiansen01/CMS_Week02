package com.liukainan.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liukainan.mapper.BooksMapper;
import com.liukainan.pojo.Books;
import com.liukainan.pojo.Error_Msg;
import com.liukainan.pojo.Type;
@Service
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	private BooksMapper booksMapper;
	
	public Type getTypeIdByTname(String tname) {
		// TODO Auto-generated method stub
		return booksMapper.getTypeIdByTname(tname);
	}

	public int insertBooks(Books books) {
		// TODO Auto-generated method stub
		return booksMapper.insertBooks(books);
	}

	public int insertErrorMsg(Error_Msg em) {
		// TODO Auto-generated method stub
		return booksMapper.insertErrorMsg(em);
	}

	public List<Books> getBooksList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return booksMapper.getBooksList(map);
	}

	public int deleteBooks(String bid) {
		// TODO Auto-generated method stub
		String[] split = bid.split(",");
		int[] id = new int[split.length];
		int i = 0;
		for (String str : split) {
			id[i] = Integer.parseInt(str);
			i++;
		}
		return booksMapper.deleteBooks(id);
	}

	public List<Type> getTypeList() {
		// TODO Auto-generated method stub
		return booksMapper.getTypeList();
	}

}
