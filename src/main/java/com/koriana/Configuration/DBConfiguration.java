package com.koriana.Configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration											//Configuration: 지정된 클래스를 자바 기반의 설정 파일로 인식
@PropertySource("classpath:/application.properties")	//PropertySource: 해당클래스에서 참조할 properties파일 위치 지정
public class DBConfiguration {
	
	@Autowired											//Autowired: Bean으로 등록된 객체를 클래스에 주입할 때 사용
	private ApplicationContext ApplicationContext;
	
	@Bean												//Bean: Spring에 의하여 생성하고 관리하는 객체
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig(){
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setMapperLocations(ApplicationContext.getResources("classpath:/mappers/**/*.xml"));
		factoryBean.setTypeAliasesPackage("com.koriana.*");
		factoryBean.setConfiguration(mybatisConfig());
		return factoryBean.getObject();
	}
	
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	@ConfigurationProperties(prefix= "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
}
