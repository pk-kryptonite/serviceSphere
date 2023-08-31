package za.co.mhi.green.grass.api.domain.model.appointment;

import javax.persistence.*;

@Entity
public class AppointmentStatus {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (unique = true, nullable = false)
  private Long id;

  private String name;
}
