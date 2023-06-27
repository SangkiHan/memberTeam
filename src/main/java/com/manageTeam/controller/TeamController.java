package com.manageTeam.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manageTeam.dto.MemberConditionDto;
import com.manageTeam.dto.TeamDto;
import com.manageTeam.service.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team")
public class TeamController {
	
	private final TeamService teamService;
	
	@PostMapping("/v1/save")
	public void save(@RequestBody TeamDto.Save request) {
		teamService.save(request);
	}

	@GetMapping("/v1/findById")
	public TeamDto.Info findById(@RequestBody TeamDto.Id request) {
		return teamService.findById(request);
	}
	
	@GetMapping("/v1/findAll")
	public Page<TeamDto.Info> findAllByCondition(MemberConditionDto conditionDto, Pageable pageable) {
		return teamService.findAllByCondition(conditionDto, pageable);
	}
}
