package com.example.exam_jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.exam_jpa.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="user")
public class UserEntity {

	@Id
	private String userid;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String hand_phone;
	
	@Column
	private String email;
	
	@Column
	private String useyn;
	
	/**
	 * @param userDTO
	 * @return
	 * 사용자 엔티티 -> 사용자 DTO
	 */
	public static UserEntity convertoUserEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUserid(userDTO.getUserid());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setName(userDTO.getName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setHand_phone(userDTO.getHand_phone());
		userEntity.setUseyn(userDTO.getUseyn());
		
		return userEntity;
	}
	
}
