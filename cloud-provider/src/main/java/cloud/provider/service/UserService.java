package cloud.provider.service;

import cloud.provider.bean.User;
import cloud.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUsers(){
        return userMapper.queryAll();
    }

    public User getSingleUser(Integer id){
        return userMapper.getSingleUser(id);
    }

    public List<User> getSingleUserByName(String name){
        return userMapper.getSingleUserByName(name);
    }
}
