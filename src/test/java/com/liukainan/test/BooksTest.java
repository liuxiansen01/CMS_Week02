package com.liukainan.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liukainan.mapper.BooksMapper;
import com.liukainan.pojo.Books;
import com.liukainan.pojo.Error_Msg;
import com.liukainan.pojo.Type;

import utils.IOUtils;
import utils.StringUtil;

public class BooksTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		BooksMapper bean = cxt.getBean(BooksMapper.class);
		
		List<Object[]> readFile = IOUtils.readFile
		("D:\\2019bwStudy\\TenMonthCMS\\assignment\\CMS_Liukainan_LianxiWeek02_12.06\\src\\test\\resources\\parameter.txt", "\\\\t");
		for (Object[] objects : readFile) {
			//System.out.println(objects[0]);
			//System.out.println(StringUtil.isNumber(objects[2]+""));
			Books books = new Books();
			Error_Msg em = new Error_Msg();
			if (StringUtil.isNumber(objects[2]+"") && StringUtil.isPhone(objects[3]+"")) {
				//Books b = new Books(Integer.parseInt(objects[0]+""), objects[1]+"", Integer.parseInt(objects[2]+""), objects[3]+"", type_id, tid, tname)
				books.setBid(Integer.parseInt(objects[0]+""));
				books.setBname(objects[1]+"");
				books.setSales(Integer.parseInt(objects[2]+""));
				books.setPhone(objects[3]+"");
				Type typeId = bean.getTypeIdByTname(objects[4]+"");
				books.setType_id(typeId.getTid());
				bean.insertBooks(books);
			} else if(!StringUtil.isNumber(objects[2]+"")) {
				String msg = "编号为"+objects[0]+"的记录，受欢迎程序数据错误";
				em.setError_msg(msg);
				bean.insertErrorMsg(em);
			} else if (!StringUtil.isPhone(objects[3]+"")) {
				String msg = "编号为"+objects[0]+"的记录，手机号格式错误";
				em.setError_msg(msg);
				bean.insertErrorMsg(em);
			}
		}
		
	}

}
