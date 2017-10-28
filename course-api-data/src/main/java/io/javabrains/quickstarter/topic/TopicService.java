package io.javabrains.quickstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService
{
	@Autowired
	private TopicRepository topicRepository;
	
//    private List<Topic> topics =  new ArrayList<Topic>();
//
//    TopicService()
//    {
//        topics.add(new Topic("spring","Spring Framework","Spring Framework Description"));
//        topics.add(new Topic("java","Core Java","Core Java Description"));
//        topics.add(new Topic("javascript","JavaScript","JavaSCript Description"));
//    }
//    
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
    		new Topic("spring","Spring Framework","Spring Framework Description"),
    		new Topic("java","Core Java","Core Java Description"),
    		new Topic("javascript","JavaScript","JavaSCript Description")
    		));

    public List<Topic> getAllTopics()
    {
       ArrayList<Topic> t = new ArrayList<Topic>();
       
       Iterable<Topic> i = topicRepository.findAll();
       
       for(Topic to : i )
       {
    	   t.add(to);
       }
       
       return t;
    }

    public Topic getTopic(String id)
    {
//        for(Topic t: topics)
//        {
//            if(t.getId().equals(id))
//            {
//                return t;
//            }
//        }
    	
    	return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic)
    {
        topicRepository.save(topic);
    }

    public void updateTopics(String id, Topic topic)
    {
//        for(int i = 0; i < topics.size(); i++)
//        {
//            if(topics.get(i).getId().equals(id))
//            {
//                topics.set(i, topic);
//                return;
//            }
//        }
    	
    	topicRepository.save(topic);
    }

    public void delteTopic(String id)
    {
//        for(Topic t: topics)
//        {
//            if(t.getId().equals(id))
//            {
//                topics.remove(t);
//                break;
//            }
//        }
    	topicRepository.delete(id);
    }
}
