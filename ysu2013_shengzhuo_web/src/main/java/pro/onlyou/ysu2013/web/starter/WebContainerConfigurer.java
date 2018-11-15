package pro.onlyou.ysu2013.web.starter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc   //相当于<mvc:annotation-driven />
@EnableTransactionManagement
@ComponentScan(
        basePackages = {
                "pro.onlyou.ysu2013.web.controller",
                "pro.onlyou.ysu2013.config"
        }
)
public class WebContainerConfigurer implements WebMvcConfigurer {

    /**
     * 配置除默认自动加载的转换器之外的自定义格式化器
     * 默认的有：Date,Number,JodaTime（类路径存在依赖时）等
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    /**
     * 配置验证器
     * By default,
     * if Bean Validation is present on the classpath
     * (for example, Hibernate Validator),
     * the LocalValidatorFactoryBean is registered as a
     * global Validator for use with
     * @Valid and Validated on controller method arguments.
     * @return
     */
    @Override
    public Validator getValidator() {
        return null;
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    /**
     * 配置静态资源访问
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/","public")
                .setCachePeriod(10);
    }

    /**
     * 配置DefaultServlet可用
     * 处理静态资源请求
     * 相当于 <mvc:default-servlet-handler/>
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * implements WebApplicationInitializer实现的方法
     */
//        @Override
//        public void onStartup(ServletContext servletContext) throws ServletException {
//                AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext =
//                        new AnnotationConfigWebApplicationContext();
//
//                //加载spingweb容器配置
//                annotationConfigWebApplicationContext.register(DataSourceConfigurer.class, ThymeleafConfigurer.class);
//                annotationConfigWebApplicationContext.refresh();
//
//                //创建DispatcherServlet并注册
//                DispatcherServlet dispatcherServlet =
//                        new DispatcherServlet(annotationConfigWebApplicationContext);
//                ServletRegistration.Dynamic registration =
//                        servletContext.addServlet("dispatcher",dispatcherServlet);
//                registration.setLoadOnStartup(1);
//                registration.addMapping("/");
//        }
}
