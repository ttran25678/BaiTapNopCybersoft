package cybersoft.javabackend.java12.gira.role.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.java12.gira.role.dto.CreateProgramDto;
import cybersoft.javabackend.java12.gira.role.entity.Program;
import cybersoft.javabackend.java12.gira.role.repository.ProgramRepository;
import cybersoft.javabackend.java12.gira.role.service.itf.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService{

	private ProgramRepository repository;

	public ProgramServiceImpl(ProgramRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Program> findAll() {
		return repository.findAll();
	}

	@Override
	public Program addNewProgram(@Valid CreateProgramDto dto) {
		Program p = new Program();
		p.setName(dto.getName());
		p.setMethod(dto.getMethod());
		p.setPath(dto.getPath());
		
		return repository.save(p);
	}
	
	
	
	
}
