package cn.smbms.dao.user;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserMapper {
	//通过userCode获得user
	public User getLoginUser(@Param("userCode") String userCode) throws Exception;
}
