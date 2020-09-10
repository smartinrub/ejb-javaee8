package com.sergiomartinrubio.ejb.javaee8.persistence.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FOO_CHILD")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FooChild {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "foo_child_id", unique = true, nullable = false)
    private Integer id;

    @Basic(fetch = FetchType.EAGER)
    private String fooField;

    @ManyToMany
    private List<Foo> foos;

}
