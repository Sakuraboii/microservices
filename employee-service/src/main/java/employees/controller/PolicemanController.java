package employees.controller;

import employees.model.Policeman;
import employees.service.PolicemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/policeman")
public class PolicemanController {

    PolicemanService policemanService;

    @Autowired
    public PolicemanController(PolicemanService policemanService){
        this.policemanService = policemanService;
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping
    public List<Policeman> getAll(){
        return policemanService.getAll();
    }
}
