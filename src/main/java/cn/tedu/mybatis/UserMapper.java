package cn.tedu.mybatis;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LeafDust
 * @create 2019-10-08 16:19
 */
public interface UserMapper {
    Integer insert(User user);
    Integer deleteById(Integer id);
    Integer deleteByIds(Integer[] ids);
    Integer updatePassword(String password);
    List<User> find(
            @Param("where") String where,
            @Param("orderBy") String orderBy,
            @Param("offset") Integer offset,
            @Param("count") Integer count);
}
