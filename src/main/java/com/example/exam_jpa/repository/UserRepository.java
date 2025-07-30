package com.example.exam_jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exam_jpa.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	/**
	 * @param userid
	 * @return
	 * 사용자 아이디 기준 SELECT
	 */
	Optional<UserEntity> findByuserid(String userid);

	/**
	 * @param userid
	 * 사용자 DELETE
	 */
	void deleteByuserid(String userid);
}
