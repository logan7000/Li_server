package org.li.springboot_examples.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private static final long serialVersionUID = -1840831686851699943L;

    private int id;
    private String name;
}
