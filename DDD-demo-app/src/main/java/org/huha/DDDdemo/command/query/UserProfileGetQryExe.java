package org.huha.DDDdemo.command.query;

import com.alibaba.cola.dto.SingleResponse;
import org.huha.DDDdemo.dto.UserProfileGetQry;
import org.huha.DDDdemo.dto.clientobject.UserProfileCO;
import org.huha.DDDdemo.gatewayimpl.database.UserProfileMapper;
import org.huha.DDDdemo.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileGetQryExe {

    @Resource
    private UserProfileMapper userProfileMapper;

    public SingleResponse<UserProfileCO> execute(UserProfileGetQry qry) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(qry.getUserId());
        UserProfileCO userProfileCO = new UserProfileCO();
        BeanUtils.copyProperties(userProfileDO, userProfileCO);
        return SingleResponse.of(userProfileCO);
    }

}
