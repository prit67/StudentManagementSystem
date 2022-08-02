package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/listOfCourses")
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    // Get the student information
    @GetMapping("/Course/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return courseRepository.findById(id).get();
    }

    // Delete the student
    @DeleteMapping("/Course/{id}")
    public List<Course> deleteCourse(@PathVariable Integer id) {
        courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }

    // Add new student
    @PostMapping("/Course")
    public List<Course> addCourse(@RequestBody Course course) {

        courseRepository.save(course);
        return courseRepository.findAll();
    }

    // Update the student information
    @PutMapping("/Course/{id}")
    public List<Course> updateCourse(@RequestBody Course course, @PathVariable Integer id) {
        Course courseObj = courseRepository.findById(id).get();
        courseObj.setTitle(course.getTitle());
        courseObj.setDiscription(course.getDiscription());
        courseRepository.save(courseObj);
        return courseRepository.findAll();
    }

}