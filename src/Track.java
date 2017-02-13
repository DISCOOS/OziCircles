/*
    Copyright 2014-2017 DISCO Open Source (https://discoos.org/)

    This file is part of Ozi circle.
*/

import com.oziexplorer.LatLon;
import com.oziexplorer.OziAPI;
import com.oziexplorer.OziException;
import com.oziexplorer.SpatialVector;
import com.oziexplorer.TrackPoint;
import com.oziexplorer.TrackType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sven-Ove Bjerkan
 */
public class Track {
    private final int trackNo;
    private boolean isDrawn = false;
    private final LatLon center;
    
    public Track(int trackNo, LatLon center) {
        this.trackNo = trackNo;
        this.center = center;
    }
    
    public boolean isDrawn() {
        return isDrawn;
    }
    
    public void drawCircle(String radius, String desc, int color) {
        try {
            if (center == null) {
                JOptionPane.showMessageDialog(null, "Dobbelklikk i kartet først, for å sette IPP!", "Brukerfeil", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (this.isDrawn) {
                showCircle();
                return;
            }
            
            Double dblRadius = Double.parseDouble(radius);
 
            OziAPI.clearTrack(trackNo);
            
            // Calculate a vector and add a startingpoint on that position
            SpatialVector sv = new SpatialVector(dblRadius, 0);
            LatLon point = center.addVector(sv);
            TrackPoint tp = new TrackPoint(true, point);
            OziAPI.addTrackPoint(trackNo, tp);
            
            // Add a trackpoint for every 20 degree
            for (int i = 1; i <= 360/15; i++) {
                sv = new SpatialVector((dblRadius), i*15);
                point = center.addVector(sv);
                tp = new TrackPoint(false, point);
                OziAPI.addTrackPoint(trackNo, tp);
            }
            
            OziAPI.setTrackDescription(trackNo, desc);
            OziAPI.setTrackType(trackNo, TrackType.LINE);
            OziAPI.setTrackColor(trackNo, color);
            OziAPI.showAllTracks();
            OziAPI.showTrack(trackNo);
            OziAPI.refreshMap();
            
            isDrawn = true;            
        } catch (OziException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ugyldig radius oppgitt!", "Tall-feil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteCircle() {
        try {
            OziAPI.clearTrack(trackNo);
            OziAPI.refreshMap();
            isDrawn = false;
        } catch (OziException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hideCircle() {
        try {
            OziAPI.hideTrack(trackNo);
            OziAPI.refreshMap();
        } catch (OziException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void showCircle() {
        try {
            OziAPI.showTrack(trackNo);
            OziAPI.refreshMap();
        } catch (OziException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
