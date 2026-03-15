package br.gov.sc.sctec.empreendedorismo.backend.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "empreendimentos")
@Data
public class Empreendimento implements Serializable {

    private static final long serialVersionUID = 4390587838432156003L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "st_nome")
    private String nome;

    @Column(name = "st_responsavel")
    private String responsavel;

    @Column(name = "st_municipio")
    private String municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_segmento")
    private Segmento segmento;

    @Column(name = "st_email")
    private String email;

    @Column(name = "fl_ativo")
    private Boolean ativo;

    @Column(name = "dt_criacao")
    private LocalDateTime dataCriacao;

}
