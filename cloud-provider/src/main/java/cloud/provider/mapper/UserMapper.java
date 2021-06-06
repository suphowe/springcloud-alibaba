package cloud.provider.mapper;

import cloud.provider.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    @Select("select id,username,password from sys_user")
    List<User> queryAll();

    @Select("select id,username,password from sys_user where id=#{id}")
    User getSingleUser(Integer id);

    @Select("select id,username,password from sys_user where username like concat('%',#{name},'%')")
    List<User> getSingleUserByName(String name);
}
