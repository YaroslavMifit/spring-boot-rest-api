package com.demo.model;

import com.demo.util.DecimalJsonSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contributions")
@JsonIgnoreProperties(ignoreUnknown = false)
public class Contribution {
    public static final String DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";
    public static final String TIME_ZONE = "Asia/Yekaterinburg";

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

    @DateTimeFormat(pattern = DATE_PATTERN)
    @Column(name = "open_date")
    @JsonFormat(pattern = DATE_PATTERN, timezone = TIME_ZONE)
    private Date openDate;

    @Column(name = "percent", columnDefinition="Decimal(5,2)", scale = 2)
    @JsonSerialize(using = DecimalJsonSerializer.class)
    private Double percent;

    @Column(name = "term_in_months")
    private Integer termInMonths;
}
