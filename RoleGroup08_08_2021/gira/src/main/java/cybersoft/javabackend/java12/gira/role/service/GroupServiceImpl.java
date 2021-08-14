package cybersoft.javabackend.java12.gira.role.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.java12.gira.role.dto.CreateGroupDto;
import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.role.repository.GroupRepository;
import cybersoft.javabackend.java12.gira.role.service.itf.GroupService;

@Service
public class GroupServiceImpl implements GroupService{

	private GroupRepository repository;
	
	public GroupServiceImpl(GroupRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Group> findAll() {
		return repository.findAll();
	}

	@Override
	public Group addNewGroup(@Valid CreateGroupDto dto) {

		Group g = new Group();
		g.setName(dto.getName());
		g.setDescription(dto.getDescription());
		
		return repository.save(g);
	}

}
