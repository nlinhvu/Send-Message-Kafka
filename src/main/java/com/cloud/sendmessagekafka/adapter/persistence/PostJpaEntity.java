package com.cloud.sendmessagekafka.adapter.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
class PostJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private String summary;
}
