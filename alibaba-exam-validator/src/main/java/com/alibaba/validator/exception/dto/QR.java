package com.alibaba.validator.exception.dto;

import java.io.Serializable;


public class QR extends CR<QueryData<?>> implements Serializable {

    public QR(QueryData<?> data) {
        super(data);
    }
}
