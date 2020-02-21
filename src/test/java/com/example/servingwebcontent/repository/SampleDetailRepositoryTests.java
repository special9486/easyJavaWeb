package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.database.entity.SampleDetail;
import com.example.servingwebcontent.database.repository.SampleDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
public class SampleDetailRepositoryTests {

    private final SampleDetailRepository sampleDetailRepository;

    @Autowired
    public SampleDetailRepositoryTests(SampleDetailRepository sampleDetailRepository) {
        this.sampleDetailRepository = sampleDetailRepository;
    }

    @Test
    @Transactional
    public void findTest() throws Exception {
        final Optional<SampleDetail> sampleDetailOptional = sampleDetailRepository.findById("2f46364670664e250170664e31580000");
        if (sampleDetailOptional.isPresent()) {
            System.out.println("result = > " + sampleDetailOptional.get());
        } else {
            System.out.println("Not Found...");
        }
    }
}
