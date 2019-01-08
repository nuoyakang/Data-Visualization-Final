import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 
import peasy.org.apache.commons.math.*; 
import peasy.org.apache.commons.math.geometry.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class DNAstructure extends PApplet {




PeasyCam peasycam;

Thymine thymine;
Cytosine cytosine;
Guanine guanine;
Adenine adenine;
PhosphoRiboseBackbone prb;
HydrogenBonds hb;
String nitrogen = "N";
String hydrogen = "H";
String phosphorus = "P";
String oxygen = "O";
String two = "2";
int depthOfMolecule = 20;
public void setup() {
  
  
  textMode(SHAPE);
  textMode(CENTER);
  textSize(30);
  
  thymine = new Thymine();
  cytosine = new Cytosine();
  guanine = new Guanine();
  adenine = new Adenine();
  prb = new PhosphoRiboseBackbone();
  hb = new HydrogenBonds();
  peasycam = new PeasyCam(this, 0,300,0,3000);  
  
  
}
 
public void draw(){

   background(0);
   
   fill(255);
   text("Thymine", -300, -780);  
   text("Adenine", -650, -780); 
   text("Cytosine", 500, 1650);
   text("Guanine", 0, 1650);
   lights();
   
   //int transX, int transY, int transZ, float rotateDegrees
   //translate X, Y, Z, and rotate in degrees of whole molecule
   thymine.show(-100, -500, 0, 223);    //pair1
   adenine.show(-470, -430, 0, 282);
   prb.upright(-800, -140, 0, 0);
   prb.upsidedown(120, -550, 0, 180);
   
   guanine.flip(-93, 95, 0, 65);      //pair2
   cytosine.flip(-453, 95, 0, 0);
   prb.upright(-655, 413, 0, 0);
   prb.upsidedown(260, -20, 0, 180);
   
   adenine.flip(35, 625, 0, 67);       //pair3
   thymine.flip(-310, 625, 0, 242);
   prb.upright(-510, 966, 0, 0);
   prb.upsidedown(390, 510, 0, 180);
   
   cytosine.show(320, 1120, 0, 223);    //pair4
   guanine.show(-35, 1210, 0, 280);
   prb.upright(-365, 1519, 0, 0);
   prb.upsidedown(520, 1050, 0, 180);
   
   //the moving bonds between NH2-O  and NH-N
   //first
   translate(-350,-700,0);
   hb.drawsphere(20); 
   hb.moveAround();
   //second
   translate(70,200,0);
   hb.drawsphere(20); 
   hb.moveAround();
   
   //third
   translate(0,400,0);
   hb.drawsphere(20); 
   hb.moveAround();
   //fourth
   translate(10,200,0);
   hb.drawsphere(20); 
   hb.moveAround();
   //fifth
   translate(-20,200,0);
   hb.drawsphere(20); 
   hb.moveAround();
   
   //sixth
   translate(130,100,0);
   hb.drawsphere(20); 
   hb.moveAround();
   //7th
   translate(10,200,0);
   hb.drawsphere(20); 
   hb.moveAround();
   
      
   //8th
   translate(250,400,0);
   hb.drawsphere(20); 
   hb.moveAround();
   //9th
   translate(60,150,0);
   hb.drawsphere(20); 
   hb.moveAround();
   //10th
   translate(40,170,0);
   hb.drawsphere(20); 
   hb.moveAround();
 
}
  
class Adenine{
  Adenine(){
    
  }
  
  public void show(int transX, int transY, int transZ, float rotateDegrees){
    
    pushMatrix();
      translate(transX, transY, transZ);
      rotate(radians(rotateDegrees));
      //1C to 6C double bond
      stroke(255);
      strokeWeight(8);
      line(45, 67, -1, 80, 4, -1);
      line(45, 67, depthOfMolecule+1, 80, 4, depthOfMolecule+1);
      
      //2C to 3C double bond
      line(-45, 67, -1, -80, 4, -1);
      line(-45, 67, depthOfMolecule+1, -80, 4, depthOfMolecule+1);
   
      //4C to 5C double bond    
      line(-43, -77, -1, 43, -77, -1);
      line(-43, -77, depthOfMolecule+1, 43, -77, depthOfMolecule+1);
      
      //7C to 8C double bond
      line(64, -177, -1, 7, -220, -1);
      line(64, -177, depthOfMolecule+1, 7, -220, depthOfMolecule+1);
      strokeWeight(1);
      //6C amino
      line(100, 0, depthOfMolecule/2, 200, 0, depthOfMolecule/2);
      
      pushMatrix();
        fill(255);
        translate(205, -220, 0);
        rotate(radians(90));
        
          //6C amino label
          text(nitrogen, 200, 0, depthOfMolecule/2);
          text(hydrogen, 230, 0, depthOfMolecule/2);
          text(two, 260, 0, depthOfMolecule/2);
          
          //1N
          text(nitrogen, 300, 165, depthOfMolecule+1);
          
          //3N
          text(nitrogen, 210, 315, depthOfMolecule+1);
          
          //9N H
          text(nitrogen, 30, 295, depthOfMolecule+1); 
          
          //7N
          text(nitrogen, 30, 135, depthOfMolecule+1);
          
      popMatrix();
      fill(117, 247, 75);
      
      //top face of hexagon
      beginShape();
        vertex(-100, 0, 0);    //3C
        vertex(-50, -87, 0);   //4C
        vertex(50, -87, 0);    //5C
        vertex(100, 0, 0);     //6C
        vertex(50, 87, 0);     //1C
        vertex(-50, 87, 0);    //2C
        vertex(-100, 0, 0);
      endShape();
      
      //bottom face of hexagon
      beginShape();  
        vertex(-100, 0, depthOfMolecule);  //3C
        vertex(-50, -87, depthOfMolecule); //4C
        vertex(50, -87, depthOfMolecule);  //5C
        vertex(100, 0, depthOfMolecule);   //6C
        vertex(50, 87, depthOfMolecule);   //1C
        vertex(-50, 87, depthOfMolecule);  //2C
        vertex(-100, 0, depthOfMolecule);
      endShape();
      
      //top face of pentagon
      beginShape();
        vertex(-50, -87, 0);          //4C
        vertex(50, -87, 0);           //5C
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(0, -240.884f, 0);       //8C
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-50, -87, 0);
      endShape();
      
      //bottom face of pentagon
      beginShape();
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(50, -87, depthOfMolecule);           //5C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
        vertex(0, -240.884f, depthOfMolecule);       //8C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed hexagon
      beginShape();
        vertex(-100, 0, 0);
        vertex(-50, -87, 0);
        vertex(-50, -87, depthOfMolecule);
        vertex(-100, 0, depthOfMolecule);    
      endShape();
      
      beginShape();
        vertex(-50, -87, 0);
        vertex(50, -87, 0);
        vertex(50, -87, depthOfMolecule);
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(50, -87, 0);
        vertex(100, 0, 0);
        vertex(100, 0, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(100, 0, 0);
        vertex(50, 87, 0);
        vertex(50, 87, depthOfMolecule);
        vertex(100, 0, depthOfMolecule);   
      endShape();
      
      beginShape();
        vertex(50, 87, 0);
        vertex(-50, 87, 0);
        vertex(-50, 87, depthOfMolecule);
        vertex(50, 87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(-50, 87, 0);
        vertex(-100, 0, 0);
        vertex(-100, 0, depthOfMolecule);
        vertex(-50, 87, depthOfMolecule);
      endShape();
    
      //side faces to make it an enclosed pentagon
      beginShape();
        vertex(50, -87, 0);           //5C
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
        vertex(50, -87, depthOfMolecule);           //5C
      endShape();
      
      beginShape();
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(0, -240.884f, 0);       //8C
        vertex(0, -240.884f, depthOfMolecule);       //8C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
      endShape();
      
      beginShape();
        vertex(0, -240.884f, 0);       //8C
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
        vertex(0, -240.884f, depthOfMolecule);       //8C
      endShape();
      
      beginShape();
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-50, -87, 0);          //4C
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
      endShape();
      
    popMatrix();
  }
  
  public void flip(int transX, int transY, int transZ, float rotateDegrees){
    //adenine 5' strand
    pushMatrix();
      translate(transX, transY, transZ);
      rotate(radians(rotateDegrees));
    
      stroke(255);
      
      //1C to 6C double bond
      strokeWeight(8);
      line(45, 67, -1, 80, 4, -1);
      line(45, 67, depthOfMolecule+1, 80, 4, depthOfMolecule+1);
      
      //2C to 3C double bond
      line(-45, 67, -1, -80, 4, -1);
      line(-45, 67, depthOfMolecule+1, -80, 4, depthOfMolecule+1);
   
      //4C to 5C double bond    
      line(-43, -77, -1, 43, -77, -1);
      line(-43, -77, depthOfMolecule+1, 43, -77, depthOfMolecule+1);
      
      //7C to 8C double bond
      line(-64,-177,-1, 7, -220, -1);
      line(-64,- 177, depthOfMolecule+1, 7, -220, depthOfMolecule+1);
      strokeWeight(1);
      //6C amino
      line(-100, 0, depthOfMolecule/2, -200, 0, depthOfMolecule/2);
      
      pushMatrix();
        fill(255);
        translate(-205, 220, 0);
        rotate(radians(-90));
           //6C amino label
          text(nitrogen, 200, 0, depthOfMolecule/2);
          text(hydrogen, 230, 0, depthOfMolecule/2);
          text(two, 260, 0, depthOfMolecule/2);
          
          //1N
          text(nitrogen, 120, 165, depthOfMolecule+1);
          
          //3N
          text(nitrogen, 210, 315, depthOfMolecule+1);
          
          //9N H
          text(nitrogen, 390, 295, depthOfMolecule+1);
          
          
          //7N
          text(nitrogen, 390, 135, depthOfMolecule+1);
          
      popMatrix();
      fill(117, 247, 75);
      //top face of hexagon
      beginShape();
        vertex(-100, 0, 0);    //3C
        vertex(-50, -87, 0);   //4C
        vertex(50, -87, 0);    //5C
        vertex(100, 0, 0);     //6C
        vertex(50, 87, 0);     //1C
        vertex(-50, 87, 0);    //2C
        vertex(-100, 0, 0);
      endShape();
      
      //bottom face of hexagon
      beginShape();  
        vertex(-100, 0, depthOfMolecule);  //3C
        vertex(-50, -87, depthOfMolecule); //4C
        vertex(50, -87, depthOfMolecule);  //5C
        vertex(100, 0, depthOfMolecule);   //6C
        vertex(50, 87, depthOfMolecule);   //1C
        vertex(-50, 87, depthOfMolecule);  //2C
        vertex(-100, 0, depthOfMolecule);
      endShape();
      
      //top face of pentagon
      beginShape();
        vertex(-50, -87, 0);          //4C
        vertex(50, -87, 0);           //5C
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(0, -240.884f, 0);       //8C
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-50, -87, 0);
      endShape();
      
      //bottom face of pentagon
      beginShape();
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(50, -87, depthOfMolecule);           //5C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
        vertex(0, -240.884f, depthOfMolecule);       //8C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed hexagon
      beginShape();
        vertex(-100, 0, 0);
        vertex(-50, -87, 0);
        vertex(-50, -87, depthOfMolecule);
        vertex(-100, 0, depthOfMolecule);    
      endShape();
      
      beginShape();
        vertex(-50, -87, 0);
        vertex(50, -87, 0);
        vertex(50, -87, depthOfMolecule);
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(50, -87, 0);
        vertex(100, 0, 0);
        vertex(100, 0, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(100, 0, 0);
        vertex(50, 87, 0);
        vertex(50, 87, depthOfMolecule);
        vertex(100, 0, depthOfMolecule);   
      endShape();
      
      beginShape();
        vertex(50, 87, 0);
        vertex(-50, 87, 0);
        vertex(-50, 87, depthOfMolecule);
        vertex(50, 87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(-50, 87, 0);
        vertex(-100, 0, 0);
        vertex(-100, 0, depthOfMolecule);
        vertex(-50, 87, depthOfMolecule);
      endShape();
    
      //side faces to make it an enclosed pentagon
      beginShape();
        vertex(50, -87, 0);           //5C
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
        vertex(50, -87, depthOfMolecule);           //5C
      endShape();
      
      beginShape();
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(0, -240.884f, 0);       //8C
        vertex(0, -240.884f, depthOfMolecule);       //8C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
      endShape();
      
      beginShape();
        vertex(0, -240.884f, 0);       //8C
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
        vertex(0, -240.884f, depthOfMolecule);       //8C
      endShape();
      
      beginShape();
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-50, -87, 0);          //4C
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
      endShape();
      
    popMatrix();
    
  }
}
class HydrogenBonds{
  float radius;
  float angle;
  float dis;
  float speed; 
  PVector vector;
  PShape sphere;
  
  HydrogenBonds(){
  speed = 0.005f;
  angle=PI;
    
  }
  
  public void drawsphere(float radius){
    //to draw one sphere
    
    noStroke();  
    pushMatrix();    
      rotateY(angle);
      
      translate(-80, 20, 0);
      //translate(transX, transY, transZ);
      fill(255);      
      sphere(radius);
    
    popMatrix();
    
  }
    
public void moveAround(){
    angle = angle + speed;
    
}
}
class PhosphoRiboseBackbone{
  PhosphoRiboseBackbone(){
    
  }
  
  public void upright(int transX, int transY, int transZ, float rotateDegrees){
    
    pushMatrix();
      translate(transX, transY, transZ);
      rotate(radians(rotateDegrees));
    
     //5 oxygen label
     stroke(255);
     fill(255);
     text(oxygen, -10, -230.884f, depthOfMolecule+1);
     
     //1C connects to nucleotide
     line(80.902f, -182.106f, depthOfMolecule, 135, -250, depthOfMolecule);
     
     //4C to CH2
     line(-80.902f, -182.106f, depthOfMolecule, -135, -250, depthOfMolecule);
     //line from that CH2 to the phosphate
     line(-135, -250, depthOfMolecule, -125, -360, depthOfMolecule);
     //oxygen
     text(oxygen, -135, -350, depthOfMolecule);
     //line from that oxygen to the phosphorus
     line(-125, -360, depthOfMolecule, -195, -430, depthOfMolecule);
     //phosphorus
     text(phosphorus, -205, -420, depthOfMolecule);
     //lower left oxygen
     line(-255, -360, depthOfMolecule, -195, -430, depthOfMolecule);
     text(oxygen, -265, -350, depthOfMolecule);
     //upper right oxygen
     line(-200, -425, depthOfMolecule, -135, -510, depthOfMolecule);
     text(oxygen, -140, -510, depthOfMolecule);
     //upper left oxygen double bond
     line(-195, -430, -1, -260, -460, -1);
     line(-195, -430, depthOfMolecule+1, -260, -460, depthOfMolecule+1);
     text(oxygen, -285, -455, depthOfMolecule);
     //bond from 3C to next phosphate
     line(-50, -87, 0, 5, 20, 0);
     
     fill(247, 179, 75);
     //top face of pentagon
      beginShape();
        vertex(-50, -87, 0);          //3C
        vertex(50, -87, 0);           //2C
        vertex(80.902f, -182.106f, 0);  //1C
        vertex(0, -240.884f, 0);       //5O
        vertex(-80.902f, -182.106f, 0); //4C
        vertex(-50, -87, 0);
      endShape();
      
      //bottom face of pentagon
      beginShape();
        vertex(-50, -87, depthOfMolecule);          //3C
        vertex(50, -87, depthOfMolecule);           //2C
        vertex(80.902f, -182.106f, depthOfMolecule);  //1C
        vertex(0, -240.884f, depthOfMolecule);       //5O
        vertex(-80.902f, -182.106f, depthOfMolecule); //4C
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed pentagon
      beginShape();
        vertex(50, -87, 0);
        vertex(80.902f, -182.106f, 0);
        vertex(80.902f, -182.106f, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(80.902f, -182.106f, 0);  
        vertex(0, -240.884f, 0);
        vertex(0, -240.884f, depthOfMolecule);  
        vertex(80.902f, -182.106f, depthOfMolecule);  
      endShape();
      
      beginShape();
        vertex(0, -240.884f, 0);       
        vertex(-80.902f, -182.106f, 0); 
        vertex(-80.902f, -182.106f, depthOfMolecule); 
        vertex(0, -240.884f, depthOfMolecule);       
      endShape();
      
      beginShape();
        vertex(-80.902f, -182.106f, 0); 
        vertex(-50, -87, 0);          
        vertex(-50, -87, depthOfMolecule);          
        vertex(-80.902f, -182.106f, depthOfMolecule); 
      endShape();
        
    popMatrix();
    
  }
 
  
    public void upsidedown(int transX, int transY, int transZ, float rotateDegrees){
    
    pushMatrix();
      translate(transX, transY, transZ);
      rotate(radians(rotateDegrees));
    
     //5 oxygen label
     stroke(255);
     fill(255);
     text(oxygen, -10, -230.884f, depthOfMolecule+1);
     
     //1C connects to nucleotide
     line(80.902f, -182.106f, depthOfMolecule, 150, -130, depthOfMolecule);
     
     //4C to CH2
     line(-80.902f, -182.106f, depthOfMolecule, -135, -250, depthOfMolecule);
     //line from that CH2 to the phosphate
     line(-135, -250, depthOfMolecule, -125, -360, depthOfMolecule);
     //oxygen
     text(oxygen, -135, -350, depthOfMolecule);
     //line from that oxygen to the phosphorus
     line(-125, -360, depthOfMolecule, -195, -430, depthOfMolecule);
     //phosphorus
     text(phosphorus, -205, -420, depthOfMolecule);
     //lower left oxygen
     line(-255, -360, depthOfMolecule, -195, -430, depthOfMolecule);
     text(oxygen, -265, -350, depthOfMolecule);
     //upper right oxygen
     line(-200, -425, depthOfMolecule, -135, -510, depthOfMolecule);
     text(oxygen, -140, -510, depthOfMolecule);
     //upper left oxygen double bond
     line(-195, -430, -1, -260, -460, -1);
     line(-195, -430, depthOfMolecule+1, -260, -460, depthOfMolecule+1);
     text(oxygen, -285, -455, depthOfMolecule);
     //bond from 3C to next phosphate
     line(-50, -87, 0, 0, 0, 0);
     
     fill(247, 179, 75);
     //top face of pentagon
      beginShape();
        vertex(-50, -87, 0);          //3C
        vertex(50, -87, 0);           //2C
        vertex(80.902f, -182.106f, 0);  //1C
        vertex(0, -240.884f, 0);       //5O
        vertex(-80.902f, -182.106f, 0); //4C
        vertex(-50, -87, 0);
      endShape();
      
      //bottom face of pentagon
      beginShape();
        vertex(-50, -87, depthOfMolecule);          //3C
        vertex(50, -87, depthOfMolecule);           //2C
        vertex(80.902f, -182.106f, depthOfMolecule);  //1C
        vertex(0, -240.884f, depthOfMolecule);       //5O
        vertex(-80.902f, -182.106f, depthOfMolecule); //4C
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed pentagon
      beginShape();
        vertex(50, -87, 0);
        vertex(80.902f, -182.106f, 0);
        vertex(80.902f, -182.106f, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(80.902f, -182.106f, 0);  
        vertex(0, -240.884f, 0);
        vertex(0, -240.884f, depthOfMolecule);  
        vertex(80.902f, -182.106f, depthOfMolecule);  
      endShape();
      
      beginShape();
        vertex(0, -240.884f, 0);       
        vertex(-80.902f, -182.106f, 0); 
        vertex(-80.902f, -182.106f, depthOfMolecule); 
        vertex(0, -240.884f, depthOfMolecule);       
      endShape();
      
      beginShape();
        vertex(-80.902f, -182.106f, 0); 
        vertex(-50, -87, 0);          
        vertex(-50, -87, depthOfMolecule);          
        vertex(-80.902f, -182.106f, depthOfMolecule); 
      endShape();
        
    popMatrix();
    
  }
  
}
class Thymine{
  
  Thymine(){
    
  }
  
  public void show(int transX, int transY, int transZ, float rotateDegrees) {
    pushMatrix();
        translate(transX, transY, transZ);
        rotate(radians(rotateDegrees));
      
      //thymine
      stroke(255);
       
      //5C to 6C double bond
      strokeWeight(8);
      line(46, 78, -1, -46, 78, -1);
      line(46, 78, depthOfMolecule+1, -46, 78, depthOfMolecule+1);
      strokeWeight(1);
      
      //5-methyl
      line(50, 87, depthOfMolecule/2, 100, 174, depthOfMolecule/2);
      
      //2C carbonyl
      line(-50, -87, 0, -100, -174, 0);
      line(-50, -87, depthOfMolecule, -100, -174, depthOfMolecule);
      
      //4C carbonyl
      line(100, 0, 0, 200, 0, 0);
      line(100, 0, depthOfMolecule, 200, 0, depthOfMolecule);
      
      pushMatrix();
        fill(255);
        translate(205, -220, 0);
        rotate(radians(90));
        
        //6C amino label,going clockwise
        text(oxygen, 200, 0, depthOfMolecule/2);
        text(hydrogen, 120, 165, depthOfMolecule+1);
        text(nitrogen, 150, 165, depthOfMolecule+1);
        
        text(oxygen, 10, 330, depthOfMolecule+1);
        
        text(nitrogen, 200, 320, depthOfMolecule+1);
        
      popMatrix();
      
      fill(216, 50, 175);
      
      //top face of hexagon
      beginShape();
        vertex(-100, 0, 0);    //1C
        vertex(-50, -87, 0);   //2C
        vertex(50, -87, 0);    //3C
        vertex(100, 0, 0);     //4C
        vertex(50, 87, 0);     //5C
        vertex(-50, 87, 0);    //6C
        vertex(-100, 0, 0);
      endShape();
      
      //bottom face of hexagon
      beginShape();  
        vertex(-100, 0, depthOfMolecule);  //1C
        vertex(-50, -87, depthOfMolecule); //2C
        vertex(50, -87, depthOfMolecule);  //3C
        vertex(100, 0, depthOfMolecule);   //4C
        vertex(50, 87, depthOfMolecule);   //5C
        vertex(-50, 87, depthOfMolecule);  //6C
        vertex(-100, 0, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed polygon
      beginShape();
        vertex(-100, 0, 0);
        vertex(-50, -87, 0);
        vertex(-50, -87, depthOfMolecule);
        vertex(-100, 0, depthOfMolecule);    
      endShape();
      
      beginShape();
        vertex(-50, -87, 0);
        vertex(50, -87, 0);
        vertex(50, -87, depthOfMolecule);
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(50, -87, 0);
        vertex(100, 0, 0);
        vertex(100, 0, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(100, 0, 0);
        vertex(50, 87, 0);
        vertex(50, 87, depthOfMolecule);
        vertex(100, 0, depthOfMolecule);   
      endShape();
      
      beginShape();
        vertex(50, 87, 0);
        vertex(-50, 87, 0);
        vertex(-50, 87, depthOfMolecule);
        vertex(50, 87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(-50, 87, 0);
        vertex(-100, 0, 0);
        vertex(-100, 0, depthOfMolecule);
        vertex(-50, 87, depthOfMolecule);
      endShape();
  
  popMatrix();
  
  
}
  public void flip(int transX, int transY, int transZ, float rotateDegrees) {
    
    //thymine
    pushMatrix();
        translate(transX, transY, transZ);
        rotate(radians(rotateDegrees));
        
      //5C to 6C double bond
      stroke(255);
      strokeWeight(8);
      line(46, -78, 1, 93, 0, -1);
      line(46,-78, depthOfMolecule+1,93, 0, depthOfMolecule+1);
      strokeWeight(1);
      
      //5-methyl
      line(100, 0, depthOfMolecule/2, 200, 0, depthOfMolecule/2);
     
      //2C carbonyl
      line(-100, 0, 0, -180, 0, 0);
      line(-100, 0, depthOfMolecule, -180, 0, depthOfMolecule);
      
      
      //4C carbonyl
      line(50, 87, 0, 100, 174, 0);
      line(50, 87, depthOfMolecule, 100, 174, depthOfMolecule);
      
      pushMatrix();
        fill(255);
        translate(205, -220, 0);
        rotate(radians(120));
        
        //6C amino label,going clockwise
        text(oxygen, 380, -120, depthOfMolecule+1);
        text(nitrogen,220, 170, depthOfMolecule+1);
        
        text(nitrogen, 370, 80, depthOfMolecule+1);
             
        text(oxygen, 400, 250, depthOfMolecule+1);
        
        text(hydrogen, 410, 80, depthOfMolecule+1);    
        
      popMatrix();
      
      fill(216, 50, 175);
      
      //top face of hexagon
      beginShape();
        vertex(-100, 0, 0);    //1C
        vertex(-50, -87, 0);   //2C
        vertex(50, -87, 0);    //3C
        vertex(100, 0, 0);     //4C
        vertex(50, 87, 0);     //5C
        vertex(-50, 87, 0);    //6C
        vertex(-100, 0, 0);
      endShape();
      
      //bottom face of hexagon
      beginShape();  
        vertex(-100, 0, depthOfMolecule);  //1C
        vertex(-50, -87, depthOfMolecule); //2C
        vertex(50, -87, depthOfMolecule);  //3C
        vertex(100, 0, depthOfMolecule);   //4C
        vertex(50, 87, depthOfMolecule);   //5C
        vertex(-50, 87, depthOfMolecule);  //6C
        vertex(-100, 0, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed polygon
      beginShape();
        vertex(-100, 0, 0);
        vertex(-50, -87, 0);
        vertex(-50, -87, depthOfMolecule);
        vertex(-100, 0, depthOfMolecule);    
      endShape();
      
      beginShape();
        vertex(-50, -87, 0);
        vertex(50, -87, 0);
        vertex(50, -87, depthOfMolecule);
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(50, -87, 0);
        vertex(100, 0, 0);
        vertex(100, 0, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(100, 0, 0);
        vertex(50, 87, 0);
        vertex(50, 87, depthOfMolecule);
        vertex(100, 0, depthOfMolecule);   
      endShape();
      
      beginShape();
        vertex(50, 87, 0);
        vertex(-50, 87, 0);
        vertex(-50, 87, depthOfMolecule);
        vertex(50, 87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(-50, 87, 0);
        vertex(-100, 0, 0);
        vertex(-100, 0, depthOfMolecule);
        vertex(-50, 87, depthOfMolecule);
      endShape();
      
    popMatrix();
  
  }
}
class Cytosine{
  
  Cytosine(){
    
  }
  
  public void show(int transX, int transY, int transZ, float rotateDegrees){
    
    pushMatrix();
      translate(transX, transY, transZ);
      rotate(radians(rotateDegrees));
      //5C to 6C double bond
      stroke(255);
      //5C to 6C double bond
      strokeWeight(8);
  
      //5C to 6C double bond
      strokeWeight(8);
      line(46, 78, -1, -46, 78, -1);
      line(46, 78, depthOfMolecule+1, -46, 78, depthOfMolecule+1);
      
      //3C to 4C double bond    
      line(43, -82, -1, 93, 5, -1);
      line(43, -82, depthOfMolecule+1, 93, 5, depthOfMolecule+1);
      strokeWeight(1);
      //2C carbonyl
      line(-50, -87, 0, -100, -174, 0);
      line(-50, -87, depthOfMolecule, -100, -174, depthOfMolecule);
      
      //4C amino
      line(100, 0, depthOfMolecule/2, 200, 0, depthOfMolecule/2);
      
      pushMatrix();
        fill(255);
        translate(205, -220, 0);
        rotate(radians(120));
        //6C amino label,going clockwise
        text(hydrogen, 180, -120, depthOfMolecule+1);
        text(two, 210, -120, depthOfMolecule+1);
        text(nitrogen, 240, -120, depthOfMolecule+1);
        
        text(nitrogen,180, 100, depthOfMolecule+1);
        
        text(oxygen, 175, 250, depthOfMolecule+1);
        
        text(nitrogen, 330, 170, depthOfMolecule+1);     
        
      popMatrix();
      
      fill(226, 171, 165);
      //top face of hexagon
      beginShape();
        vertex(-100, 0, 0);    //1C
        vertex(-50, -87, 0);   //2C
        vertex(50, -87, 0);    //3C
        vertex(100, 0, 0);     //4C
        vertex(50, 87, 0);     //5C
        vertex(-50, 87, 0);    //6C
        vertex(-100, 0, 0);
      endShape();
      
      //bottom face of hexagon
      beginShape();  
        vertex(-100, 0, depthOfMolecule);  //1C
        vertex(-50, -87, depthOfMolecule); //2C
        vertex(50, -87, depthOfMolecule);  //3C
        vertex(100, 0, depthOfMolecule);   //4C
        vertex(50, 87, depthOfMolecule);   //5C
        vertex(-50, 87, depthOfMolecule);  //6C
        vertex(-100, 0, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed polygon
      beginShape();
        vertex(-100, 0, 0);
        vertex(-50, -87, 0);
        vertex(-50, -87, depthOfMolecule);
        vertex(-100, 0, depthOfMolecule);    
      endShape();
      
      beginShape();
        vertex(-50, -87, 0);
        vertex(50, -87, 0);
        vertex(50, -87, depthOfMolecule);
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(50, -87, 0);
        vertex(100, 0, 0);
        vertex(100, 0, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(100, 0, 0);
        vertex(50, 87, 0);
        vertex(50, 87, depthOfMolecule);
        vertex(100, 0, depthOfMolecule);   
      endShape();
      
      beginShape();
        vertex(50, 87, 0);
        vertex(-50, 87, 0);
        vertex(-50, 87, depthOfMolecule);
        vertex(50, 87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(-50, 87, 0);
        vertex(-100, 0, 0);
        vertex(-100, 0, depthOfMolecule);
        vertex(-50, 87, depthOfMolecule);
      endShape();
      
    popMatrix();
  }
   public void flip(int transX, int transY, int transZ, float rotateDegrees) {
     //cytosine 5' strand
     
  pushMatrix();
      translate(transX, transY, transZ);
      rotate(radians(rotateDegrees));
      //5C to 6C double bond
      stroke(255);
      //5C to 6C double bond
      strokeWeight(8);
      line(-46, -78, -1, -92, 0, -1);
      line(-46, -78, depthOfMolecule+1, -92, 0, depthOfMolecule+1);
      
      //3C to 4C double bond    
      line(43, -82, -1, 93, 5, -1);
      line(43, -82, depthOfMolecule+1, 93, 5, depthOfMolecule+1);
      strokeWeight(1);
      //2C carbonyl
      line(50, 87, 0, 100, 174, 0);
      line(50, 87, depthOfMolecule, 100, 174, depthOfMolecule);
      
      //4C amino
      line(50, -87, depthOfMolecule/2,100, -200, depthOfMolecule/2);
      
      pushMatrix();
        fill(255);
        translate(205, -220, 0);
        rotate(radians(30));
        
        //6C amino label,going clockwise
        text(nitrogen, -150, 80, depthOfMolecule+1);  
        text(hydrogen, -120, 80, depthOfMolecule+1);
        text(two, -90, 80, depthOfMolecule+1);
        
        text(nitrogen, 0, 270, depthOfMolecule+1);
        
        text(oxygen, 100, 410, depthOfMolecule+1);
        
        text(nitrogen, -100, 400, depthOfMolecule+1);
   
    popMatrix();
      fill(226, 171, 165);
      
      //top face of hexagon
      beginShape();
        vertex(-100, 0, 0);    //1C
        vertex(-50, -87, 0);   //2C
        vertex(50, -87, 0);    //3C
        vertex(100, 0, 0);     //4C
        vertex(50, 87, 0);     //5C
        vertex(-50, 87, 0);    //6C
        vertex(-100, 0, 0);
      endShape();
      
      //bottom face of hexagon
      beginShape();  
        vertex(-100, 0, depthOfMolecule);  //1C
        vertex(-50, -87, depthOfMolecule); //2C
        vertex(50, -87, depthOfMolecule);  //3C
        vertex(100, 0, depthOfMolecule);   //4C
        vertex(50, 87, depthOfMolecule);   //5C
        vertex(-50, 87, depthOfMolecule);  //6C
        vertex(-100, 0, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed polygon
      beginShape();
        vertex(-100, 0, 0);
        vertex(-50, -87, 0);
        vertex(-50, -87, depthOfMolecule);
        vertex(-100, 0, depthOfMolecule);    
      endShape();
      
      beginShape();
        vertex(-50, -87, 0);
        vertex(50, -87, 0);
        vertex(50, -87, depthOfMolecule);
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(50, -87, 0);
        vertex(100, 0, 0);
        vertex(100, 0, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(100, 0, 0);
        vertex(50, 87, 0);
        vertex(50, 87, depthOfMolecule);
        vertex(100, 0, depthOfMolecule);   
      endShape();
      
      beginShape();
        vertex(50, 87, 0);
        vertex(-50, 87, 0);
        vertex(-50, 87, depthOfMolecule);
        vertex(50, 87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(-50, 87, 0);
        vertex(-100, 0, 0);
        vertex(-100, 0, depthOfMolecule);
        vertex(-50, 87, depthOfMolecule);
      endShape();
  popMatrix();
 }
 }
class Guanine{
  
  Guanine(){
    
  }
  public void show(int transX, int transY, int transZ, float rotateDegrees){
    pushMatrix();
      translate(transX, transY, transZ);
      rotate(radians(rotateDegrees));
  
      //2C to 3C double bond
      stroke(255);
      strokeWeight(8);
      line(-45, 67, -1, -80, 4, -1);
      line(-45, 67, depthOfMolecule+1, -80, 4, depthOfMolecule+1);
   
      //4C to 5C double bond    
      line(-43, -77, -1, 43, -77, -1);
      line(-43, -77, depthOfMolecule+1, 43, -77, depthOfMolecule+1);
      
      //7C to 8C double bond
      line(64, -177, -1, 7, -220, -1);
      line(64, -177, depthOfMolecule+1, 7, -220, depthOfMolecule+1);
      strokeWeight(1);
      //2C amino
      line(-50, 87, depthOfMolecule/2, -100, 174, depthOfMolecule/2);
      
      //6C carbonyl
      line(100, 0, 0, 200, 0, 0);
      line(100, 0, depthOfMolecule, 200, 0, depthOfMolecule);
      
      pushMatrix();
        fill(255);
        translate(205, -220, 0);
        rotate(radians(90));
          //6O carbonyl oxygen label
          text(oxygen, 210, 0, depthOfMolecule/2);
          
          //1N H
          text(nitrogen, 300, 165, depthOfMolecule+1);
          text(hydrogen, 320, 165, depthOfMolecule+1);
          
          //2C amino
          text(nitrogen, 400, 320, depthOfMolecule/2);
          text(two, 430, 320, depthOfMolecule/2);
          text(hydrogen, 460, 320, depthOfMolecule/2);
          
          //3N
          text(nitrogen, 210, 315, depthOfMolecule+1);
          
          //9N H
          text(nitrogen, 30, 295, depthOfMolecule+1);
          
          
          //7N
          text(nitrogen, 30, 135, depthOfMolecule+1);
          
      popMatrix();
      
      fill(95, 91, 223);
      //top face of hexagon
      beginShape();
        vertex(-100, 0, 0);    //3C
        vertex(-50, -87, 0);   //4C
        vertex(50, -87, 0);    //5C
        vertex(100, 0, 0);     //6C
        vertex(50, 87, 0);     //1C
        vertex(-50, 87, 0);    //2C
        vertex(-100, 0, 0);
      endShape();
      
      //bottom face of hexagon
      beginShape();  
        vertex(-100, 0, depthOfMolecule);  //3C
        vertex(-50, -87, depthOfMolecule); //4C
        vertex(50, -87, depthOfMolecule);  //5C
        vertex(100, 0, depthOfMolecule);   //6C
        vertex(50, 87, depthOfMolecule);   //1C
        vertex(-50, 87, depthOfMolecule);  //2C
        vertex(-100, 0, depthOfMolecule);
      endShape();
      
      //top face of pentagon
      beginShape();
        vertex(-50, -87, 0);          //4C
        vertex(50, -87, 0);           //5C
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(0, -240.884f, 0);       //8C
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-50, -87, 0);
      endShape();
      
      //bottom face of pentagon
      beginShape();
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(50, -87, depthOfMolecule);           //5C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
        vertex(0, -240.884f, depthOfMolecule);       //8C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed hexagon
      beginShape();
        vertex(-100, 0, 0);
        vertex(-50, -87, 0);
        vertex(-50, -87, depthOfMolecule);
        vertex(-100, 0, depthOfMolecule);    
      endShape();
      
      beginShape();
        vertex(-50, -87, 0);
        vertex(50, -87, 0);
        vertex(50, -87, depthOfMolecule);
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(50, -87, 0);
        vertex(100, 0, 0);
        vertex(100, 0, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(100, 0, 0);
        vertex(50, 87, 0);
        vertex(50, 87, depthOfMolecule);
        vertex(100, 0, depthOfMolecule);   
      endShape();
      
      beginShape();
        vertex(50, 87, 0);
        vertex(-50, 87, 0);
        vertex(-50, 87, depthOfMolecule);
        vertex(50, 87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(-50, 87, 0);
        vertex(-100, 0, 0);
        vertex(-100, 0, depthOfMolecule);
        vertex(-50, 87, depthOfMolecule);
      endShape();
    
      //side faces to make it an enclosed pentagon
      beginShape();
        vertex(50, -87, 0);           //5C
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
        vertex(50, -87, depthOfMolecule);           //5C
      endShape();
      
      beginShape();
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(0, -240.884f, 0);       //8C
        vertex(0, -240.884f, depthOfMolecule);       //8C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
      endShape();
      
      beginShape();
        vertex(0, -240.884f, 0);       //8C
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
        vertex(0, -240.884f, depthOfMolecule);       //8C
      endShape();
      
      beginShape();
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-50, -87, 0);          //4C
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
      endShape();
      
    popMatrix();
  
  }
  public void flip(int transX, int transY, int transZ, float rotateDegrees){
    //guanine
    pushMatrix();
      translate(transX, transY, transZ);
      rotate(radians(rotateDegrees));
      
      //2C to 3C double bond
      stroke(255);
      strokeWeight(8);
      line(45, 67, -1, 80, 4, -1);
      line(45, 67, depthOfMolecule+1, 80, 4, depthOfMolecule+1);
   
      //4C to 5C double bond    
      line(-43, -77, -1, 43, -77, -1);
      line(-43, -77, depthOfMolecule+1, 43, -77, depthOfMolecule+1);
      
      //7C to 8C double bond
      line(64, -177, -1, 7, -220, -1);
      line(64, -177, depthOfMolecule+1, 7, -220, depthOfMolecule+1);
      strokeWeight(1);
      //2C amino
      line(50, 87, depthOfMolecule/2, 100, 174, depthOfMolecule/2);
      
      //6C carbonyl
      line(-100, 0, 0, -200, 0, 0);
      line(-100, 0, depthOfMolecule, -200, 0, depthOfMolecule);
      
      pushMatrix();
        fill(255);
        translate(-205, 220, 0);
        rotate(radians(-90));
          //6O carbonyl oxygen label
          text(oxygen, 210, 0, depthOfMolecule/2);
          
          //1N H
          text(nitrogen, 120, 165, depthOfMolecule+1);
          text(hydrogen, 100, 165, depthOfMolecule+1);
          
          //2C amino
          text(hydrogen, 0, 320, depthOfMolecule/2);
          text(two, 30, 320, depthOfMolecule/2);
          text(nitrogen, 60, 320, depthOfMolecule/2);
          
          //3N
          text(nitrogen, 210, 315, depthOfMolecule+1);
          
          //9N H
          text(nitrogen, 390, 295, depthOfMolecule+1);
               
          //7N
          text(nitrogen, 390, 135, depthOfMolecule+1);
          
      popMatrix();
      fill(95, 91, 223);
      //top face of hexagon
      beginShape();
        vertex(-100, 0, 0);    //3C
        vertex(-50, -87, 0);   //4C
        vertex(50, -87, 0);    //5C
        vertex(100, 0, 0);     //6C
        vertex(50, 87, 0);     //1C
        vertex(-50, 87, 0);    //2C
        vertex(-100, 0, 0);
      endShape();
      
      //bottom face of hexagon
      beginShape();  
        vertex(-100, 0, depthOfMolecule);  //3C
        vertex(-50, -87, depthOfMolecule); //4C
        vertex(50, -87, depthOfMolecule);  //5C
        vertex(100, 0, depthOfMolecule);   //6C
        vertex(50, 87, depthOfMolecule);   //1C
        vertex(-50, 87, depthOfMolecule);  //2C
        vertex(-100, 0, depthOfMolecule);
      endShape();
      
      //top face of pentagon
      beginShape();
        vertex(-50, -87, 0);          //4C
        vertex(50, -87, 0);           //5C
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(0, -240.884f, 0);       //8C
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-50, -87, 0);
      endShape();
      
      //bottom face of pentagon
      beginShape();
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(50, -87, depthOfMolecule);           //5C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
        vertex(0, -240.884f, depthOfMolecule);       //8C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      //side faces to make it an enclosed hexagon
      beginShape();
        vertex(-100, 0, 0);
        vertex(-50, -87, 0);
        vertex(-50, -87, depthOfMolecule);
        vertex(-100, 0, depthOfMolecule);    
      endShape();
      
      beginShape();
        vertex(-50, -87, 0);
        vertex(50, -87, 0);
        vertex(50, -87, depthOfMolecule);
        vertex(-50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(50, -87, 0);
        vertex(100, 0, 0);
        vertex(100, 0, depthOfMolecule);
        vertex(50, -87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(100, 0, 0);
        vertex(50, 87, 0);
        vertex(50, 87, depthOfMolecule);
        vertex(100, 0, depthOfMolecule);   
      endShape();
      
      beginShape();
        vertex(50, 87, 0);
        vertex(-50, 87, 0);
        vertex(-50, 87, depthOfMolecule);
        vertex(50, 87, depthOfMolecule);
      endShape();
      
      beginShape();
        vertex(-50, 87, 0);
        vertex(-100, 0, 0);
        vertex(-100, 0, depthOfMolecule);
        vertex(-50, 87, depthOfMolecule);
      endShape();
    
      //side faces to make it an enclosed pentagon
      beginShape();
        vertex(50, -87, 0);           //5C
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
        vertex(50, -87, depthOfMolecule);           //5C
      endShape();
      
      beginShape();
        vertex(80.902f, -182.106f, 0);  //7C
        vertex(0, -240.884f, 0);       //8C
        vertex(0, -240.884f, depthOfMolecule);       //8C
        vertex(80.902f, -182.106f, depthOfMolecule);  //7C
      endShape();
      
      beginShape();
        vertex(0, -240.884f, 0);       //8C
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
        vertex(0, -240.884f, depthOfMolecule);       //8C
      endShape();
      
      beginShape();
        vertex(-80.902f, -182.106f, 0); //9C
        vertex(-50, -87, 0);          //4C
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(-80.902f, -182.106f, depthOfMolecule); //9C
      endShape();
      
  popMatrix();    
}
}
  public void settings() {  size(800, 1000, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "DNAstructure" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
