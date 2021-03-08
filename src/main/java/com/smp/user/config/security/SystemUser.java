package com.smp.user.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SystemUser extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1354031527130615771L;
	
	private com.smp.user.model.User user;

    public SystemUser( com.smp.user.model.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public  com.smp.user.model.User getUser() {
        return user;
    }
}
