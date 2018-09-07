package ac.cn.saya.entity;

import java.io.Serializable;

/**
 * @Title: TransactionTypeEntity
 * @ProjectName MyDubbo
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/8/5 21:28
 * @Description:交易类别表模型
 */

public class TransactionTypeEntity implements Serializable {


    private static final long serialVersionUID = 5156612384141543438L;
    private Integer id;//类别号
    private String transactionType;//类别描述

    public TransactionTypeEntity() {
    }

    public TransactionTypeEntity(Integer id, String transactionType) {
        this.id = id;
        this.transactionType = transactionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "交易编号：" + id + ", 类别描述：'" + transactionType;
    }
}
