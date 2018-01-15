package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.User;
import com.ssm.service.IUserService;
import com.ssm.util.PageUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;

	@RequestMapping
	public String index() {

		return "User";
	}

	@RequestMapping("/getUserList")
	@ResponseBody
	public List<User> getUserList(Model model,PageUtil page) {

		int pageIndex = page.getCurrentPage();// 当前页
		int pageSize = page.getPageSize();// 这里用来设置每页要展示的数据数量，建议把这个写到web.config中来全局控制
		int rowCount = 0;
		int count = 10;// 获取测试表里面总条数,这里需要自己去获取

		rowCount = count;// 总条数
		// 通过计算，得到分页应该需要分几页，其中不满一页的数据按一页计算
		if (rowCount % pageSize != 0) {
			rowCount = rowCount / pageSize + 1;
		} else {
			rowCount = rowCount / pageSize;
		}

		List<User> list = this.userService.getUserListTop100();
		return list;
	}

}
