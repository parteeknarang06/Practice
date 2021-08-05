package com.hibernate.mapping.onetoone.bi.cascadespecific;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

  private Integer id;
  private String youTubeChannel;
  private String hobby;
  private Instructor instructor;

  public InstructorDetail() {
    // For hibernate
  }

  public InstructorDetail(String youTubeChannel, String hobby) {
    this.youTubeChannel = youTubeChannel;
    this.hobby = hobby;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "youtube_channel")
  public String getYouTubeChannel() {
    return youTubeChannel;
  }

  public void setYouTubeChannel(String youTubeChannel) {
    this.youTubeChannel = youTubeChannel;
  }

  @Column(name = "hobby")
  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  @OneToOne(mappedBy = "instructorDetail", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH })
  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  @Override
  public String toString() {
    return "InstructorDetail [id=" + id + ", youTubeChannel=" + youTubeChannel + ", hobby=" + hobby + "]";
  }

}
