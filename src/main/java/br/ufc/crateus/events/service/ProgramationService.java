package br.ufc.crateus.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.events.model.Programation;
import br.ufc.crateus.events.repository.ProgramationRepository;

@Service
public class ProgramationService {

	@Autowired
	ProgramationRepository ProgramationRepo;

	public Programation addProgramation(String name, String beginDate, String finishDate, String description,
			String startTime, String endTime, String presenter, int workload, String beginRegistration,
			String finishRegistration) {
		
		Programation Programation = new Programation(name, beginDate, finishDate, description, startTime,
			 endTime, presenter, workload, beginRegistration, finishRegistration);
		
		return ProgramationRepo.save(Programation);
	}

	public boolean removeProgramation(Integer id) {
		if (ProgramationRepo.existsById(id)) {
			ProgramationRepo.deleteById(id);
			return true;
		}

		return false;
	}

	public List<Programation> getProgramations() {
		return ProgramationRepo.findAll();
	}

	public Programation getProgramation(Integer id) {
		if (ProgramationRepo.existsById(id)) {
			return ProgramationRepo.findById(id).get();	
		} 
		
		return null;	
	}

	public Programation updateProgramation(Integer id, String name, String beginDate, String finishDate, String description,
			String startTime, String endTime, String presenter, int workload, String beginRegistration,
			String finishRegistration) {
		
		Programation programationAux = ProgramationRepo.findById(id).get();

		if (programationAux != null) {
			programationAux.setName(name);
			programationAux.setBeginDate(beginDate);
			programationAux.setFinishDate(finishDate);
			programationAux.setDescription(description);
			programationAux.setEndTime(endTime);
			programationAux.setStartTime(startTime);
			programationAux.setEndTime(endTime);
			programationAux.setPresenter(presenter);
			programationAux.setWorkload(workload);
			programationAux.setBeginRegistration(beginRegistration);
			programationAux.setFinishRegistration(finishRegistration);
			
			ProgramationRepo.save(programationAux);
		}

		return programationAux;
	}
}