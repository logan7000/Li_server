package org.li.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class XMLUsage {
    public static void main(String[] args) {
        mybatisByXml();
    }

    private static void mybatisByXml() {
        final String resource = "org/li/mybatis_xml_usage/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                //UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                //User user = mapper.selectUser(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
