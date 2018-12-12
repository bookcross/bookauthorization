package com.trembear.bookauthorization.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 系统错误枚举
 *
 * @author wei.wang21 Created by nico on 2018/7/28. 0000：操作成功 1***：管理员系统错误
 * 2***：等等业务系统错误 9***：系统错误 9999：操作失败
 */
public enum SystemRest {

    SUCCESS("0000", "操作成功"),

    LOGIN_SUCCESS("20000", "登陆成功"),

    LOGIN_NOT_SUPPORT_EMP_NO("1070","不支持工号登录"),

    USER_NOT_EXISTS("1000", "用户不存在"),

    USER_PASSWORD_FAULT("1001", "用户密码错误"),

    USER_CREATE_FAULT("1002", "用户新增异常"),

    USER_QUERY_FAULT("1003", "用户列表查询异常"),

    USER_UPDATE_FAULT("1004", "用户更新异常"),

    USER_CHANGE_NICKNAME_OUT_TIME("1030", "昵称无法再修改"),

    USER_UPDATE_LOGO_FAULT("1071", "用户头像更新失败"),

    USER_NICKNAME_INVALID("1007", "用户昵称验证不通过"),

    USER_NICKNAME_QUERY_FAULT("1028", "用户昵称查询异常"),

    USER_NOT_PERMISSION("1025", "用户无权访问"),

    USER_SPEECH_FORBID("1051", "对不起，您已经被禁言"),

    USER_NOT_LOGIN("1052", "用户未登陆"),

    USER_TOKEN_INVALID("1026", "用户TOKEN无效"),

    BBS_NOT_EXISTS("1064", "帖子不存在"),

    BBS_PARAMS_NOT_NULL("1111", "参数不能为空"),

    BBS_CREATE_FAULT("1005", "帖子新增异常"),

    BBS_QUERY_FAULT("1006", "帖子列表查询异常"),

    BBS_UPDATE_FAULT("1067", "帖子更新异常"),

    BASE_NOT_EXISTS("1008", "字典不存在"),

    BASE_COUNT_EXCEPTION("1029", "基础服务统计发生错误"),

    BASE_CREATE_FAULT("1009", "字典新增异常"),

    BASE_QUERY_FAULT("1010", "字典列表查询异常"),

    BASE_UPDATE_FAULT("1011", "字典更新异常"),

    USERCENTER_COOLECT_NOT_EXISTS("1012", "用户中心--收藏记录不存在"),

    USERCENTER_COOLECT_CREATE_FAULT("1013", "用户中心--收藏记录新增异常"),

    USERCENTER_COOLECT_QUERY_FAULT("1014", "用户中心--收藏记录列表查询异常"),

    USERCENTER_COOLECT_UPDATE_FAULT("1015", "用户中心--收藏记录更新异常"),

    USERCENTER_COOLECT_PRAISE_QUERY_FAULT("1016", "用户中心--收藏和点赞列表查询异常"),

    USERCENTER_COOLECT_DELETE_FAULT("1029", "用户中心--删除收藏记录异常"),

    USERCENTER_IS_COOLECT_QUERY_FAULT("1045", "用户中心--查询收藏记录是否存在异常"),

    UUSERCENTER_PRAISE_NOT_EXISTS("1022", "用户中心--点赞记录不存在"),

    USERCENTER_PRAISE_CREATE_FAULT("1023", "用户中心--点赞记录新增异常"),

    USERCENTER_PRAISE_QUERY_FAULT("1024", "用户中心--点赞记录列表查询异常"),

    USERCENTER_PRAISE_UPDATE_FAULT("1025", "用户中心--点赞记录更新异常"),

    USERCENTER_IS_PRAISE_QUERY_FAULT("1045", "用户中心--查询点赞记记录是否存在异常"),

    BBS_DFAFT_QUERY_FAULT("1016", "草稿箱列表查询异常"),

    BBS_DRAFT_QUERYDETAIL_FAULT("1017", "草稿箱详情查询异常"),

    BBS_DRAFT_DELETE_FAULT("1019", "删除草稿箱详情出错"),

