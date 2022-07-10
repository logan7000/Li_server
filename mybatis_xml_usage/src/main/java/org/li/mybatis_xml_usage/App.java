package org.li.mybatis_xml_usage;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            runMybatisByXml();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 使用XML来运行mybatis
    public static void runMybatisByXml() throws IOException {
        // resource 目录下，在build后，会和当前包合并在一起
        final String resource = "org/li/mybatis_xml_usage/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //
    public static void runMybatisByResource() {
        //DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        //TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //Environment environment = new Environment("development", transactionFactory, dataSource);
        //Configuration configuration = new Configuration(environment);
        //configuration.addMapper(BlogMapper.class);
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }
}
