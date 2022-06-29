package org.learn.mybatis_xml_usage.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.learn.mybatis_xml_usage.pojo.Student;
import org.learn.mybatis_xml_usage.utils.MyBatisUtils;

import java.util.List;

/**
 * StudentDAO 严重功能
 */
public class StudentDAOTest {
    @Test
    public void test() {
        // 获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 执行 SQL 语句
        StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
        List<Student> students = mapper.getStudents();

        for (Student user : students) {
            System.out.println(user);
        }
        // 检验list
        Assert.assertNotNull(students);

        // 关闭 SqlSession
        sqlSession.close();
    }
}
