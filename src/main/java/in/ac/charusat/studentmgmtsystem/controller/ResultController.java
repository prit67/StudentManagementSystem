package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/Resultlist")
    public List<Result> getAllResult() {
        return resultRepository.findAll();
    }

    // Get the Result information
    @GetMapping("/Result/{id}")
    public Result getResult(@PathVariable Integer id) {
        return resultRepository.findById(id).get();
    }

    // Delete the Result
    @DeleteMapping("/Result/{id}")
    public List<Result> deleteResult(@PathVariable Integer id) {
        resultRepository.delete(resultRepository.findById(id).get());
        return resultRepository.findAll();
    }

    // Add new Result
    @PostMapping("/Result")
    public List<Result> addResult(@RequestBody Result result) {

        resultRepository.save(result);
        return resultRepository.findAll();
    }

    // Update the Result information
    @PutMapping("/Result/{id}")
    public List<Result> updateResult(@RequestBody Result result, @PathVariable Integer id) {
        Result resultObj = resultRepository.findById(id).get();
        resultObj.setSemester(result.getSemester());
        resultObj.setPercentage(result.getPercentage());
        resultRepository.save(resultObj);
        return resultRepository.findAll();
    }

}