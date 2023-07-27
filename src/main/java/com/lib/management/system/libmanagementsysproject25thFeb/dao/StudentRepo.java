package com.lib.management.system.libmanagementsysproject25thFeb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.management.system.libmanagementsysproject25thFeb.models.User;

public interface StudentRepo extends JpaRepository<User, Integer> {

}
