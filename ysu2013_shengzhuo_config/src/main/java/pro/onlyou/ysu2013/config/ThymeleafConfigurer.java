package pro.onlyou.ysu2013.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@PropertySource(
        value = "classpath:application.properties",
        encoding = "UTF-8"

)
public class ThymeleafConfigurer {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${thymeleaf.cacheable}")
    private boolean cacheable;

    @Value("${thymeleaf.encoding}")
    private String encoding;

    @Value("${thymeleaf.prefix}")
    private String prefix;

    @Value("${thymeleaf.suffix}")
    private String suffix;

    @Value("${thymeleaf.mode}")
    private String mode;

    /**
     * 配置模板解析器
     * @return
     */
    @Bean(name = "templateResolver")
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver =
                new SpringResourceTemplateResolver();

        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setCacheable(cacheable);
        templateResolver.setCharacterEncoding(encoding);
        templateResolver.setPrefix(prefix);
        templateResolver.setSuffix(suffix);
        templateResolver.setTemplateMode(mode);

        return templateResolver;
    }

    /**
     * 配置模板引擎
     * @return
     */
    @Bean(name = "templateEngine")
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine =
                new SpringTemplateEngine();

        templateEngine.setTemplateResolver(this.templateResolver());
        templateEngine.setEnableSpringELCompiler(true);

        return templateEngine;
    }

    @Bean(name = "viewResolver")
    public ViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver =
                new ThymeleafViewResolver();

        viewResolver.setTemplateEngine(this.templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }
}
