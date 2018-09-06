package config.springsecurity.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import config.springsecurity.entity.UserVO;


public interface UserVORepository extends CrudRepository<UserVO, Long>{   //extends JpaRepository的区别是什么？

    @Query("select u from UserVO u where u.username=:username")
    public UserVO findUserByName(@Param("username") String username);
    
}
