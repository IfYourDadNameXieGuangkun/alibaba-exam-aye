package com.alibaba.api.common.enums;

public  enum PayType {
    ALIPAY( "支付宝"),
    WXPAY( "微信支付"),
    UNIONPAY("银联支付"),
    CASH_ON_DELIVERY( "货到付款"),
    ONLINE("在线支付"),
    JSAPIPAY("微信小程序"),
    ALIPAYXCX( "支付宝小程序"),
    MIYAPAY( "微信小程序");
    String typeName;

    private PayType( String typeName) {
        this.typeName = typeName;
    }

    private String getName( String typeName) {
        return typeName;
    }
    private void setName( String typeName) {
        this.typeName = typeName ;
    }
}
