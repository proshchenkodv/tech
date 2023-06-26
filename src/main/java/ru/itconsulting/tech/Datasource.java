package ru.itconsulting.tech;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

//@Component
public class Datasource {
    @Autowired
    private Environment env;
    public static final int DEFAULT_TIMEOUT = 300;

    
//    @Bean("pgDs")
//    @LiquibaseDataSource
    public DataSource getPostgresDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(env.getProperty("pg.spring.datasource.url"));
        dataSource.setUser(env.getProperty("pg.spring.datasource.username"));
        dataSource.setPassword(env.getProperty("pg.spring.datasource.password"));
        return dataSource;
    }

    
//    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getSessionFactoryPostgres(@Autowired DataSource pgDs) throws IOException {
        Properties properties = new Properties();

        // See: application.properties
        properties.put("hibernate.dialect", env.getProperty("pg.spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("pg.spring.jpa.show-sql"));
//            properties.put("hbm2ddl.auto", env.getProperty("pg.spring.jpa.hibernate.ddl-auto"));
        properties.put("current_session_context_class", env.getProperty("pg.spring.jpa.properties.hibernate.current_session_context_class"));

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        // Package contain entity classes
        em.setPackagesToScan("ru.itconsulting.tech.dao");
        em.setDataSource(pgDs);
        em.setJpaProperties(properties);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    
//    @Bean
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDefaultTimeout(DEFAULT_TIMEOUT);
        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());
        return transactionManager;
    }

//    @Bean("orDs")
//    @LiquibaseDataSource
//    public DataSource getOracleDataSource() {
//        PGSimpleDataSource dataSource = new PGSimpleDataSource();
//        dataSource.setUrl(env.getProperty("or.spring.datasource.url"));
//        dataSource.setUser(env.getProperty("or.spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("or.spring.datasource.password"));
//        return dataSource;
//    }
//
//    @Bean(name = "orEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean getSessionFactoryOracle(@Autowired DataSource orDs) throws IOException {
//        Properties properties = new Properties();
//
//        // See: application.properties
//        properties.put("hibernate.dialect", env.getProperty("or.spring.jpa.properties.hibernate.dialect"));
//        properties.put("hibernate.show_sql", env.getProperty("or.spring.jpa.show-sql"));
//        properties.put("hbm2ddl.auto", env.getProperty("or.spring.jpa.hibernate.ddl-auto"));
//        properties.put("current_session_context_class", env.getProperty("or.spring.jpa.properties.hibernate.current_session_context_class"));
//        properties.put("hibernate.transaction.coordinator_class", "jta");
//
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//
//        // Package contain entity classes
//        em.setPackagesToScan("ru.itconsulting.dao.local");
//        em.setDataSource(orDs);
//        em.setJpaProperties(properties);
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        return em;
//    }

}
