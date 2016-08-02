package com.jn.security.mysql.dao;

import com.jn.security.mysql.po.domain.DbUserPo;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by death on 2016/8/1.
 */
@NoRepositoryBean
public interface UserDao {

//    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserDao.class);
//
//
//    public DbUserPo getDatabase(String username) {
//
//        List<DbUserPo> users = internalDatabase();
//
//        for (DbUserPo dbUserPo : users) {
//            if (dbUserPo.getUsername().equals(username) == true) {
//                logger.debug("User found");
//                return dbUserPo;
//            }
//        }
//        logger.error("User does not exist!");
//        throw new RuntimeException("User does not exist!");
//
//    }
//
//    /**
//     * 初始化数据
//     */
//    private List<DbUserPo> internalDatabase() {
//
//        List<DbUserPo> users = new ArrayList<DbUserPo>();
//        DbUserPo user = null;
//
//        user = new DbUserPo();
//        user.setUsername("admin");
//
//        // "admin"经过MD5加密后
//        user.setPassword("21232f297a57a5a743894a0e4a801fc3");
//        user.setAccess(1);
//
//        users.add(user);
//
//        user = new DbUserPo();
//        user.setUsername("user");
//
//        // "user"经过MD5加密后
//        user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
//        user.setAccess(2);
//
//        users.add(user);
//
//        return users;
//
//    }
}