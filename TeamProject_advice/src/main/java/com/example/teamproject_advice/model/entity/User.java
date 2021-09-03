package com.example.teamproject_advice.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data               // getter, setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"boardList", "boardCommentList"})
@Builder
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    private String status;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

//    private Long userPhotoId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Board> boardList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<BoardComment> boardCommentList;
}
