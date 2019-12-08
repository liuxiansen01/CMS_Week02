package com.liukainan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liukainan.pojo.Books;
import com.liukainan.pojo.Type;
import com.liukainan.service.BooksService;

@Controller
public class BooksController {
	
	@Autowired
	private BooksService bs;
	
	//删除图书的方法
	@RequestMapping("deleteBooks")
	@ResponseBody
	public boolean deleteBooks(String bid) {
		return bs.deleteBooks(bid) > 0;
	}
	
	//添加图书的方法
	@RequestMapping("addBooks")
	public String addBooks(Books books) {
		bs.insertBooks(books);
		return "redirect:getB";
	}
	
	//查询类型的方法
	@RequestMapping("getTypeList")
	@ResponseBody
	public List<Type> getTypeList() {
		return bs.getTypeList();
	}
	
	//查询图书列表页面
	@RequestMapping("getB")
	public String getBooksList(Model m, String bname, @RequestParam(defaultValue = "1")Integer pageNum,
			Integer minSales, Integer maxSales, Integer type_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bname", bname);
		map.put("minSales", minSales);
		map.put("maxSales", maxSales);
		map.put("type_id", type_id);
		List<Type> tList = bs.getTypeList();
		PageHelper.startPage(pageNum, 2);
		List<Books> bList = bs.getBooksList(map);
		PageInfo<Books> page = new PageInfo<Books>(bList);
		m.addAttribute("page", page);
		m.addAttribute("tList", tList);
		m.addAttribute("map", map);
		return "bList";
	}
	
}
