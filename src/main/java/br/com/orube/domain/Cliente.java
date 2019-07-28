package br.com.orube.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends AbstractAuditableEntity<User, Long> implements Serializable {

    private static final long serialVersionUID = 8354411161470071697L;

    @Column
    private String nome;

}
