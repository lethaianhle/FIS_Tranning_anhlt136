package fis.training.controller;

import fis.training.dto.CriminalCaseDTO;
import fis.training.core.Result;
import fis.training.entity.CriminalCase;
import fis.training.enums.ResultEnums;
import fis.training.service.CriminalCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/criminal-cases")
public class CriminalCaseController {
    private final ModelMapper modelMapper;
    private final CriminalCaseService criminalCaseService;

    public CriminalCaseController(ModelMapper modelMapper, CriminalCaseService criminalCaseService) {
        this.criminalCaseService = criminalCaseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public Result<List<CriminalCaseDTO>> findAll(){
        try {
            List<CriminalCaseDTO> criminalCaseDTOList = criminalCaseService.findAll().stream()
                    .map(c -> modelMapper.map(c, CriminalCaseDTO.class))
                    .toList();

            return Result.success(criminalCaseDTOList);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result<CriminalCaseDTO> findById(@PathVariable(name="id") Long id){
        try {
            Optional<CriminalCase> criminalCase= criminalCaseService.findById(id);

            if (criminalCase.isEmpty()) {
                return Result.error(ResultEnums.ITEM_NOT_FOUND_ERROR);
            }

            CriminalCaseDTO criminalCaseResponse = modelMapper.map(criminalCase.get(),CriminalCaseDTO.class);
            return Result.success(criminalCaseResponse);

        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }

    @PostMapping()
    public Result<CriminalCaseDTO> create(@RequestBody CriminalCaseDTO criminalCaseDTO){
        try {
            CriminalCase criminalCaseCreated = criminalCaseService.createEntityByDTO(criminalCaseDTO);

            CriminalCaseDTO result = modelMapper.map(criminalCaseCreated, CriminalCaseDTO.class);

            return Result.success(result, ResultEnums.CREATED);

        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public  Result<CriminalCaseDTO> update(@PathVariable Long id, @RequestBody CriminalCaseDTO criminalCaseDTO){
        try {
            CriminalCase criminalCaseUpdated = criminalCaseService.updateEntityByDTO(id, criminalCaseDTO);

            CriminalCaseDTO result = modelMapper.map(criminalCaseUpdated, CriminalCaseDTO.class);

            return Result.success(result, ResultEnums.UPDATED);

        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteCriminalCase(@PathVariable(name="id") Long id){
        try {
            criminalCaseService.deleteById(id);

            return Result.success("Deleted Criminal Case with id: " + id);

        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }

}
