package za.co.mhi.green.grass.api.domain.model.verification;

import za.co.mhi.green.grass.api.domain.model.service.ServiceProvider;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Verification {

  @Id
  @GeneratedValue (strategy = GenerationType.SEQUENCE)
  @Column (unique = true, nullable = false)
  private Long id;

  @OneToOne
  private ServiceProvider provider;

  private VerificationType type;

  private VerificationStatus status;

  private String document;

  private String selfie;

  private LocalDateTime date;


}
