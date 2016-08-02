package com.jn.security.mysql.dao;

import com.jn.security.mysql.po.domain.DbUserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by death on 2016/8/1.
 */
@Repository
public interface UserRepository extends JpaRepository<DbUserPo,String>,UserDao {




}
