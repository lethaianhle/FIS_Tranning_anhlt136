package fis_training.controller;

import fis_training.dto.EvidenceDTO;
import fis_training.entity.Evidence;
import fis_training.service.EvidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/evidences")
public class EvidenceController {

}
