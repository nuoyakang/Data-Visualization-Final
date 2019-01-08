class Guanine{
  
  Guanine(){
    
  }
  void show(int transX, int transY, int transZ, float rotateDegrees){
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
        vertex(80.902, -182.106, 0);  //7C
        vertex(0, -240.884, 0);       //8C
        vertex(-80.902, -182.106, 0); //9C
        vertex(-50, -87, 0);
      endShape();
      
      //bottom face of pentagon
      beginShape();
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(50, -87, depthOfMolecule);           //5C
        vertex(80.902, -182.106, depthOfMolecule);  //7C
        vertex(0, -240.884, depthOfMolecule);       //8C
        vertex(-80.902, -182.106, depthOfMolecule); //9C
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
        vertex(80.902, -182.106, 0);  //7C
        vertex(80.902, -182.106, depthOfMolecule);  //7C
        vertex(50, -87, depthOfMolecule);           //5C
      endShape();
      
      beginShape();
        vertex(80.902, -182.106, 0);  //7C
        vertex(0, -240.884, 0);       //8C
        vertex(0, -240.884, depthOfMolecule);       //8C
        vertex(80.902, -182.106, depthOfMolecule);  //7C
      endShape();
      
      beginShape();
        vertex(0, -240.884, 0);       //8C
        vertex(-80.902, -182.106, 0); //9C
        vertex(-80.902, -182.106, depthOfMolecule); //9C
        vertex(0, -240.884, depthOfMolecule);       //8C
      endShape();
      
      beginShape();
        vertex(-80.902, -182.106, 0); //9C
        vertex(-50, -87, 0);          //4C
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(-80.902, -182.106, depthOfMolecule); //9C
      endShape();
      
    popMatrix();
  
  }
  void flip(int transX, int transY, int transZ, float rotateDegrees){
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
        vertex(80.902, -182.106, 0);  //7C
        vertex(0, -240.884, 0);       //8C
        vertex(-80.902, -182.106, 0); //9C
        vertex(-50, -87, 0);
      endShape();
      
      //bottom face of pentagon
      beginShape();
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(50, -87, depthOfMolecule);           //5C
        vertex(80.902, -182.106, depthOfMolecule);  //7C
        vertex(0, -240.884, depthOfMolecule);       //8C
        vertex(-80.902, -182.106, depthOfMolecule); //9C
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
        vertex(80.902, -182.106, 0);  //7C
        vertex(80.902, -182.106, depthOfMolecule);  //7C
        vertex(50, -87, depthOfMolecule);           //5C
      endShape();
      
      beginShape();
        vertex(80.902, -182.106, 0);  //7C
        vertex(0, -240.884, 0);       //8C
        vertex(0, -240.884, depthOfMolecule);       //8C
        vertex(80.902, -182.106, depthOfMolecule);  //7C
      endShape();
      
      beginShape();
        vertex(0, -240.884, 0);       //8C
        vertex(-80.902, -182.106, 0); //9C
        vertex(-80.902, -182.106, depthOfMolecule); //9C
        vertex(0, -240.884, depthOfMolecule);       //8C
      endShape();
      
      beginShape();
        vertex(-80.902, -182.106, 0); //9C
        vertex(-50, -87, 0);          //4C
        vertex(-50, -87, depthOfMolecule);          //4C
        vertex(-80.902, -182.106, depthOfMolecule); //9C
      endShape();
      
  popMatrix();    
}
}
