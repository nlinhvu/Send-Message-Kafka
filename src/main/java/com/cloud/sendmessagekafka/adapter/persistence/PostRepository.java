package com.cloud.sendmessagekafka.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface PostRepository extends JpaRepository<PostJpaEntity, Long> {
}
