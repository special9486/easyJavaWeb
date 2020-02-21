package com.example.servingwebcontent.database.entity;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.helpers.MessageFormatter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class Sample {

    @Id
    @GeneratedValue
    private Long userNo;

    @Column(length = 20)
    private String userId;

    @Column(length = 50)
    private String userName;

    @OneToMany(mappedBy = "sample")
    private List<SampleDetail> detailList;

    @Override
    public String toString() {
        final String msg = "userNo[{}], userId[{}], userName[{}]";
        final Object[] data = {userNo, userId, userName};
        return MessageFormatter.arrayFormat(msg, data).getMessage();
    }
}