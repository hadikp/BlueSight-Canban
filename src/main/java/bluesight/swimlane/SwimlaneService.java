package bluesight.swimlane;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SwimlaneService {

    private ModelMapper modelMapper;
    private SwimlaneRepository repository;

    public List<SwimlaneDto> getAllSwimlane() {
        List<Swimlane> swimlanes = repository.findAll();
        return swimlanes.stream().map(s -> modelMapper.map(s, SwimlaneDto.class)).collect(Collectors.toList());
    }

    public SwimlaneDto getSwimlaneById(Long id) {
        Swimlane swimlane = repository.findById(id).orElseThrow(() -> new SwimlaneNotFoundException(id));
        return modelMapper.map(swimlane, SwimlaneDto.class);
    }
}
