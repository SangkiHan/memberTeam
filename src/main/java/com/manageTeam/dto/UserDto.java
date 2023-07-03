package com.manageTeam.dto;

import com.manageTeam.entity.ActivateStatus;
import com.manageTeam.entity.Auth;

import lombok.Getter;

public class UserDto {
	
	@Getter
	public static class Save{
		private String userId;
		private Long team_id;
		private String password;
		private String username;
		private String rsdntRgnmb;
		private String phone;
		private AddressDto address;
		private Auth auth;
		private ActivateStatus activateStatus;
		
		public Save(String userId, Long team_id, String password, String username, String rsdntRgnmb, String phone,
				AddressDto address, Auth auth, ActivateStatus activateStatus) {
			this.userId = userId;
			this.team_id = team_id;
			this.password = password;
			this.username = username;
			this.rsdntRgnmb = rsdntRgnmb;
			this.phone = phone;
			this.address = address;
			this.auth = auth;
			this.activateStatus = activateStatus;
		}
	}

}
