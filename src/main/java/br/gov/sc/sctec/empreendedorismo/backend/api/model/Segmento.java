package br.gov.sc.sctec.empreendedorismo.backend.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "segmentos")
@Data
public class Segmento implements Serializable {

    private static final long serialVersionUID = -7845984109302722522L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "st_nome")
    private String nome;

    @Column(name = "dt_criacao")
    private LocalDateTime dataCriacao;

}
