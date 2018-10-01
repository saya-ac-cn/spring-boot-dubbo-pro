package ac.cn.saya.serviceImpl;
import ac.cn.saya.dao.TransactionDAO;
import ac.cn.saya.entity.TransactionTypeEntity;
import ac.cn.saya.service.ITransactionService;
import ac.cn.saya.utils.log.Log4jUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: TransactionServiceImpl
 * @ProjectName MyDubbo
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/8/5 21:38
 * @Description:交易类别业务层实现类
 */

@Service(version="1.0.0")
public class TransactionServiceImpl implements ITransactionService {

    private static final Logger logger = Logger.getLogger(TransactionServiceImpl.class);

    @Resource
    @Qualifier("transactionDAO")
    private TransactionDAO transactionDAO;


    @Override
    public List<TransactionTypeEntity> getTransactionType(Integer id) throws Exception {
        List<TransactionTypeEntity> list = new ArrayList<TransactionTypeEntity>();
        try {
            logger.error("执行service-index公共查询接口");
            list = transactionDAO.getTransactionType(id);
        } catch (Exception e) {
            logger.error("service-index公共查询接口失败，详情："+ Log4jUtils.getTrace(e));
            throw new Exception("service-index公共查询接口失败:"+Log4jUtils.getTrace(e));
        }
        return list;
    }

    /**
     * 查询[类别号]交易类别数据
     * @param id
     * @return
     */
    @Override
    public List<TransactionTypeEntity> queryById(Integer id) {
        List<TransactionTypeEntity> list = new ArrayList<TransactionTypeEntity>();
        list.add(new TransactionTypeEntity(id+1,"类别"+(id+1)));
        list.add(new TransactionTypeEntity(id+1,"类别"+(id+1)));
        list.add(new TransactionTypeEntity(id+1,"类别"+(id+1)));
        list.add(new TransactionTypeEntity(id+1,"类别"+(id+1)));
        list.add(new TransactionTypeEntity(id+1,"类别"+(id+1)));
        list.add(new TransactionTypeEntity(id+1,"类别"+(id+1)));
        return list;
    }

}
