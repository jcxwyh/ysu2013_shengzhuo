package pro.onlyou.ysu2013.web.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan(
        basePackages = {
                "pro.onlyou.ysu2013.service",
                "pro.onlyou.ysu2013.repository",
                "pro.onlyou.ysu2013.entity"
        }
)
public class RootContainerConfigurer {

        @Bean
        public Executor taskScheduler(){
                ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();

                taskScheduler.setPoolSize(20);
                taskScheduler.setThreadNamePrefix("jcx-");
                taskScheduler.setAwaitTerminationSeconds(60);
                taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
                taskScheduler.setErrorHandler(t -> {
                        t.printStackTrace();
                });
                taskScheduler.setRejectedExecutionHandler((r,e) -> {
                        System.out.println("Reject Execute");
                });

                return taskScheduler;
        }
}
