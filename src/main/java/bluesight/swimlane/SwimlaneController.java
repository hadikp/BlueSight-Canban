package bluesight.swimlane;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/swimlane")
@Tag(name = "Operations the Swimlane")
public class SwimlaneController {

    private SwimlaneService service;

    public SwimlaneController(SwimlaneService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "get all Swimlane")
    public List<SwimlaneDto> getAllSwimlane(){
        return service.getAllSwimlane();
    }

    @GetMapping("/{id}")
    @Operation(summary = "get Swimlane by id")
    public SwimlaneDto getSwimlaneById(@PathVariable("id") Long id){
        return service.getSwimlaneById(id);
    }
}
