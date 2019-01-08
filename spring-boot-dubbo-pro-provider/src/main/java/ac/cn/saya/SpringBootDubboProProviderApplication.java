package ac.cn.saya;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class SpringBootDubboProProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboProProviderApplication.class, args);
	}
}
