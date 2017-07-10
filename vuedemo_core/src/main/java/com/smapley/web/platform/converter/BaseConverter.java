package com.smapley.web.platform.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public abstract class BaseConverter<S, T> implements Converter<S, T> {

    private static Logger logger = LoggerFactory.getLogger(BaseConverter.class);

    protected Logger getLogger() {
        return logger;
    }
}
