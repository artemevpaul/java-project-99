package hexlet.code.service.imlementations;

import hexlet.code.dto.label.LabelCreateDTO;
import hexlet.code.dto.label.LabelDTO;
import hexlet.code.dto.label.LabelUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.LabelMapper;
import hexlet.code.repository.LabelRepository;
import hexlet.code.service.LabelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LabelServiceImpl implements LabelService {

    private final LabelMapper labelMapper;

    private final LabelRepository labelRepository;

    public List<LabelDTO> getAll() {
        var label = labelRepository.findAll();
        return label.stream()
                .map(labelMapper::map)
                .toList();
    }

    public LabelDTO findById(Long id) {
        var label = labelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Label with id " + id + " not found")));
        return labelMapper.map(label);
    }

    public LabelDTO create(LabelCreateDTO labelCreate) {
        var label = labelMapper.map(labelCreate);
        labelRepository.save(label);
        return labelMapper.map(label);
    }

    public LabelDTO update(Long id, LabelUpdateDTO labelUpdateDTO) {
        var label = labelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Label with id " + id + " not found")));
        labelMapper.update(labelUpdateDTO, label);
        labelRepository.save(label);
        var labelDto = labelMapper.map(label);
        return labelDto;
    }

    public void delete(Long id) {
        labelRepository.deleteById(id);
    }
}
