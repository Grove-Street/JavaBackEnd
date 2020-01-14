package pl.ug.virtualofficebackend.domain.workstation.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.workstation.boundary.WorkstationService;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkstationServiceImpl implements WorkstationService {
   private WorkstationRepository workstationRepository;

   @Autowired
   public WorkstationServiceImpl(WorkstationRepository workstationRepository) {
      this.workstationRepository = workstationRepository;
   }

   public boolean add(Workstation workstation) {
      try {
         this.workstationRepository.save(workstation);

         return true;
      } catch (Exception e) {
         e.printStackTrace();
      }

      return false;
   }

   public Workstation get(long id) {
      return this.workstationRepository.findById(id).orElse(null);
   }

   public List<Workstation> getAll() {
      return new ArrayList<>(this.workstationRepository.findAll());
   }
}
