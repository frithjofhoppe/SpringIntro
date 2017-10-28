package io.javabrains.quickstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService
{
	@Autowired
	private CourseRepository courseRepository;
	
//    private List<Topic> topics =  new ArrayList<Topic>();
//
//    TopicService()
//    {
//        topics.add(new Topic("spring","Spring Framework","Spring Framework Description"));
//        topics.add(new Topic("java","Core Java","Core Java Description"));
//        topics.add(new Topic("javascript","JavaScript","JavaSCript Description"));
//    }
//    
  

    public List<Course> getAllCourses(String topicId)
    {
       ArrayList<Course> t = new ArrayList<Course>();
       
       Iterable<Course> i = courseRepository.findByTopicId(topicId);
       
       for(Course to : i )
       {
    	   t.add(to);
       }
       
       return t;
    }

    public Course getCourse(String id)
    {
//        for(Topic t: topics)
//        {
//            if(t.getId().equals(id))
//            {
//                return t;
//            }
//        }
    	
    	return courseRepository.findOne(id);
    }

    public void addCourse(Course course)
    {
        courseRepository.save(course);
    }

    public void updateCourse(Course topic)
    {
//        for(int i = 0; i < topics.size(); i++)
//        {
//            if(topics.get(i).getId().equals(id))
//            {
//                topics.set(i, topic);
//                return;
//            }
//        }
    	
    	courseRepository.save(topic);
    }

    public void deleteCourse(String id)
    {
//        for(Topic t: topics)
//        {
//            if(t.getId().equals(id))
//            {
//                topics.remove(t);
//                break;
//            }
//        }
    	courseRepository.delete(id);
    }
}
