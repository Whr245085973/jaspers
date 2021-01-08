package com.han.jaspers.controller;

import com.han.jaspers.common.JasperReportUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: CREATED BY W.H.R
 * @Date: 2021/1/8 15:03
 **/
@RestController
@RequestMapping("jaspers")
public class Jaspers2 {

    @GetMapping("/jasper2")
    public void getReport(@RequestParam("type") String reportType, HttpServletResponse response)
            throws Exception {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", "小明");

        List<HashMap> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("Field1",  "Field1-" + i);
            item.put("Field2",  "Field2-" + i);
            list.add(item);
        }
        String jasperPath = JasperReportUtil.getJasperFileDir("chapter2");
        if (reportType.equals("pdf")) {
            JasperReportUtil.exportToPdf(jasperPath, parameters, list, response);
        } else if (reportType.equals("html")) {
            JasperReportUtil.exportToHtml(jasperPath, parameters, list, response);
        }
    }

}
