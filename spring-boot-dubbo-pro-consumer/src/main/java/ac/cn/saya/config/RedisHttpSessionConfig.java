package ac.cn.saya.config;/**
 * Created by Administrator on 2018/9/30 0030.
 */

import ac.cn.saya.handle.SessionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.SessionEventHttpSessionListenerAdapter;

import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: RedisSessionConfig
 * @ProjectName spring-boot-dubbo-pro
 * @Description: TODO
 * @Author Administrator
 * @Date: 2018/9/30 0030 21:08
 * @Description:
 */
@Configuration
// redisNamespace 存储空间
// maxInactiveIntervalInSeconds session超时时间,单位秒
@EnableRedisHttpSession(redisNamespace = "DataCenter:Session",maxInactiveIntervalInSeconds = 1800)
public class RedisHttpSessionConfig {

    @Bean
    public SessionEventHttpSessionListenerAdapter sessionEventHttpSessionListenerAdapter() {
        List<HttpSessionListener> httpSessionListeners = new ArrayList<HttpSessionListener>();
        httpSessionListeners.add(new SessionListener());
        return new SessionEventHttpSessionListenerAdapter(httpSessionListeners);
    }




}
