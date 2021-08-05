package com.hibernate.mapping.onetomany.bi;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

  private Integer id;
  private String youTubeChannel;
  private String hobby;
  private Set<Instructor> instructors;

  public InstructorDetail() {
    // For hibernate
  }

  public InstructorDetail(String youTubeChannel, String hobby, Set<Instructor> instructors) {
    this.youTubeChannel = youTubeChannel;
    this.hobby = hobby;
    this.instructors = instructors;
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

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructorDetail")
  public Set<Instructor> getInstructors() {
    return instructors;
  }

  public void setInstructors(Set<Instructor> instructors) {
    this.instructors = instructors;
  }

  @Override
  public String toString() {
    return "InstructorDetail [id=" + id + ", youTubeChannel=" + youTubeChannel + ", hobby=" + hobby + ", instructors="
        + instructors + "]";
  }

}
