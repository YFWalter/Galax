package Sonido;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.net.URL;
                                                        
public class Sonido { 
                                                       
        protected AudioInputStream sample;
        protected Clip clip; 
        protected URL soundURL;
        protected boolean looping = false;
        protected int repeat = 0;

        public Sonido(String str) { 
                                                       
                try {
                	soundURL = Class.class.getResource(str);
                    sample = AudioSystem.getAudioInputStream(soundURL);
                    DataLine.Info info = new DataLine.Info(Clip.class, sample.getFormat());
                    clip = (Clip) AudioSystem.getLine(info);
                    clip.open(sample);                                                   
                }catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {  
                      e.printStackTrace();
                }
        }
        
        public void setLooping(boolean looping) {

            this.looping = looping; 
	    }           
	                                         
	    public void setRepeat(int repeat) {
	
	            this.repeat = repeat;
	    }  	                                               
	
	    public Clip getClip() { 
	                                                   
	            return clip; 
	    }
	                                               
	    public boolean getLooping() { 
	                                                   
	            return looping;
	    }
	                                                  
	    public int getRepeat() {
	                                                    
	            return repeat; 
	    }
	                                               
        public boolean isLoaded() {
            
            return (boolean)(sample != null);
        }
        
        public void play() { 
            
            if (!isLoaded()) 
                return;
                                                    
            clip.setFramePosition(0);
                                                 
            if (looping) 
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            else 
                clip.loop(repeat);
    }

        public void stop() { 
                                                       
                clip.stop();
        }
}