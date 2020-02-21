package com.example.servingwebcontent.service;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import com.example.servingwebcontent.commons.ResultData;
import com.example.servingwebcontent.database.entity.Sample;
import com.example.servingwebcontent.database.entity.SampleDetail;
import com.example.servingwebcontent.database.repository.SampleDetailRepository;
import com.example.servingwebcontent.database.repository.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class SampleService {

    private final  SampleRepository sampleRepository;
    private final SampleDetailRepository sampleDetailRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository, SampleDetailRepository sampleDetailRepository) {
        this.sampleRepository = sampleRepository;
        this.sampleDetailRepository = sampleDetailRepository;
    }

    public ResultData addData(final String userId, final String userName) {
        final Sample sample = new Sample();
        sample.setUserId(userId);
        sample.setUserName(userName);

        sampleRepository.save(sample);
        log.info("Add Data No => {}", sample.getUserNo());

        return new ResultData(ResultCode.SUCCESS);
    }

    @Transactional
    public ResultData updateData(final Long userNo, final String userName) throws Exception {
        final Sample sample = this.getSampleAfterCheckHas(userNo);

        sample.setUserName(userName);
        sampleRepository.save(sample);
        return new ResultData(ResultCode.SUCCESS);
    }

    @Transactional
    public ResultData addSampleDetail(final Long userNo, final String fName, final Integer fAge) throws Exception {
        final Sample sample = this.getSampleAfterCheckHas(userNo);

        final SampleDetail sampleDetail = new SampleDetail();
        sampleDetail.setSample(sample);
        sampleDetail.setFriendName(fName);
        sampleDetail.setFriendAge(fAge);

        sampleDetailRepository.save(sampleDetail);
        return new ResultData(ResultCode.SUCCESS);
    }

    private Sample getSampleAfterCheckHas(final Long userNo) throws AppException {
        final Optional<Sample> optionalSample = sampleRepository.findById(userNo);
        if (!optionalSample.isPresent()) {
            throw new AppException(ResultCode.NOT_FOUND);
        }

        return optionalSample.get();
    }
}
