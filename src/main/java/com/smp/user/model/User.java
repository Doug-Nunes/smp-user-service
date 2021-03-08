package com.smp.user.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Audited
@Entity
@Data
@ToString
@EqualsAndHashCode(of = {"id"})
@Table(name = "USERS")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2037636157488895814L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3,max = 50)
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Size(min = 3,max = 50)
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Size(min = 3,max = 50)
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Size(min = 3,max = 150)
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "DELETE_DATE")
    private LocalDateTime deleteDate;    

    @PrePersist
    void prePersist() {
    	this.createDate = LocalDateTime.now();
    }
    
}

