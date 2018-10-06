package com.catj.dao;

import com.catj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Long> {


    /**
     * 根据年纪和姓名查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 对于复杂查询可以使用@Query 编写sql
     * @param username
     * @return
     */
    @Query("from User u where u.username=:username")

    User findUser(@Param("username") String username);

}