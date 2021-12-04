package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_mom")
public class Mom {

    @Id
    @Column(name = "mom_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String momName;

    // TODO : DECLARE @OneToMany HERE IS OPTIONAL (NOT REQUIRED)
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "mom"
    )
    private List<Child> children;

    public Mom(String momName) {
        this.momName = momName;
    }

    public Long getId() {
        return id;
    }

    public String getMomName() {
        return momName;
    }
}
