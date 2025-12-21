package com.optical.net.permission.infrastructure.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
@Getter
@Setter
public class Permission {

    @Id
    private Long id;

    private String name;

}
