package com.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contributions")
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn (name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn (name="bank_id")
    private Bank bank;

    @Column(name = "open_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date openDate;

    @Column(name = "percent")
    private Double percent;

    @Column(name = "term_in_months")
    private Integer termInMonths;
}
