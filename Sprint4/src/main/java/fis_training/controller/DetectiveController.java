package fis_training.controller;

import fis_training.dto.DetectiveDTO;
import fis_training.entity.Detective;
import fis_training.service.DetectiveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/v1/detectives")
public class DetectiveController {

}
