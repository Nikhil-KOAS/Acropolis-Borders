package me.nikhildasgupta.acropolisBorders;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.jpenilla.squaremap.api.*;
import xyz.jpenilla.squaremap.api.Point;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;


public final class AcropolisBorders extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Key GP_LAYER_KEY = Key.of("Borders");
        // Plugin startup logic
        System.out.println("TESTING_1_testing!");
        SimpleLayerProvider provider = SimpleLayerProvider
                .builder("Borders")
                .showControls(true)
                .defaultHidden(true)
                .zIndex(99)
                .layerPriority(99)
                .build();

        for (final MapWorld world : SquaremapProvider.get().mapWorlds()) {
                WorldIdentifier identifier=world.identifier();
                System.out.println(identifier.value());

                ConfigurationSection config_b=getConfig().getConfigurationSection("borders");
                Set<String> keys = config_b.getKeys(false);
                world.layerRegistry().register(GP_LAYER_KEY, provider);
                getServer().getPluginManager().registerEvents(new squaremap(this, world, provider), this);
            for (String key : keys) {
                String x="borders."+key;
                List this_country = getConfig().getList(x );
                Color stroke_colour=Color.decode((String) ((LinkedHashMap) this_country.get(0)).get("stroke-colour"));//get_config(x+".stroke_colour", "colour");
                Integer stroke_width= (Integer) ((LinkedHashMap) this_country.get(1)).get("stroke-width");
                Color fill_colour =Color.decode((String) ((LinkedHashMap) this_country.get(2)).get("fill-colour"));
                String id= (String) ((LinkedHashMap) this_country.get(3)).get("id");
                System.out.println(id);
                String text= (String) ((LinkedHashMap) this_country.get(4)).get("text");

                new squaremap(this, world, provider).createPolygon( stroke_colour,  stroke_width,  fill_colour,  id,  text, List.of(Point.of(100, 60),Point.of(0,0), Point.of(100,100)));
            }}




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("TESTING_1_testing!WESTOPP????????");

    }
    public Object get_config(String path, String type) {
        if (type=="string") {
            Object to_return = getConfig().getString(path);
            return to_return;
        } else if ((type=="colour")) {
            Object to_return = getConfig().getColor(path);
            return to_return;
        }else if ((type=="int")) {
            Object to_return = getConfig().getInt(path);
            return to_return;
        }
        else{
        return "fail";
    }
}}
