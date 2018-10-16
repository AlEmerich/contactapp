package com.calinfo.contactapp.repository;

import com.calinfo.contactapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<AppUser, Long>
{
    AppUser findByUsername(String username);
}
