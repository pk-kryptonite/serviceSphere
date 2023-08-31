package za.co.mhi.green.grass.api.domain.model.service;

import javax.persistence.*;

@Entity
public class Service {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (unique = true, nullable = false)
  private Long id;

  @ManyToOne
  private ServiceProvider provider;

  @ManyToOne
  private ServiceCategory category;

  private String service_name;

  private Double price;
}
