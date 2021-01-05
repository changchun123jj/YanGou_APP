package com.example.demo.util;

import java.io.Serializable;

/**
 * 返回码
 *
 * @author liaoc
 */
public class RetCode implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 失败
     */
    public static final int FAIL = 201;
    /**
     * 无权限
     */
    public static final int NO_AUTH = 202;
    /**
     * 配置错误
     */
    public static final int CONFIG_ERROR = 203;

    /**
     * 错误码：入参错误
     */
    public static final int PARAMETER_ERROR = 101;
    /**
     * 错误码：数据不存在
     */
    public static final int NOT_EXIST = 102;
    /**
     * 错误码：数据已存在
     */
    public static final int HAS_EXIST = 103;
    /**
     * 错误码：数据错误
     */
    public static final int DATA_ERROR = 104;
    /**
     * 错误码：超限
     */
    public static final int OUT_LIMIT = 105;

    /**
     * 错误码：扎布存在
     */
    public static final int LOT_NOT_EXIST = 106;

    /**
     * 编号规范：**[系统] + **[模块] + ***[功能项] + ***[操作项]
     */
    /** - 【系统中心】 - */
    /**
     * 系统参数
     */
    // 存在未填写的必填项
    public static final int SYS_PARAMETER_REQUIRED_PARAM_NOT_INPUT = 1001001001;
    // 系统参数不存在
    public static final int SYS_PARAMETER_DATA_NOT_EXIST = 1001001002;
    /**
     * 机构
     */
    // 存在未填写的必填项
    public static final int SYS_INSTITUTION_REQUIRED_PARAM_NOT_INPUT = 1001002001;
    // 父机构不存在
    public static final int SYS_INSTITUTION_PARENT_NOT_EXIST = 1001002002;
    // 机构代码已存在
    public static final int SYS_INSTITUTION_CODE_EXIST = 1001002003;
    // 机构名称已存在
    public static final int SYS_INSTITUTION_NAME_EXIST = 1001002004;
    // 机构权限未配置
    public static final int SYS_INSTITUTION_AUTH_NOT_CONFIG = 1001002005;
    // 机构不存在
    public static final int SYS_INSTITUTION_NOT_EXIST = 1001002006;
    /**
     * 用户
     */
    // 存在未填写的必填项
    public static final int SYS_USER_REQUIRED_PARAM_NOT_INPUT = 1001003001;
    // 所属机构不存在
    public static final int SYS_USER_INSTITUTION_NOT_EXIST = 1001003002;
    // 登录账号已存在
    public static final int SYS_USER_ACT_EXIST = 1001003003;
    // 用户无效
    public static final int SYS_USER_NOT_INVALID = 1001003004;
    // 用户及密码错误
    public static final int SYS_USER_PWD_ERROR = 1001003005;
    // 用户登录超限
    public static final int SYS_USER_LIMIT_OUT = 1001003006;
    // 系统配置有误
    public static final int SYS_USER_CONFIG_ERROR = 1001003007;
    // 信息录入有误
    public static final int SYS_USER_DATA_INPUT_ERROR = 1001003008;
    /**
     * 角色
     */
    // 存在未填写的必填项
    public static final int SYS_ROLE_REQUIRED_PARAM_NOT_INPUT = 1001004001;
    // 所属机构不存在
    public static final int SYS_ROLE_INSTITUTION_NOT_EXIST = 1001004002;
    // 角色名称已存在
    public static final int SYS_ROLE_NAME_EXIST = 1001004003;
    /**
     * 字典
     */
    // 存在未填写的必填项
    public static final int SYS_DICTIONARY_REQUIRED_PARAM_NOT_INPUT = 1001005001;
    // 所属机构不存在
    public static final int SYS_DICTIONARY_INSTITUTION_NOT_EXIST = 1001005002;
    // 字典名称已存在
    public static final int SYS_DICTIONARY_NAME_EXIST = 1001004003;

    /** - 【基本数据中心】 - */
    /**
     * 尺码类型
     */
    // 存在未填写的必填项
    public static final int BASE_SIZETYPE_REQUIRED_PARAM_NOT_INPUT = 1002001001;
    // 所属机构不存在
    public static final int BASE_SIZETYPE_INSTITUTION_NOT_EXIST = 1002001002;
    // 名称已存在
    public static final int BASE_SIZETYPE_NAME_EXIST = 1002001003;
    // 尺码类型已被使用
    public static final int BASE_SIZETYPE_USES = 1002001004;
    /**
     * 尺码
     */
    // 存在未填写的必填项
    public static final int BASE_SIZE_REQUIRED_PARAM_NOT_INPUT = 1002002001;
    // 所属机构不存在
    public static final int BASE_SIZE_INSTITUTION_NOT_EXIST = 1002002002;
    // 名称已存在
    public static final int BASE_SIZE_NAME_EXIST = 1002002003;
    // 尺码已被使用
    public static final int BASE_SIZE_USESD = 1002002004;
    // 编号已存在
    public static final int BASE_SIZE_CODE_EXIST = 1002002005;
    /**
     * 颜色
     */
    // 存在未填写的必填项
    public static final int BASE_COLOR_REQUIRED_PARAM_NOT_INPUT = 1002003001;
    // 所属机构不存在
    public static final int BASE_COLOR_INSTITUTION_NOT_EXIST = 1002003002;
    // 名称已存在
    public static final int BASE_COLOR_NAME_EXIST = 1002003003;
    // 颜色已被使用
    public static final int BASE_SIZE_USES = 1002003004;
    // 编号已存在
    public static final int BASE_COLOR_CODE_EXIST = 1002003005;
    /**
     * 颜色类型
     */
    // 存在未填写的必填项
    public static final int BASE_COLORTYPE_REQUIRED_PARAM_NOT_INPUT = 1002003001;
    // 所属机构不存在
    public static final int BASE_COLORTYPEE_INSTITUTION_NOT_EXIST = 1002003002;
    // 名称已存在
    public static final int BASE_COLORTYPE_EXIST = 1002003003;
    // 尺码类型已被使用
    public static final int BASE_COLORTYPE_USES = 1002003004;
    /**
     * 客户
     */
    // 存在未填写的必填项
    public static final int BASE_CUSTOMER_REQUIRED_PARAM_NOT_INPUT = 1002004001;
    // 所属机构不存在
    public static final int BASE_CUSTOMER_INSTITUTION_NOT_EXIST = 1002004002;
    // 名字已存在
    public static final int BASE_CUSTOMER_NAME_EXIST = 1002004003;
    /**
     * 款式
     */
    // 存在未填写的必填项
    public static final int BASE_STYLE_REQUIRED_PARAM_NOT_INPUT = 1002005001;
    // 所属机构不存在
    public static final int BASE_STYLE_INSTITUTION_NOT_EXIST = 1002005002;
    // 编号已存在
    public static final int BASE_STYLE_CODE_EXIST = 1002005003;
    // 名称已存在
    public static final int BASE_STYLE_NAME_EXIST = 1002005004;
    /**
     * 工序
     */
    // 存在未填写的必填项
    public static final int BASE_STEP_REQUIRED_PARAM_NOT_INPUT = 1002006001;
    // 所属机构不存在
    public static final int BASE_STEP_INSTITUTION_NOT_EXIST = 1002006002;
    // 编号已存在
    public static final int BASE_STEP_CODE_EXIST = 1002006003;
    // 名称已存在
    public static final int BASE_STEP_NAME_EXIST = 1002006004;
    // 工序已被使用
    public static final int BASE_STEP_USED = 1002006005;

    /** - 【人事中心】 - */
    /**
     * 部门
     */
    // 存在未填写的必填项
    public static final int EMP_DEPT_REQUIRED_PARAM_NOT_INPUT = 1003001001;
    // 所属机构不存在
    public static final int EMP_DEPT_INSTITUTION_NOT_EXIST = 1003001002;
    // 名称已存在
    public static final int EMP_DEPT_NAME_EXIST = 1003001003;
    /**
     * 班组
     */
    // 存在未填写的必填项
    public static final int EMP_TEAM_REQUIRED_PARAM_NOT_INPUT = 1003002001;
    // 所属机构不存在
    public static final int EMP_TEAM_INSTITUTION_NOT_EXIST = 1003002002;
    // 名称已存在
    public static final int EMP_TEAM_NAME_EXIST = 1003002003;
    /**
     * 员工
     */
    // 存在未填写的必填项
    public static final int EMP_EMPLOYEE_REQUIRED_PARAM_NOT_INPUT = 1003003001;
    // 所属机构不存在
    public static final int EMP_EMPLOYEE_INSTITUTION_NOT_EXIST = 1003003002;
    // 工号已存在
    public static final int EMP_EMPLOYEE_CODE_EXIST = 1003003003;
    // 员工不存在
    public static final int EMP_EMPLOYEE_NOT_EXIST = 1003003004;
    /**
     * 工位机
     */
    // 存在未填写的必填项
    public static final int EMP_STATION_REQUIRED_PARAM_NOT_INPUT = 1003004001;
    // 所属机构不存在
    public static final int EMP_STATION_INSTITUTION_NOT_EXIST = 1003004002;
    // 编号已存在
    public static final int EMP_STATION_CODE_EXIST = 1003004003;

    /** - 【订单中心】 - */
    /**
     * 订单
     */
    // 存在未填写的必填项
    public static final int INVOICE_ORDER_REQUIRED_PARAM_NOT_INPUT = 1004001001;
    // 信息录入有误
    public static final int INVOICE_ORDER_DATA_INPUT_ERROR = 1004001002;
    // 所属机构不存在
    public static final int INVOICE_ORDER_INSTITUTION_NOT_EXIST = 1004001003;
    // 客户不存在
    public static final int INVOICE_ORDER_CUSTOMER_NOT_EXIST = 1004001004;
    // 款式不存在
    public static final int INVOICE_ORDER_STYLE_NOT_EXIST = 1004001005;
    // 尺码不存在
    public static final int INVOICE_ORDER_SIZE_NOT_EXIST = 1004001006;
    // 颜色不存在
    public static final int INVOICE_ORDER_COLOR_NOT_EXIST = 1004001007;
    // 编号已存在
    public static final int INVOICE_ORDER_CODE_EXIST = 1004001008;
    // 订单不存在
    public static final int INVOICE_ORDER_NOT_EXIST = 1004001009;
    // 机构不允许修改
    public static final int INVOICE_ORDER_INS_NOT_ALLOW_EDIT = 1004001010;
    // 订单已生产
    public static final int INVOICE_ORDER_HAS_MANUFACTURED = 1004001011;
    /**
     * 裁单
     */
    // 存在未填写的必填项
    public static final int INVOICE_CUT_PARAM_NOT_INPUT = 1004002001;
    // 信息录入有误
    public static final int INVOICE_CUT_DATA_INPUT_ERROR = 1004002002;
    // 所属机构不存在
    public static final int INVOICE_CUT_INSTITUTION_NOT_EXIST = 1004002003;
    // 编号已存在
    public static final int INVOICE_CUT_CODE_EXIT = 1004002004;
    // 尺码不存在
    public static final int INVOICE_CUT_SIZE_NOT_EXIST = 1004002005;
    // 颜色不存在
    public static final int INVOICE_CUT_COLOR_NOT_EXIST = 1004002006;
    // 裁剪数量有误
    public static final int INVOICE_CUT_COUNT_ERROR = 1004002007;
    // 裁单不存在
    public static final int INVOICE_CUT_NOT_EXIST = 1004002008;
    // 裁单已发卡
    public static final int INVOICE_CUT_HAS_CARD = 1004002009;

    /** - 【卡中心】 - */
    /**
     * 物料卡
     */
    // 存在未填写的必填项
    public static final int CARD_LOT_PARAM_NOT_INPUT = 1005001001;
    // 信息录入错误
    public static final int CARD_LOT_DATA_INPUT_ERROR = 1005001002;
    // 已制卡
    public static final int CARD_LOT_EXIST = 1005001003;
    // 扎不存在
    public static final int CARD_LOT_LOT_NOT_EXIST = 1005001004;
    // 员工不存在
    public static final int CARD_LOT_EMPLPYEE_NOT_EXIST = 1005001005;
    // 工序不存在
    public static final int CARD_LOT_STEP_NOT_EXIST = 1005001006;
    // 工位不存在
    public static final int CARD_LOT_STATION_NOT_EXIST = 1005001007;
    // 设备未注册
    public static final int CARD_LOT_R2000_NOT_REGISTER = 1005001008;

    /** - 【流水中心】 - */
    /**
     * 刷卡流水
     */
    // 存在未填写的必填项
    public static final int LINE_LOT_PARAM_NOT_INPUT = 1006001001;
    // 信息录入错误
    public static final int LINE_LOT_DATA_INPUT_ERROT = 1006001002;
    // 扎不存在
    public static final int LINE_LOT_LOT_NOT_EXIST = 1006001003;
    // 工序不存在
    public static final int LINE_LOT_STEP_NOT_EXIST = 1006001004;
    // 员工不存在
    public static final int LINE_LOT_EMPLOYEE_NOT_EXIST = 1006001005;

    /** - 【设备中心】 - */
    /**
     * R2000
     */
    // 存在未填写的必填项
    public static final int DEVICE_R2000_PARAM_NOT_INPUT = 1007001001;
    // 设备不存在
    public static final int DEVICE_R2000_R2000_NOT_EXIST = 1007001002;
    // 机构不存在
    public static final int DEVICE_R2000_INSTITUTION_NOT_EXIST = 1007001003;
    /**
     * 设备
     */
    // 存在未填写的必填项
    public static final int DEVICE_MACHINE_PARAM_NOT_INPUT = 1007002001;
    // 机构不存在
    public static final int DEVICE_MACHINE_INSTITUTION_NOT_EXIST = 1007002002;
    // 名称已存在
    public static final int DEVICE_MACHINE_NAME_EXIST = 1007002003;

    /**
     * - 【质检中心】 -
     */
    // 存在未填写的必填项
    public static final int QC_PARAM_NOT_INPUT = 1008001001;
    // 刷卡流水不存在
    public static final int QC_SWING_LINE_NOT_EXIST = 1008001002;
    // 质检原因不存在
    public static final int QC_REASON_ID_NOT_EXIST = 1008001003;

    /**
     * - 【报表中心】 -
     */
    // 存在未填写的必填项
    public static final int REPORT_PARAM_NOT_INPUT = 1009001001;
    // 机构不存在
    public static final int REPORT_INSTITUTION_NOT_EXIST = 1009001002;
    // 用户不存在
    public static final int REPORT_ACT_EXIST = 1009001003;

    /** - 【产线中心】 - */
    /**
     * 车间
     */
    // 存在未填写的必填项
    public static final int WORK_SHOP_PARAM_NOT_INPUT = 1010001001;
    // 机构不存在
    public static final int WORK_SHOP_INSTITUTION_NOT_EXIST = 1010001002;
    // 名称已存在
    public static final int WORK_SHOP_NAME_EXIST = 1010001003;
    // 车间已使用
    public static final int WORK_SHOP_USES = 1010001004;
    // 编号已存在
    public static final int WORK_SHOP_CODE_EXIST = 1010001005;
    /**
     * 产线
     */
    // 存在未填写的必填项
    public static final int PRODUCT_LINE_PARAM_NOT_INPUT = 1010002001;
    // 机构不存在
    public static final int PRODUCT_LINE_INSTUTITION_NOT_EXIST = 1010002002;
    // 车间不存在
    public static final int PRODUCT_LINE_WORK_SHOP_NOT_EXIST = 1010002003;
    // 名称已存在
    public static final int PRODUCT_LINE_NAME_EXIST = 1010001004;
    // 产线已使用
    public static final int PRODUCT_LINE_USES = 1010001005;
    // 编号已存在
    public static final int PRODUCT_LINE_CODE_EXIST = 1010001006;

    // 未选择辅料信息
    public static final int BASE_ACCESSORIES_NOT_EXIST = 1010001007;

    // 未录入包装效果图
    public static final int BASE_DRAWINGS_NOT_EXIST = 1010001008;

    //CAD路径信息
    public static final int FILE_PATH_NOT_EXIST = 1010001009;
}
