package com.baomidou.mybatisplus.samples.quickstart.constants;

import lombok.Getter;

/**
 * 返回码统一定义
 */

@Getter
public enum ResponseEnum {
    FAIL(0, "失败"),
    SUCCESS(1, "成功"),
    FRONTEND_302(302, "前端重定向"),

    SERVER_INNER_ERROR(5000, "服务异常"),
    REQUEST_DATA_ILLEGAL_ERROR(40007, "请求参数不合法"),
    WECHAT_PAY_ERROR(40014,"微信支付失败"),
    WECHAT_AUTH_ILLEGAL(40021,"微信授权不合法"),
    WECHAT_SERVICE_FAIL(40022,"微信服务失败"),
    ORDER_NOT_EXIST(40023, "订单不存在"),
    USER_NOT_LOGIN(40024, "用户未登录"),
    ITEM_NOT_EXIST(40025, "服务不存在"),
    CREATE_ORDER_FAILED(40026, "创建订单失败"),
    CREATE_PAY_RECORD_FAILED(40027, "创建支付单失败"),
    CONSULT_USER_CREATE_FAILED(40028, "用户创建失败"),
    CONSULT_USER_IS_FORBIDDEN(40029, "该用户被禁止了"),
    NO_LAST_VISITOR_RECORD(40030, "没有来访记录"),
    ORG_IS_NULL_ERROR(30000, "机构不存在"),
    ORDER_IS_NULL_ERROR(30001, "订单不存在"),
    CREATE_APPOINT_FAILED(30002, "预约失败"),
    SCHEDULE_USED(30003, "排班表已被占用"),
    SCHEDULE_NOT_USED(30004, "排班表未被占用，无法更新"),
    DATA_ALREADY_EXIST(30005, "保存数据已存在"),
    SAVE_APPOINT_ERROR(30006, "保存预约服务数据失败"),
    SAVE_APPOINT_RECORD_ERROR(30007, "保存预约服务记录数据失败"),
    UPDATE_APPOINT_RECORD_ERROR(30008, "修改预约服务记录数据失败"),
    APPOINT_RECORD_STATUS_ERROR(30009, "预约服务记录数据状态不符合预期"),
    UPDATE_APPOINT_ERROR(30010, "修改预约服务数据失败"),
    CONSULTANT_NO_EXIST(30011, "咨询师不存在"),
    APPOINT_STATUS_ERROR(30012, "预约服务数据状态不符合预期"),
    UPDATE_DATA_ERROR(30013, "修改数据失败"),
    UPDATE_VISITOR_RECORD_FAILED(30014, "更新来访者数据失败"),
    UPDATE_ORDER_ERROR(30015, "订单修改失败"),
    REFUND_SAVE_ERROR(30016, "退款保存失败"),
    ORDER_STATUS_ERROR(30017, "订单状态错误"),
    APPOINT_TIME_MAX_ERROR(30018, "预约次数已满"),
    CONSULT_APP_REQUEST_FAILED(30019, "咨询师app请求失败"),
    VALID_CODE_EXPIRED(30020, "验证码已过期"),
    VALID_CODE_IS_NULL(30021, "请输入验证码"),
    LOGIN_VALID_FAIL(30022, "登录校验失败"),
    VALID_CODE_GET_FAIL(30023, "登录验证码获取失败"),
    ORG_SUB_MCH_ID_ERROR(30024, "该机构无配对商户号"),
    VISITOR_USERNAME_ERROR(30025, "用户姓名校验失败，请更换")
    ;

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
