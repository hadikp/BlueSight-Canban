package bluesight.col;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColService {

    private ModelMapper modelMapper;
    private ColRepository repository;


    public List<ColDto> findAllColumn() {
        List<Col> cols = repository.findAll();
        return cols.stream().map(c -> modelMapper.map(c, ColDto.class)).collect(Collectors.toList());
    }

    public ColDto findById(Long id) {
        Col col = repository.findById(id).orElseThrow(() -> new ColNotFoundException(id));
        return modelMapper.map(col, ColDto.class);
    }
}
