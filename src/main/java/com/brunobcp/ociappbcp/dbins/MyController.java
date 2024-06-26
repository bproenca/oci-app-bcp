package com.brunobcp.ociappbcp.dbins;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunobcp.ociappbcp.infrack.ControllerDemo;

@RestController
public class MyController {

    @Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(ControllerDemo.class);

	@GetMapping("/show")
	public List<Map<String, Object>> greeting(@RequestParam(value = "limit", defaultValue = "3") Integer limit) {
		log.info("## Show query table ATABLE with limit = {}", limit);
		List<Map<String, Object>> queryList = jdbcTemplate.queryForList("SELECT * FROM ATABLE ORDER BY ID DESC FETCH FIRST ? ROWS ONLY", limit);
        return queryList;
	}
}