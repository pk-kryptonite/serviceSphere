package za.co.mhi.green.grass.api.domain.model.review;

import za.co.mhi.green.grass.api.domain.model.service.ServiceProvider;
import za.co.mhi.green.grass.api.domain.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Review {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (unique = true, nullable = false)
  private Long id;

  @ManyToOne
  private User user;

  @ManyToOne
  private ServiceProvider provider;
  @Max(value = 5,message = "Maximum rating is 5")
  @Min(value = 1, message = "Minimum rating is 1")
  private Integer rating;

  private String comment;
  private LocalDateTime date;
}
