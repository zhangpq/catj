package com.catj.dao;

import com.catj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Long> {

    /**
     * 根据年纪查询用户
     * @param age
     * @return
     */
    User findByAge(Integer age);

    /**
     * 根据年纪和姓名查询
     * @param name
     * @param age
     * @return
     */
    User findByNameAndAge(String name, Integer age);

    /**
     * 对于复杂查询可以使用@Query 编写sql
     * @param name
     * @return
     */
    @Query("from User u where u.name=:name")

    User findUser(@Param("name") String name);

}