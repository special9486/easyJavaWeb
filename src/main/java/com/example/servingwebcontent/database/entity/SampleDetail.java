package com.example.servingwebcontent.database.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.helpers.MessageFormatter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class SampleDetail {

    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String detailId;

    @Column(length = 20)
    private String friendName;

    @Column
    private Integer friendAge;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private Sample sample;

    @Override
    public String toString() {
        final String msg = "detailId[{}], friendName[{}], friendAge[{}]";
        final Object[] data = {detailId, friendName, friendAge};
        return MessageFormatter.arrayFormat(msg, data).getMessage();
    }
}
