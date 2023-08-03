package com.authorization.secretposts.repos;

import com.authorization.secretposts.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    public SiteUser findSiteUserByUserName(String userName);
}
