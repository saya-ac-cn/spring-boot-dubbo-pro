package ac.cn.saya.utils.log;

import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * @Title: Log4jUtils
 * @ProjectName spring-boot-dubbo
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/9/3 23:57
 * @Description:
 */

public class Log4jUtils {

    /**
     * 日志记录
     * @param t
     * @return
     */
    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }


}
