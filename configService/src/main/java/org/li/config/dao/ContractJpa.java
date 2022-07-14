package org.li.config.dao;

import org.li.config.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//表示这个是一个操作数据库的Repository类
public interface ContractJpa extends JpaRepository<Contract, Integer> {
}
