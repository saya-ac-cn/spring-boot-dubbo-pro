package ac.cn.saya.controller;

import ac.cn.saya.handle.RepeatLogin;
import ac.cn.saya.service.ITransactionService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ac.cn.saya.utils.RedisUtils;
import javax.servlet.http.HttpSession;


/**
 * Created by saya on 2018/9/6.
 */
@RestController
public class HomeController {

    @Reference(version = "1.0.0")
    private ITransactionService transactionService;

    @Autowired
    private  RedisUtils redisUtils;

    @RequestMapping("/transaction")
    public String consume() throws Exception {
        Gson gson = new Gson();
        return gson.toJson(transactionService.getTransactionType(null));
    }

    @GetMapping("/online")
    public String getOnlien(HttpSession session)
    {
        String getUser = (String) session.getAttribute("user");
        if(getUser == null)
        {
            return "未登录";
        }
        return getUser;
    }

    @GetMapping("/login")
    public String session(@RequestParam(value = "user") String user, HttpSession session){
        //if(SessionListener.sessionMap.get(user) != null)
        if(redisUtils.hmExists("DataCenter:SessionMap",user))
        {
            /**
             * 将已经登陆的信息拿掉,将新的用户登录信息放进去
             */
            RepeatLogin.forceUserLogout(user);
            //SessionListener.sessionMap.put(user,session);
            redisUtils.hmSet("DataCenter:SessionMap",user,session.getId());
        }
        else
        {
            /**
             * 该账号未被登陆
             */
            //SessionListener.sessionMap.put(user,session);
            redisUtils.hmSet("DataCenter:SessionMap",user,session.getId());
        }
        //设置session
        session.setAttribute("user",user);
        //获取session
        String website=session.getAttribute("user").toString();
        return website;
    }


}
