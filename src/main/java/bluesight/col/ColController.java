package bluesight.col;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/col")
@Tag(name = "Operations with Column")
public class ColController {

    private ColService service;

    public ColController(ColService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Find all Column")
    public List<ColDto> findAllColumn(){
        return service.findAllColumn();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find one Column by id")
    public ColDto findColumnById(@PathVariable("id") Long id){
        return service.findById(id);
    }
}
