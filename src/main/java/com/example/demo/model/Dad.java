package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_dad")
public class Dad {

    @Id
    @Column(name = "dad_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dadName;

    // TODO : DECLARE @OneToMany HERE IS OPTIONAL (NOT REQUIRED)
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "dad"
    )
    private List<Child> children;

    public Dad(String dadName) {
        this.dadName = dadName;
    }

    public Long getId() {
        return id;
    }

    public String getDadName() {
        return dadName;
    }
}
