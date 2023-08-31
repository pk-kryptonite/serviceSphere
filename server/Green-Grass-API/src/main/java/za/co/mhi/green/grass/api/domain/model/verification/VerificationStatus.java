package za.co.mhi.green.grass.api.domain.model.verification;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VerificationStatus {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (unique = true, nullable = false)
  private Long id;

  private String name;// (e.g., "Pending," "Approved," "Rejected")
}
