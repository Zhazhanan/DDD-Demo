package org.huha.DDDdemo.domain;

import org.huha.DDDdemo.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
