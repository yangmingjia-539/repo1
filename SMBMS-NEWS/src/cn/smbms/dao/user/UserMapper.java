package cn.smbms.dao.user;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserMapper {
	//ͨ��userCode���user
	public User getLoginUser(@Param("userCode") String userCode) throws Exception;
}
