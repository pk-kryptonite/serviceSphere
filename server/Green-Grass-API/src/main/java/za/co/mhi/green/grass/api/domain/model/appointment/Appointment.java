package za.co.mhi.green.grass.api.domain.model.appointment;

import za.co.mhi.green.grass.api.domain.model.service.Service;
import za.co.mhi.green.grass.api.domain.model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (unique = true, nullable = false)
  private Long id;

  @ManyToOne
  private User user;

  @ManyToOne
  private Service service;

  private LocalDateTime appointment_date;

  @ManyToOne
  private AppointmentStatus status;// (e.g., scheduled, completed, canceled)

  private Double appointment_latitude;

  private Double appointment_longitude;
}
