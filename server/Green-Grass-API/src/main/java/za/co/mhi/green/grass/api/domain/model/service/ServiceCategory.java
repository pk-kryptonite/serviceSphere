package za.co.mhi.green.grass.api.domain.model.service;

import javax.persistence.*;

@Entity
public class ServiceCategory {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (unique = true, nullable = false)
  private Long id;

  private String category_name;

}
