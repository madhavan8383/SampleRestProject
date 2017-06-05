package com.example;

import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionHandlingCommonController {

	@RequestMapping(value = "/sqlexceptionexample")
	@ResponseBody
	public String getResultSql() throws SQLException {
		boolean flag = true;
		if (flag) {
			throw new SQLException();
		}
		return "view";
	}

}