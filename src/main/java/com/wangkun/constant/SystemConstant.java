package com.wangkun.constant;

public class SystemConstant {

    /**
     * 响应状态码，通用错误
     */
    public static final int CODE_FAIL = 500;
    /**
     * 响应状态码，正确
     */
    public static final int CODE_SUCCESS = 200;
    /**
     * 响应状态码，权限异常，需要重新登录
     */
    public static final int CODE_AUTH = 403;

    /**
     * 通用状态，启用
     */
    public static final int STATUS_ON = 0;
    /**
     * 通用状态，禁用
     */
    public static final int STATUS_OFF = 1;
    /**
     * 用户类型，系统内置管理账号，不能删除
     */
    public static final int USER_TYPE_ADMIN = 0;
    /**
     * 由管理人员添加的普通用户
     */
    public static final int USER_TYPE_NORMAL = 1;


    /**
     * 请求设备实时信息的数据指令：01 03 10 00 00 2a c0 d5
     */
    public static final byte[] REQ_DEVICE_DATA = {0x01, 0x03, 0x10, 0x00, 0x00, 0x2A, (byte) 0xC0, (byte) 0xD5};
    /**
     * 获取设备实时数据响应的长度
     */
    public static final int RESP_DEVICE_DATA_LEN = 0x54;
    /**
     * 请求设备参数信息的数据指令，不包括井号和修井队名称 01 03 10 28 00 50 c1 3e
     */
    public static final byte[] REQ_DEVICE_PARAM = {0x01, 0x03, 0x10, 0x28, 0x00, 0x50, (byte)0xC1, 0x3E};
    /**
     * 获取设备参数信息响应的长度
     */
    public static final int RESP_DEVICE_PARAM_LEN = 0xA0;
    /**
     * 请求设备的业务信息，修井队的名称和井号 01 03 10 78 00 20 c0 cb
     */
    public static final byte[] REQ_DEVICE_INFO = {0x01, 0x03, 0x10, 0x78, 0x00, 0x20, (byte)0xC0, (byte) 0xCB};
    public static final int RESP_DEVICE_INFO_LEN = 0x40;
    /**
     * 一次请求设备参数和业务信息 01 03 10 28 00 70 c0 e6
     */
    public static final byte[] REQUEST_DEVICE_PARAM_AND_INFO_MESSAGE = { 0x01, 0x03, 0x10 ,0x28,0x00, 0x70 ,(byte)0xC0, (byte)0xE6 };
    /**
     * 一次请求设备参数和业务信息,回复的字节数
     */
    public static final int RESP_DEVICE_PARAM_AND_INFO_LEN = 0XE0;
    /**
     * 用来缓存当前的井号信息
     */
    public static String JINGHAO = "101";
    /**
     * 用来缓存修井队的名称
     */
    public static String XIUJINGDUIMC = "xjd101";
    /**
     * 用来绑在防碰预警值
     */
    public static  int FPSC_VAL = 1200;

}
