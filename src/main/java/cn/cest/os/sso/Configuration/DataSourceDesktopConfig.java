package cn.cest.os.sso.Configuration;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "cn.cest.os.sso.mapper.desktop",sqlSessionTemplateRef  = "desktopSqlSessionTemplate")
public class DataSourceDesktopConfig {
    @Bean(name = "desktopDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.desktop")
    @Primary
    public DataSource testDataSource() {
        System.out.println("初始化desktop的数据源");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "desktopSqlSessionFactory")
    @Primary
    public SqlSessionFactory oldSqlSessionFactory(@Qualifier("desktopDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setTypeEnumsPackage("com.cn.slt.exchange.enums");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/old/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "oldSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("oldSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
