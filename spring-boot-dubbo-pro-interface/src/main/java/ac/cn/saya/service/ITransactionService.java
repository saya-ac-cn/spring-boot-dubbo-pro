package ac.cn.saya.service;


import ac.cn.saya.entity.TransactionTypeEntity;

import java.util.List;

/**
 * @Title: ITransactionService
 * @ProjectName MyDubbo
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/8/5 21:25
 * @Description:交易类别表对外业务层接口
 */

public interface ITransactionService {

    /**
     * 查询[类别号]交易类别数据
     * @param id
     * @return
     */
    public List<TransactionTypeEntity> getTransactionType(Integer id) throws Exception;

    /**
     * 查询[类别号]交易类别数据
     * @param id
     * @return
     */
    public List<TransactionTypeEntity> queryById(Integer id);

}
