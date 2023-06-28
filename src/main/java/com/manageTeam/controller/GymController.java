package com.manageTeam.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manageTeam.dto.GymDto;
import com.manageTeam.service.GymService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gym")
public class GymController {
	
	private final GymService gymService;
	
	/*
	 * 체육관 저장
	 * */
	@PostMapping("/v1/save")
	public void save(@RequestBody GymDto.Save request) {
		gymService.save(request);
	}
	
}
