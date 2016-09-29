package PckRobo;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.GLUT;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLJPanel;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

public class Roboo implements GLEventListener {

   GLUT glut = new GLUT();
   GLU glu = new GLU();
   GL gl;
   int rot = 0;
   int rot2 = 0;
   int rot3 = 0;

   public static void main(String args[]) {
      new Roboo();
   }

   public Roboo() {

      GLJPanel canvas = new GLJPanel();
      canvas.addGLEventListener(this);

      JFrame frame = new JFrame("Robo");
      frame.setSize(500, 500);
      frame.getContentPane().add(canvas);
      frame.setVisible(true);

      frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            new Thread(new Runnable() {
               public void run() {
                  System.exit(0);
               }
            }).start();
         }
      });
   }

   public void init(GLAutoDrawable glAutoDrawable) {
      Animator a = new Animator(glAutoDrawable);
      a.start();
      gl = glAutoDrawable.getGL();
      gl.glEnable(GL.GL_DEPTH_TEST);
   }

   public void display(GLAutoDrawable glAutoDrawable) {

      gl = glAutoDrawable.getGL();

      gl.glLoadIdentity();
      gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
      gl.glTranslated(0, 0, -15);

      drawRobot();

   }

    private int allRot = 0;
    private int allSpeed = 1;
    private int armRot = 0;
    private int armSpeed = 1;
    private int legsRot = 0;
    private int legsSpeed = 1;
    
    private void drawLeg()
    {
            gl.glScaled(0.8, 2, 0.8);
            glut.glutWireCube(1);
            gl.glPushMatrix();
                    gl.glTranslated(0, -1, 0);
                    glut.glutWireCube(1);
                    gl.glPushMatrix();
                            gl.glTranslated(0, -0.6, 0.2);
                            gl.glScaled(1, 0.2, 1);
                            glut.glutWireCube(1);
                    gl.glPopMatrix();
            gl.glPopMatrix();
    };
    private void drawLegs()
    {
            gl.glPushMatrix();
                    gl.glRotated(legsRot, 0, 0, -1);
                    gl.glTranslated(-0.5, -2.5, 0);
                    drawLeg();
            gl.glPopMatrix();
            gl.glPushMatrix();
                    gl.glRotated(legsRot, 0, 0, 1);
                    gl.glTranslated(+0.5, -2.5, 0);
                    drawLeg();
            gl.glPopMatrix();
    };
    private void drawBody()
    {
            gl.glPushMatrix();
                    gl.glScaled(2, 3, 1);
                    glut.glutWireCube(1);
            gl.glPopMatrix();
            gl.glPushMatrix();
                    gl.glRotated(allRot, 2, 2, 0);
                    glut.glutWireTeapot(0.5);
            gl.glPopMatrix();
    };
    private void drawHead()
    {
            gl.glPushMatrix();
                    gl.glTranslated(0, 1.7, 0);
                    gl.glPushMatrix();
                            // Pescoco
                            glut.glutWireCube(0.4f);
                            gl.glPushMatrix();
                                    gl.glTranslated(0, 0.6, 0);
                                    // Cabeca
                                    gl.glPushMatrix();
                                            gl.glScaled(0.6, 0.8, 0.6);
                                            glut.glutWireCube(1);
                                            // Olhos
                                            gl.glPushMatrix();
                                                    gl.glTranslated(0.2, 0.2, 0.5);
                                                    glut.glutWireCube(0.2f);
                                            gl.glPopMatrix();
                                            gl.glPushMatrix();
                                                    gl.glTranslated(-0.2, 0.2, 0.5);
                                                    glut.glutWireCube(0.2f);
                                            gl.glPopMatrix();
                                    gl.glPopMatrix();
                                    gl.glTranslated(0, 1.2, 0);
                                    glut.glutWireTeapot(1);
                            gl.glPopMatrix();
                    gl.glPopMatrix();
            gl.glPopMatrix();
    };
    private void drawArm()
    {
            gl.glPushMatrix();
                    gl.glTranslated(1.8, 0.9, 0);
                    gl.glPushMatrix();
                            gl.glScaled(1.6, 0.5, 0.5);
                            glut.glutWireCube(1);
                    gl.glPopMatrix();
                    gl.glTranslated(1.6, 0, 0);
                    gl.glPushMatrix();
                            gl.glTranslated(-0.5, 0, 0);
                            gl.glRotated(armRot, 0, 0, 1);
                            gl.glPushMatrix();
                                    gl.glTranslated(0.5, 0, 0);
                                    gl.glScaled(1.6, 0.5, 0.5);
                                    glut.glutWireCube(1);
                            gl.glPopMatrix();

                            gl.glTranslated(2, 0, 0);
                            glut.glutWireTeapot(0.4);
                    gl.glPopMatrix();
            gl.glPopMatrix();
    };
    private void drawArms()
    {
            gl.glPushMatrix();
            drawArm();
            gl.glRotated(180, 0, 1, 0);
            drawArm();
            gl.glPopMatrix();
    };
    void drawRobot()
    {
            allRot += allSpeed;

            armRot += armSpeed;
            if(armRot > 100) armSpeed = -1;
            else if(armRot < 1) armSpeed = 1;

            legsRot += legsSpeed;
            if(legsRot > 20) legsSpeed = -1;
            else if(legsRot < 1) legsSpeed = 1;

            gl.glRotated(allRot, 0, 1, 0);
            gl.glPushMatrix();
                    drawBody();
                    drawHead();
                    drawLegs();
                    drawArms();
            gl.glPopMatrix();
    };
   
   
   public void reshape(GLAutoDrawable gLAutoDrawable, int x, int y, int w, int h) {
      gl = gLAutoDrawable.getGL();
      gl.glMatrixMode(GL.GL_PROJECTION);
      gl.glLoadIdentity();
      glu.gluPerspective(60, 1, 1, 100);
      gl.glMatrixMode(GL.GL_MODELVIEW);
      gl.glLoadIdentity();
      gl.glTranslated(0, 0, -5);
   }

   public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
   }
}
