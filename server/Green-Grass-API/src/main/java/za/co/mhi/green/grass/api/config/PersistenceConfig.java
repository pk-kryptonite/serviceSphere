package za.co.mhi.green.grass.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource driver = new DriverManagerDataSource();
    driver.setDriverClassName("org.postgresql.Driver");
    driver.setUrl("jdbc:postgresql:" + getDbLogin().get("db.url"));
    driver.setUsername(getDbLogin().get("db.user"));
    driver.setPassword(getDbLogin().get("db.password"));
    return driver;
  }

  @Bean (name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    LocalContainerEntityManagerFactoryBean factoryBean =
        new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource());
    factoryBean.setPackagesToScan("za.co.mhi.green.grass");
    factoryBean.setJpaVendorAdapter(vendorAdapter);
    factoryBean.setJpaProperties(hibernateConfigProperties());
    return factoryBean;
  }

  @Bean
  public Properties hibernateConfigProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
    return properties;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
    return transactionManager;
  }

  private Map<String, String> getDbLogin() {
    Map<String, String> dbDetails = new HashMap<>();
    String resourceName = "application.properties"; // could also be a constant
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
      Properties prop = new Properties();
      prop.load(resourceStream);
      dbDetails.put("db.url", prop.getProperty("db.url"));
      dbDetails.put("db.user", prop.getProperty("db.user"));
      dbDetails.put("db.password", prop.getProperty("db.password"));
      return dbDetails;
    } catch (IOException e) {
      throw new RuntimeException("Failed to load database access details.");
    }
  }
}
