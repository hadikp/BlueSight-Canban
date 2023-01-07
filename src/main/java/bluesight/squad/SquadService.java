package bluesight.squad;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SquadService {

    private SquadRepository repository;
    private ModelMapper modelMapper;

    public List<SquadDto> listAllSquad() {
        List<Squad> squads = repository.findAll();
        return squads.stream().map(s -> modelMapper.map(s, SquadDto.class)).collect(Collectors.toList());
    }

    public SquadDto findById(Long id) {
        Squad squad = repository.findById(id).orElseThrow(() -> new SquadNotFoundException(id));
        return modelMapper.map(squad, SquadDto.class);
    }
}
