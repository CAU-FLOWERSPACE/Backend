package cau.capstone.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@Entity
public class Flower {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long flower_id;

  @Column(nullable = false)
  private String flower_name;

  @Column(nullable = false)
  private String mean;

  @Column(nullable = false)
  private String flower_feature;

  @Column(nullable = false)
  private String color;

  @Column(nullable = false)
  private Long rgb; // 수정필요

  // 이미지

}
