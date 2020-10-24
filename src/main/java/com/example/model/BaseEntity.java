package com.example.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
class BaseEntity { //klasa package private - hermetyzacja dostępu do klasy

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate modificationDate;

    @Version
    private long version;
}
