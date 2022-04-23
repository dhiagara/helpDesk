package com.javainuse.springbootsecurity.dao.enitity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String service;
    private String etat;
    @Lob
    @Column(name="contenue", length=512)
    private String contenue;
    private  String attachement ;
    private String emailId ;
    private  String password;

   /* @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;*/


}
