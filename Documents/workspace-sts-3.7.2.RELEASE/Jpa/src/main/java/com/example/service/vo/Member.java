package com.example.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by yongyeonkim on 2016. 7. 17..
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long number;
    private String id;
    private String pw;

    // setter / getter : 고급스럽게 어노테이션으로 처리 아래 입력사항 제거

//    public Member() {
//    }
//
//    public Member(String id, String pw) {
//        this.id = id;
//        this.pw = pw;
//    }
//
//    public long getNumber() {
//        return number;
//    }
//
//    public void setNumber(long number) {
//        this.number = number;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getPw() {
//        return pw;
//    }
//
//    public void setPw(String pw) {
//        this.pw = pw;
//    }
}
