package cybersoft.javabackend.java12.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java12.gira.common.ResponseHandler;
import cybersoft.javabackend.java12.gira.role.dto.CreateGroupDto;
import cybersoft.javabackend.java12.gira.role.dto.CreateRoleDto;
import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.role.entity.Role;
import cybersoft.javabackend.java12.gira.role.service.itf.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {

	private GroupService service;

	public GroupController(GroupService service) {
		this.service = service;
	}
	
	@GetMapping
	public Object findAllRole() {
		List<Group> groups = service.findAll();
		
		return ResponseHandler.getResponse(groups, HttpStatus.OK);
	}
	
	@PostMapping
	public Object saveRole(@Valid @RequestBody CreateGroupDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		
		Group addGroup = service.addNewGroup(dto);
		
		return ResponseHandler.getResponse(addGroup, HttpStatus.CREATED);
	}
}
