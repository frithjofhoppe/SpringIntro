package io.javabrains.quickstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TopicController
{
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> stringGetAllTopics()
    {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id)
    {
        return topicService.getTopic(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic)
    {
        topicService.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@PathVariable String id,@RequestBody Topic topic)
    {
        topicService.updateTopics(id,topic);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id)
    {
        topicService.delteTopic(id);
    }
}
