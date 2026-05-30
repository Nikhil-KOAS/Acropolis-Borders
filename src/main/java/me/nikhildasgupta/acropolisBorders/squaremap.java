package me.nikhildasgupta.acropolisBorders;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.jpenilla.squaremap.api.BukkitAdapter;
import xyz.jpenilla.squaremap.api.Key;
import xyz.jpenilla.squaremap.api.MapWorld;
import xyz.jpenilla.squaremap.api.Point;
import xyz.jpenilla.squaremap.api.SimpleLayerProvider;
import xyz.jpenilla.squaremap.api.marker.Marker;
import xyz.jpenilla.squaremap.api.marker.MarkerOptions;
import xyz.jpenilla.squaremap.api.marker.Polygon;
import xyz.jpenilla.squaremap.api.marker.Rectangle;

public final class squaremap  extends BukkitRunnable implements Listener {
    private final World bukkitWorld;
    private final SimpleLayerProvider provider;
    private final AcropolisBorders plugin;

    private boolean stop;

    public squaremap(AcropolisBorders plugin, MapWorld world, SimpleLayerProvider provider) {
        this.plugin = plugin;
        this.bukkitWorld = BukkitAdapter.bukkitWorld(world);
        this.provider = provider;
    }

    @Override
    public void run() {
        if (this.stop) {
            this.cancel();
        }

    }



    <sC, sL, cT, iD, pL, fC> void createPolygon(Color sC, Integer sL, Color fC , String iD , String cT, List pL) {

        Polygon rect = Marker.polygon(pL);
        ArrayList<String> builders = new ArrayList<>();
        ArrayList<String> containers = new ArrayList<>();
        ArrayList<String> accessors = new ArrayList<>();
        ArrayList<String> managers = new ArrayList<>();



        MarkerOptions.Builder options = MarkerOptions.builder()
                .strokeColor(sC)
                .strokeWeight(sL)
                .strokeOpacity(1.0)
                .fillColor(fC)
                .fillOpacity(0.75)
                .clickTooltip(cT);



        rect.markerOptions(options);

        String markerid = iD ;
        this.provider.addMarker(Key.of(markerid), rect);
    }



    public void disable() {
        this.cancel();
        this.stop = true;
        this.provider.clearMarkers();
    }
}
