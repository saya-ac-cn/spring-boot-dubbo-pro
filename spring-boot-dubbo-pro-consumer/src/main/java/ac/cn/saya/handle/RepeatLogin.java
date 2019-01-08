package ac.cn.saya.handle;/**
 * Created by Administrator on 2018/9/30 0030.
 */

import ac.cn.saya.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @Title: RepeatLong
 * @ProjectName spring-boot-dubbo-pro
 * @Description: TODO
 * @Author Administrator
 * @Date: 2018/9/30 0030 23:39
 * @Description:
 */
@Component
public class RepeatLogin {

    private static RedisUtils redisUtils;

    @Autowired(required = true)
    public void setRedisUtils(RedisUtils redisUtils) {
        RepeatLogin.redisUtils = redisUtils;
    }

    private static SessionRepository sessionRepository;

    @Autowired(required = true)
    public static void setSessionRepository(SessionRepository sessionRepository) {
        RepeatLogin.sessionRepository = sessionRepository;
    }

    public static synchronized void delSession(HttpSession session){
        if(session != null){
            // 删除单一登录中记录的变量 
            if(session.getAttribute("user") != null)
            {
                String user = (String) session.getAttribute("user");
                //SessionListener.sessionMap.remove(user.getUser());
                redisUtils.hmDelete("DataCenter:SessionMap",user);
            }
        }
    }

    /**
     * 当发现账号已经被人登陆了，就将这个已经登陆上的人的Session从SessionListener.java中的HashMap里给
     * 拿到，并且移除在此HashMap中的记录并将session  invalidate掉
     * @param username
     */
    public static void forceUserLogout(String username)
    {
        //if(SessionListener.sessionMap.get( username ) != null)
        if(redisUtils.hmExists("DataCenter:SessionMap",username))
        {
            //HttpSession session = SessionListener.sessionMap.get( username );
            // 取出用户的SessionID
            String sessionID = (String) redisUtils.hmGet("DataCenter:SessionMap",username);
            //SessionListener.sessionMap.remove( username );
            // 删除HashMap中用户的的信息
            redisUtils.hmDelete("DataCenter:SessionMap",username);
            redisUtils.removePattern("DataCenter:Session:sessions:"+sessionID);// 采用硬编码删除Redis数据库中用户的session
//            Enumeration e = session.getAttributeNames();
//            while(e.hasMoreElements())
//            {
//                String sessionName = (String) e.nextElement();
//                session.removeAttribute( sessionName );
//            }
//            session.invalidate();
        }
    }


}
