package org.easyvote.logic;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Class representing an individual voting session held during a General Meeting
public class Session {

  // type determines the kind of voting that will take place during
  // the session. For example, ROP votes that require yes/no answers, Board Elections
  // that require name answers etc.

  private StringProperty title;
  private StringProperty type;
//  private String title;
//  private String type;
  private ArrayList<Topic> topics;


  public Session(String title, String type){
    this.title = new SimpleStringProperty(title);
    this.type = new SimpleStringProperty(type);
//    this.title = title;
//    this.type = type;
    topics = new ArrayList<>();
  }

  public void addTopic(String title, String description, VoteType voteType){

  }

//  public String getTitle() {
//    return title;
//  }
//
//  public String getType() {
//    return type;
//  }

  public StringProperty titleProperty() {
    return title;
  }

  public StringProperty typeProperty() {
    return type;
  }

}
