    package com.kw.news.Component;

    import com.fasterxml.jackson.core.type.TypeReference;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
    import com.kw.news.model.News;
    import com.kw.news.repository.NewsRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.kafka.annotation.KafkaListener;
    import org.springframework.stereotype.Component;

    import java.io.IOException;
    import java.util.List;

    @Component
    public class KafkaConsumer {

        private final NewsRepository newsRepository;
        private final ObjectMapper objectMapper;

        @Autowired
        public KafkaConsumer(NewsRepository newsRepository) {
            this.newsRepository = newsRepository;
            this.objectMapper = new ObjectMapper();
            this.objectMapper.registerModule(new JavaTimeModule());
        }

        @KafkaListener(topics = "news_topic", groupId = "myGroup")
        public void listen(String message) {
            System.out.println("Received message: " + message);
            try {
                List<News> newsList = objectMapper.readValue(message, new TypeReference<List<News>>() {});
                for (News news : newsList) {
                    newsRepository.save(news);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }