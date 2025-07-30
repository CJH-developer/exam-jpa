package com.example.exam_jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.exam_jpa.controller.UserController;
import com.example.exam_jpa.dto.UserDTO;
import com.example.exam_jpa.entity.UserEntity;
import com.example.exam_jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	/**
	 * @param
	 * 회원가입 : 사용자 정보 저장
	 */
	public void save(UserDTO userDTO) {
		UserEntity userEntity = UserEntity.convertoUserEntity(userDTO);
		userRepository.save(userEntity);
	}

	/**
	 * @param userDTO
	 * @return
	 * 로그인
	 */
	public UserDTO login(UserDTO userDTO) {
		Optional<UserEntity> findUser = userRepository.findByuserid(userDTO.getUserid());
		
		if(findUser.isPresent()) {
			
			UserEntity userEntity = findUser.get();
			
			if(userEntity.getPassword().equals(userDTO.getPassword())) {
				UserDTO dto = UserDTO.convertoUserDTO(userEntity);
				return dto;
			}else return null;
			
		}else return null;
		
	}

	/**
	 * @return
	 * 전체 사용자 목록 조회
	 */
	public List<UserDTO> findAll() {
		
		List<UserEntity> userEntityList = userRepository.findAll();
		List<UserDTO> userDTOList = new ArrayList<>();
		
		for(UserEntity userEntity : userEntityList) {
			userDTOList.add(UserDTO.convertoUserDTO(userEntity));
		}
		return userDTOList;
	}

	/**
	 * @param userid
	 * @return
	 * 사용자 상세 조회
	 */
	public UserDTO detail(String userid) {
		Optional<UserEntity> userEntity = userRepository.findByuserid(userid);
		if(userEntity.isPresent()) {
			return UserDTO.convertoUserDTO(userEntity.get());
		}else {
			return null;
		}
	}

	/**
	 * @param userDTO
	 * 사용자 정보 수정
	 */
	public void update(UserDTO userDTO) {
		userRepository.save(UserEntity.convertoUserEntity(userDTO));
	}
	
	
}
