package com.example.springsocial.security;

import com.example.springsocial.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

public class UserPrincipal implements OAuth2User, UserDetails {
    private String id;
    private String email;
    private String password;
    private String roles;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public UserPrincipal(String usid, String email, String password, Collection<? extends GrantedAuthority> authorities,String roles) {
        this.id = usid;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.roles=roles;
    }


    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
                user.getUsid(),
                user.getEmail(),
                user.getPassword(),
                authorities,
                user.getRoles()
        );
    }

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
/*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
*/
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities=new ArrayList<>();
        User u=new User();
        System.out.println("asasdasd"+this.roles);
        u.setRoles(this.roles);
        /*
        u.getPermissionsList().forEach(p->{
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });*/

        u.getRoleList().forEach(r->{
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+r);
            authorities.add(authority);
        });
        return authorities;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }
}
