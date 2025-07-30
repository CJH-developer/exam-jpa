package com.example.exam_jpa.dto;

import com.example.exam_jpa.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	private String userid;
	private String password;
	private String name;
	private String email;
	private String hand_phone;
	private String useyn;
	
	/**
	 * @param userEntity
	 * @return
	 * 사용자 DTO -> 사용자엔티티
	 */
	public static UserDTO convertoUserDTO(UserEntity userEntity) {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserid(userEntity.getUserid());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setName(userEntity.getName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setHand_phone(userEntity.getHand_phone());
		userDTO.setUseyn(userEntity.getUseyn());
		
		return userDTO;
	}
}
