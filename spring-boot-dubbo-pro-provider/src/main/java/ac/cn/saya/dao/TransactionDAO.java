package ac.cn.saya.dao;

import ac.cn.saya.entity.TransactionTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 交易DAO层
 */
@Mapper
@Repository("transactionDAO")
public interface TransactionDAO {

    /**
     * 查询交易类别[选填编号]
     * @param id
     * @return
     */
    public List<TransactionTypeEntity> getTransactionType(@Param("id") Integer id);

}
