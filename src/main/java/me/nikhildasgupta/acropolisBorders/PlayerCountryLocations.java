package me.nikhildasgupta.acropolisBorders;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import xyz.jpenilla.squaremap.api.Point;

import java.awt.*;
import java.util.List;

public class PlayerCountryLocations {
    java.util.List<Polygon> country_jpolygons = List.of();
    public String get_country(Player player){
        Location place=player.getLocation();
 
        return "Hello";
    }
    public void spolgons_to_jpolygons(xyz.jpenilla.squaremap.api.marker.Polygon polygon){
        java.util.List<Point> spoints = polygon.mainPolygon();
        java.util.List<Double> locations_x = java.util.List.of();
        java.util.List<Double> locations_z = java.util.List.of();
        Polygon jpolygon = new Polygon();
        for (Point spoint : spoints){
            Integer x = (int) spoint.x();
            Integer z = (int) spoint.z();
            jpolygon.addPoint( x, z);
        }
        country_jpolygons.add(jpolygon);


    }
}
