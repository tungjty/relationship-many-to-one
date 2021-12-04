package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_child")
public class Child {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "child_sequence"
    )
    @SequenceGenerator(
            name = "child_sequence",
            sequenceName = "child_id_seq",
            allocationSize = 1
    )
    @Column(name = "child_id")
    private Long id;

    String childName;

    @ManyToOne(
            // DO NOT USE 'CascadeType.REMOVE': DELETE CHILD -> DELETE DAD -> FAIL
            cascade = {CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(
            name = "mom_id",
            referencedColumnName = "mom_id",
            foreignKey = @ForeignKey(
                    name = "mom_mom_id_fk"
            )
    )
    private Mom mom;

    @ManyToOne(
            // DO NOT USE 'CascadeType.REMOVE': DELETE CHILD -> DELETE MOM -> FAIL
            cascade = {CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(
            name = "dad_id",
            referencedColumnName = "dad_id",
            foreignKey = @ForeignKey(
                    name = "dad_dad_id_fk"
            )
    )
    private Dad dad;

    public Child(String childName, Mom mom, Dad dad) {
        this.childName = childName;
        this.mom = mom;
        this.dad = dad;
    }
}
