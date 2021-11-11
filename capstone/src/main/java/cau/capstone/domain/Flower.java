package cau.capstone.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
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

  @Column(nullable = true)
  private String image;

//  @Column(nullable = false)
//  private Long rgb; // 수정필요

  @Builder
  public Flower(String flower_name, String mean, String flower_feature, String color, String image) {
    this.flower_name = flower_name;
    this.mean = mean;
    this.flower_feature = flower_feature;
    this.color = color;
    this.image = image;
  }
}
