package com.qdillion.zooma.admin.config;

import com.qdillion.zooma.admin.util.QdillionZoomaSessionInterceptor;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.qdillion.zooma.admin.**")
@MapperScan(basePackages = "com.qdillion.zooma.admin.dao", annotationClass = Mapper.class)
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class QdillionZoomaAdminConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private Environment env;


    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFatory(DataSource datasource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(datasource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        sqlSessionFactory.setTypeAliasesPackage("com.qdillion.zooma.admin.model");
        // META-INF/mybatis/mappers 패키지 이하의 모든 XML을 매퍼로 등록
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        registry.addResourceHandler("/resources/**").addResourceLocations(
                "/resources/**");
    }

    /**
     * <pre>
     * Return Type을 JSON으로 사용하고 싶을 경우 설정을 해줘야 한다.<br />
     * 없을 경우
     * "The resource identified by this request is only capable of generating responses with characteristics not acceptable according to the request "accept" headers."
     * 오류가 발생한다. <br />
     *
     * XML 설정은 아래와 같다.
     * <mvc:annotation-driven  content-negotiation-manager="contentNegotiationManager" />
     * <bean id="contentNegotiationManager" class="org.springframework.web.accept.ContentNegotiationManagerFactoryBean">
     *      <property name="favorPathExtension" value="false" />
     *      <property name="favorParameter" value="true" />
     *      <property name="mediaTypes" >
     *           <value>
     *                json=application/json
     *                xml=application/xml
     *           </value>
     *      </property>
     * </bean>
     * </pre>
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false)
                .favorParameter(true)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_ATOM_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        QdillionZoomaSessionInterceptor loginInterceptor = new QdillionZoomaSessionInterceptor();
        loginInterceptor.setUnCheckedUrl("^/test/*");
        registry.addInterceptor(loginInterceptor);

    }

}
