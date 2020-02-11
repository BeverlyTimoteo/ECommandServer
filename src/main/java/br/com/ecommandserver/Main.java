package br.com.ecommandserver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.com.ecommandserver.exception.ExceptionCustom;
import br.com.ecommandserver.util.SistemasOperacionais;

@SpringBootApplication(scanBasePackages = "br.com.ecommandserver")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public DataSource dataSource() throws Exception {
		Properties prop = getProp();

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://" + prop.getProperty("database.host") + ":"
				+ prop.getProperty("database.port") + "/" + prop.getProperty("database.name"));
		dataSource.setUsername(prop.getProperty("database.user"));
		dataSource.setPassword(prop.getProperty("database.password"));

		return dataSource;
	}

	public Properties getProp() throws Exception {
		File f;

		if (SistemasOperacionais.get() == SistemasOperacionais.WINDOWS.getId()) {
			f = new File("C:/ecommand/ecommand.properties");

		} else {
			f = new File("/ecommand/ecommand.properties");
		}

		if (!f.exists()) {
			throw new ExceptionCustom("Arquivo de configuração não encontrado!");
		}

		Properties props = new Properties();
		props.load(new FileInputStream(f));

		return props;
	}

}
