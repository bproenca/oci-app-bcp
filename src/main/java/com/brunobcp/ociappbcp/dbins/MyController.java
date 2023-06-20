package com.brunobcp.ociappbcp.dbins;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/show")
	public List<Map<String, Object>> greeting(@RequestParam(value = "limit", defaultValue = "3") Integer limit) {
		List<Map<String, Object>> queryList = jdbcTemplate.queryForList("SELECT * FROM ATABLE ORDER BY ID DESC FETCH FIRST ? ROWS ONLY", limit);
        return queryList;
	}
}