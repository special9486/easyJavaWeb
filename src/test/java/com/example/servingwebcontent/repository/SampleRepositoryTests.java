package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.database.entity.Sample;
import com.example.servingwebcontent.database.entity.SampleDetail;
import com.example.servingwebcontent.database.repository.SampleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SampleRepositoryTests {

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleRepositoryTests(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Test
    @Transactional
    public void findTest() throws Exception {
        final Optional<Sample> sampleOptional = sampleRepository.findById(3L);
        if (sampleOptional.isPresent()) {
            System.out.println("sample result = > " + sampleOptional.get());

            final List<SampleDetail> details = sampleOptional.get().getDetailList();
            System.out.println("Detail List=============");
            for (SampleDetail detail : details) {
                System.out.println("Detail Info => " + detail);
            }

        } else {
            System.out.println("Not Found...");
        }
    }
}
