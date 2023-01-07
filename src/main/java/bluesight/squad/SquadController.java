package bluesight.squad;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/squad")
@Tag(name = "Operations the squads")
public class SquadController {

    private SquadService service;

    public SquadController(SquadService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get the Squads")
    public List<SquadDto> listAllSquad(){
        return service.listAllSquad();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a squad by id")
    public SquadDto findById(@PathVariable("id") Long id){
        return service.findById(id);
    }


}
