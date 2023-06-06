package ru.itconsulting.tech;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Component
public class Datasource {
    @Autowired
    private Environment env;

    @Bean("pgDs")
    @LiquibaseDataSource
    public DataSource getPostgresDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(env.getProperty("pg.spring.datasource.url"));
        dataSource.setUser(env.getProperty("pg.spring.datasource.username"));
        dataSource.setPassword(env.getProperty("pg.spring.datasource.password"));
        return dataSource;
    }

    @Bean(name = "pgEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getSessionFactoryPostgres(@Autowired DataSource pgDs) throws IOException {
        Properties properties = new Properties();

        // See: application.properties
        properties.put("hibernate.dialect", env.getProperty("pg.spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("pg.spring.jpa.show-sql"));
        properties.put("hbm2ddl.auto", env.getProperty("pg.spring.jpa.hibernate.ddl-auto"));
        properties.put("current_session_context_class", env.getProperty("pg.spring.jpa.properties.hibernate.current_session_context_class"));
        properties.put("hibernate.transaction.coordinator_class", "jta");

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        // Package contain entity classes
        em.setPackagesToScan("ru.itconsulting.dao.local");
        em.setDataSource(pgDs);
        em.setJpaProperties(properties);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean("orDs")
    @LiquibaseDataSource
    public DataSource getOracleDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(env.getProperty("or.spring.datasource.url"));
        dataSource.setUser(env.getProperty("or.spring.datasource.username"));
        dataSource.setPassword(env.getProperty("or.spring.datasource.password"));
        return dataSource;
    }

    @Bean(name = "orEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getSessionFactoryOracle(@Autowired DataSource orDs) throws IOException {
        Properties properties = new Properties();

        // See: application.properties
        properties.put("hibernate.dialect", env.getProperty("or.spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("or.spring.jpa.show-sql"));
        properties.put("hbm2ddl.auto", env.getProperty("or.spring.jpa.hibernate.ddl-auto"));
        properties.put("current_session_context_class", env.getProperty("or.spring.jpa.properties.hibernate.current_session_context_class"));
        properties.put("hibernate.transaction.coordinator_class", "jta");

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        // Package contain entity classes
        em.setPackagesToScan("ru.itconsulting.dao.local");
        em.setDataSource(orDs);
        em.setJpaProperties(properties);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

}
