package org.li.config.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 合同信息;
 *
 * @author : 云龙
 * @date : 2022-7-14
 */
@Entity
@Table(name = "t_contract")
public class Contract implements Serializable, Cloneable {
    /**
     * 主键ID
     */
    @Id
    @ApiModelProperty(name = "主键ID", notes = "")
    private String id;
    /**
     * 合同名称
     */
    @ApiModelProperty(name = "合同名称", notes = "")
    private String name;
    /**
     * 合同类型
     */
    @ApiModelProperty(name = "合同类型", notes = "")
    private String type;
    /**
     * 支付类型
     */
    @ApiModelProperty(name = "支付类型", notes = "")
    private String paytype;
    /**
     * 金额
     */
    @ApiModelProperty(name = "金额", notes = "")
    private String amount;
    /**
     * 甲方
     */
    @ApiModelProperty(name = "甲方", notes = "")
    private String firstpart;
    /**
     * 乙方
     */
    @ApiModelProperty(name = "乙方", notes = "")
    private String thirdpart;
    /**
     * 签订时间
     */
    @ApiModelProperty(name = "签订时间", notes = "")
    private String signtime;

    /**
     * 主键ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 合同名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 合同名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 合同类型
     */
    public String getType() {
        return this.type;
    }

    /**
     * 合同类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 支付类型
     */
    public String getPaytype() {
        return this.paytype;
    }

    /**
     * 支付类型
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    /**
     * 金额
     */
    public String getAmount() {
        return this.amount;
    }

    /**
     * 金额
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 甲方
     */
    public String getFirstpart() {
        return this.firstpart;
    }

    /**
     * 甲方
     */
    public void setFirstpart(String firstpart) {
        this.firstpart = firstpart;
    }

    /**
     * 乙方
     */
    public String getThirdpart() {
        return this.thirdpart;
    }

    /**
     * 乙方
     */
    public void setThirdpart(String thirdpart) {
        this.thirdpart = thirdpart;
    }

    /**
     * 签订时间
     */
    public String getSigntime() {
        return this.signtime;
    }

    /**
     * 签订时间
     */
    public void setSigntime(String signtime) {
        this.signtime = signtime;
    }
}