package org.huha.DDDdemo.command;

import com.alibaba.cola.dto.Response;
import org.huha.DDDdemo.convertor.UserProfileConvertor;
import org.huha.DDDdemo.domain.user.UserProfile;
import org.huha.DDDdemo.dto.UserProfileUpdateCmd;
import org.huha.DDDdemo.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}