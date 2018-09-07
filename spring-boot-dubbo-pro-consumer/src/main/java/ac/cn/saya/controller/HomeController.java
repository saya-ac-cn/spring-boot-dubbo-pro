package ac.cn.saya.controller;

import ac.cn.saya.service.ITransactionService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by saya on 2018/9/6.
 */
@RestController
public class HomeController {

    @Reference(version = "1.0.0")
    private ITransactionService transactionService;


    @RequestMapping("/transaction")
    public String consume() throws Exception {
        Gson gson = new Gson();
        return gson.toJson(transactionService.getTransactionType(null));
    }


}
