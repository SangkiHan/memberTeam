package com.manageTeam.repository.impl;

import static com.manageTeam.entity.QUser.user;

import java.util.Optional;

import com.manageTeam.config.security.CustumUserDetails;
import com.manageTeam.dto.AddressDto;
import com.manageTeam.dto.UserDto;
import com.manageTeam.entity.ActivateStatus;
import com.manageTeam.repository.UserRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{

	private final JPAQueryFactory queryFactory;
	
	@Override
	public Optional<UserDto.Info> findUserInfo(String userId) {
		Optional<UserDto.Info> results = Optional.ofNullable(queryFactory
				.select(Projections.bean(UserDto.Info.class,
						user.userId,
						user.team.teamId,
						user.team.teamName,
						user.password,
						user.username,
						user.rsdntRgnmb,
						user.phone,
						Projections.bean(AddressDto.class,
								user.address.city,
								user.address.street,
								user.address.zipcode
								).as("address"),
						user.auth,
						user.activateStatus
						))
				.from(user)
				.where(user.userId.eq(userId))
				.fetchOne());
		
		return results;
	}

	@Override
	public boolean existsByRsdntRgnmb(String rsdntRgnmb) {
		return queryFactory
				.select(user.count())
				.from(user)
				.where(user.activateStatus.eq(ActivateStatus.YES))
				.fetchOne() < 0;
	}

	@Override
	public CustumUserDetails findUser(String userId) {
		return queryFactory
				.select(Projections.bean(CustumUserDetails.class, 
						user.userId.as("username"),
						user.password
						))
				.from(user)
				.where(user.userId.eq(userId))
				.fetchOne();
	}
}
