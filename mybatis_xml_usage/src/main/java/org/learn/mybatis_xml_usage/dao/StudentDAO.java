package org.learn.mybatis_xml_usage.dao;

import org.learn.mybatis_xml_usage.pojo.Student;

import java.util.List;

public interface StudentDAO {
    /**
     * 查询所有列表
     *
     * @return List<Student>
     */
    List<Student> getStudents();
}
