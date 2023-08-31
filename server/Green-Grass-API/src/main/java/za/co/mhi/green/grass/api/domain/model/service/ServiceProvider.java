package za.co.mhi.green.grass.api.domain.model.service;

import za.co.mhi.green.grass.api.domain.model.user.User;

import javax.persistence.*;

@Entity
public class ServiceProvider {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(unique = true,nullable = false)
  private Long id;

  @OneToOne(fetch = FetchType.EAGER)
  private User user;

  private String business_name;

  private String description;

}
