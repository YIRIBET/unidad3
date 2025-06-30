package mx.edu.utez.unidad3.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/*
*@Configuration:le dice a  spring que esta clase de java va a
* generar una configuracion durante la ejecucion de la aplicacion,
* pero esta anotacion debe siempre ir con un metodo con la notacion
* bean que le diga que va configurar
*
* @Bean: le indica a spring el metodo que retornara dicha configuracion
 */
@Configuration

public class DBConnention {
    //private final String DB_URL = "url...";
    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.username}")
    private String DB_USERNAME;

    @Value("${db.password}")
    private String DB_PASSWORD;



    @Bean
    public DataSource getConnection(){
        try{
            DriverManagerDataSource configuration = new DriverManagerDataSource();
            configuration.setUrl(DB_URL);
            configuration.setUsername(DB_USERNAME);
            configuration.setPassword(DB_PASSWORD);
            /*
            * 1.-como si fuera pagina: com.mysql
            * 2.-GTA SA: cj
            * 3.-protocolo de base de datos: jdbc
            * 4.-Clase : Driver
            * */
            configuration.setDriverClassName("com.mysql.cj.jdbc.Driver");
            return configuration;

        }catch (Exception ex){
            System.out.println("Error al conectar la BD");
            ex.printStackTrace();
            return null;
        }
    }
}
