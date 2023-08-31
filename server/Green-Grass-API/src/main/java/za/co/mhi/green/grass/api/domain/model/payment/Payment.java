package za.co.mhi.green.grass.api.domain.model.payment;

import za.co.mhi.green.grass.api.domain.model.appointment.Appointment;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Payment {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (unique = true, nullable = false)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "appointment_id")
  private Appointment appointment;
  private Double amount;
  private Timestamp timestamp;

}
