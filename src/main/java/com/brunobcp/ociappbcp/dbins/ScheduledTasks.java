package com.brunobcp.ociappbcp.dbins;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.brunobcp.ociappbcp.info.HostInfoController;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private int cnt = 0;

    @Scheduled(fixedRateString = "${myapp.fixedRate}")
    public void insertData() {
        log.info("# Insert data {}", dateFormat.format(new Date()));
        jdbcTemplate.update("insert into ATABLE (INS_DATE, INFO_CI) values (sysdate, ?)",
                HostInfoController.getHostInfo());
        printMemoryStatus(++cnt);
    }

    private void printMemoryStatus(int cnt) {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        StringBuilder builder = new StringBuilder();
        builder.append("## ").append(cnt);
        builder.append("\tUsed Memory   : " + (runtime.totalMemory() - runtime.freeMemory()) / mb + " mb");
        builder.append("\tFree Memory   : " + runtime.freeMemory() / mb + " mb");
        builder.append("\tTotal Memory  : " + runtime.totalMemory() / mb + " mb");
        builder.append("\tMax Memory    : " + runtime.maxMemory() / mb + " mb");
        log.info(builder.toString());
    }
}