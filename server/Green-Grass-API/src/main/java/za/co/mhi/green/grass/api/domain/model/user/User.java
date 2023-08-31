package za.co.mhi.green.grass.api.domain.model.user;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class User {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (unique = true, nullable = false)
  private Long id;

  private String username;

  @Email (message = "invalid email address")
  private String email;

  private String password;

  private String name;

  private String phone_number;

  private String street;

  private String city;

  private String state;

  private String country;

  private Double latitude;

  private Double longitude;
}
