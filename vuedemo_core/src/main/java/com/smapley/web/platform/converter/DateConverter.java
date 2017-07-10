package com.smapley.web.platform.converter;


import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter extends BaseConverter<String, Date> {

    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(source);
        } catch (ParseException e) {
            getLogger().error("日期转换失败", e);
        }
        return null;
    }
}