    BBS_REPLY_QUERY_FAULT("1018", "评论列表查询异常"),

    BBS_PRAISE_CREATE_FAULT("1020", "点赞记录新增异常"),

    BBS_COLLECT_CREATE_FAULT("1062", "收藏记录新增异常"),

    BBS_TOPICS_DETAIL_FAULT("1026", "查询帖子详情异常"),

    BBS_BULLETIN_DETAIL_FAULT("1027", "查询公告详情异常"),

    BBS_OPNION_DETAIL_FAULT("1028", "查询意见详情异常"),

    BBS_CLOSE_OPEN_COMMENT_FAULT("1029", "打开或关闭评论发生异常"),

    NOT_FIND_AUTHORIZATION("9001", "无法获取请求头Authorization信息"),

    CLIENT_ID_NOT_EXISTS("9002", "clientId不存在"),

    CLIENT_ID_SECRET_ERROR("9003", "clientId密码错误"),

    CREATE_TOKEN_ERROR("9004", "创建TOKEN失败"),

    DELETE_TOKEN_ERROR("9005", "注销TOKEN失败"),

    MSG_QUERY_FAULT("1021", "通知查询异常"),

    MSG_READ_FAULT("1022", "通知状态更新异常"),

    MSG_SEND_FAULT("1023", "通知发送异常"),

    PARAM_EXCEPTION("2000", "参数异常"),

    ROLE_ADD_FAULT("1031", "角色添加失败"),

    ROLE_UPDATE_FAULT("1032", "角色更新失败"),

    POLE_QUERY_FAULT("1033", "角色查询失败"),

    USERROLE_UPDATE_FAULT("1034", "用户更新角色失败"),

    LABLE_ADD_FAULT("1041", "标签添加失败"),

    LABLE_UPDATE_FAULT("1042", "标签更新失败"),

    LABLE_QUERY_FAULT("1043", "标签查询失败"),

    NO_DATA_UPDATED("3001", "未更新任何数据"),
    DATA_ALREADY_EXIST("3002", "数据已存在"),
    OLD_PASSWORD_ERROR("3003", "旧密码错误"),
    CONFIRM_PASSWORD_ERROR("3004", "两次密码不一致"),
    USER_EXISTS("3005", "用户已存在"),
    ADD_BULLETIN_FAIL("3006", "发布公告失败"),
    QUERY_CATEGORY_FAIL("3007", "查询类目失败"),
    BULLETIN_PARAM_ERROR("3008", "公告标签，内容，标题，是否开启评论不能为空"),
    PASSWORD_PARAM_ERROR("3009", "新密码，旧密码，确认密码，不能为空"),
    REPORT_PARAM_ERROR("3010", "帖子ID，用户ID不能为空"),
    ID_STATUS_PARAM_ERROR("3011", "ID，STATUS缺失或错误"),
    ID_PARAM_ERROR("3012", "ID缺失"),
    ID_ROLES_ERROR("3013", "用户ID或角色列表缺失"),
    ID_MAIL_ERROR("3014", "角色ID，用户邮箱不能为空"),
    USER_MENU_ERROR("3015", "用户未分配任何菜单"),
    QUERY_REPORTTYPE_ERROR("3016", "查询举报类型错误"),
    ADD_REPORT_ERROR("3017", "新增举报失败"),
    TOKEN_INVAILD_ERROR("3018", "无效Token"),
    ADMINWEB_EXCEPTION("3019", "系统异常"),
    MENU_PARAM_ERROR("3020", "ID，菜单名称，请求地址，页面地址错误"),

    FILE_UPLOAD_ERROR("4001", "文件上传失败"),
    ERROR("9999", "系统未知异常"),

    MESSAGE_TEXT_IS_TOO_LONG("1050", "内容文本长度过长");

    private String code;
    private String msg;

    SystemRest(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsgByCode(String code) {
        for (SystemRest systemException : SystemRest.values()) {
            if (StringUtils.equals(systemException.getCode(), code)) {
                return systemException.getMsg();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
