package com.example.express;

import com.example.express.common.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(Application.class, args);
        Environment env = application.getEnvironment();
        String ip = IPUtil.getServerIp();
        String port = env.getProperty("server.port");
        log.error(
                "\n\n-------------------------------- " +
                        "Express application started successfully!!!" +
                        " --------------------------------\n\n" +
                        "Local: \t\thttp://localhost:" + port + "/\n" +
                        "External: \thttp://" + ip + ":" + port + "/\n");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
