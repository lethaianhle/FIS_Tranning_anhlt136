package fis_training.controller;

import fis_training.core.Result;
import fis_training.dto.CriminalCaseDTO;
import fis_training.entity.CriminalCase;
import fis_training.enums.ResultEnums;
import fis_training.service.CriminalCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/criminal-cases")
public class CriminalCaseController {
    private ModelMapper modelMapper;
    private CriminalCaseService criminalCaseService;

    public CriminalCaseController(ModelMapper modelMapper, CriminalCaseService criminalCaseService) {
        this.criminalCaseService = criminalCaseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Result<List<CriminalCase>>> findAll(){
        List<CriminalCaseDTO> criminalCaseDTOList = criminalCaseService.findAll().stream()
                .map(c -> modelMapper.map(c, CriminalCaseDTO.class))
                .toList();

        return new ResponseEntity<>(Result.success(criminalCaseDTOList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<CriminalCaseDTO>> getCriminalCaseById(@PathVariable(name="id") Long id){
        Optional<CriminalCase> criminalCase= criminalCaseService.findById(id);

        if (criminalCase.isEmpty()) {
            return new ResponseEntity<>(Result.error(ResultEnums.ITEM_NOT_FOUND_ERROR), HttpStatus.NOT_FOUND);
        }

        CriminalCaseDTO criminalCaseResponse = modelMapper.map(criminalCase.get(),CriminalCaseDTO.class);
        return new ResponseEntity<>(Result.success(criminalCaseResponse), HttpStatus.FOUND);
    }

    @PostMapping(consumes = {"*/*"})
    public ResponseEntity<Result<CriminalCaseDTO>> createCriminalCase(@RequestBody CriminalCaseDTO criminalCaseDTO){
        CriminalCaseDTO result = null;

        try {
            CriminalCase criminalCaseCreated = criminalCaseService.update(modelMapper.map(criminalCaseDTO, CriminalCase.class));

            result = modelMapper.map(criminalCaseCreated, CriminalCaseDTO.class);

            return new ResponseEntity<>(Result.success(result), HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>(Result.error(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public  ResponseEntity<Result<CriminalCaseDTO>> updateCriminalCase(@PathVariable Long id, @RequestBody CriminalCase criminalCase){
        CriminalCaseDTO criminalCaseDTO = null;

        try {
            CriminalCase criminalCaseCreated = criminalCaseService.update(criminalCase);

            criminalCaseDTO = modelMapper.map(criminalCaseCreated, CriminalCaseDTO.class);

            return new ResponseEntity<>(Result.success(criminalCaseDTO), HttpStatus.CREATED);

        } catch (Exception ex) {
            return new ResponseEntity<>(Result.error(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result<String>> deleteCriminalCase(@PathVariable(name="id") Long id){

        criminalCaseService.deleteById(id);

        return new ResponseEntity<>(Result.success("Xóa thành công criminal case id: " + id), HttpStatus.OK);
    }

}
