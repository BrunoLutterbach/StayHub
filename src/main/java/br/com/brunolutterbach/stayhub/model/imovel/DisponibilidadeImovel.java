package br.com.brunolutterbach.stayhub.model.imovel;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class DisponibilidadeImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
    private LocalDate dataInicio;
    private LocalDate dataFim;


    public DisponibilidadeImovel(Imovel imovel, LocalDate dataInicio, LocalDate dataFim) {
        this.imovel = imovel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public DisponibilidadeImovel() {

    }
}
