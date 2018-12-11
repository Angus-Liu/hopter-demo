package org.hopter.demo.model;

import lombok.Data;

/**
 * 客户
 *
 * @author Angus
 * @date 2018/12/11
 */
@Data
public class Customer {

    /**
     * ID
     */
    private long id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    /**
     * 照片
     */
    private String photo;
}
