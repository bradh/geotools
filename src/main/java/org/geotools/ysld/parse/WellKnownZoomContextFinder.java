package org.geotools.ysld.parse;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Nullable;

/**
 * A collection of commonly used ZoomContexts
 * 
 * @author Kevin Smith, Boundless
 *
 */
public class WellKnownZoomContextFinder implements ZoomContextFinder {
    
    static private WellKnownZoomContextFinder INSTANCE = new WellKnownZoomContextFinder();
    
    public static WellKnownZoomContextFinder getInstance(){
        return INSTANCE;
    }
    
    private WellKnownZoomContextFinder() {
        contexts = new HashMap<>();
        canonicalNames = new TreeSet<>();
        
        ZoomContext googleMercatorExtended = new RatioZoomContext(559_082_263.9508929, 2);
        contexts.put("WebMercator".toUpperCase(), googleMercatorExtended);
        contexts.put("SphericalMercator".toUpperCase(), googleMercatorExtended);
        contexts.put("GoogleMercator".toUpperCase(), googleMercatorExtended);
        contexts.put("EPSG:3587".toUpperCase(), googleMercatorExtended);
        contexts.put("EPSG:900913".toUpperCase(), googleMercatorExtended);
        contexts.put("EPSG:3857".toUpperCase(), googleMercatorExtended);
        contexts.put("EPSG:3785".toUpperCase(), googleMercatorExtended);
        contexts.put("OSGEO:41001".toUpperCase(), googleMercatorExtended);
        canonicalNames.add("EPSG:3857");
        
        ZoomContext plateCarree = new RatioZoomContext(279_541_132.0143589, 2);
        contexts.put("PlateCarree".toUpperCase(), plateCarree);
        contexts.put("PlateCarrée".toUpperCase(), plateCarree);
        contexts.put("WGS84".toUpperCase(), plateCarree);
        contexts.put("EPSG:4326".toUpperCase(), plateCarree);
        contexts.put("CRS84".toUpperCase(), plateCarree);
        contexts.put("DEFAULT".toUpperCase(), plateCarree);
        canonicalNames.add("EPSG:4326");
        
        ZoomContext niceScales = new ListZoomContext(Arrays.asList(
                5_000_000_000d,
                2_000_000_000d,
                1_000_000_000d,
                  500_000_000d, // 0
                  200_000_000d,
                  100_000_000d,
                   50_000_000d,
                   20_000_000d,
                   10_000_000d,
                    5_000_000d,
                    2_000_000d,
                    1_000_000d,
                      500_000d,
                      200_000d,
                      100_000d,
                       50_000d,
                       20_000d,
                       10_000d,
                        5_000d,
                        2_000d,
                        1_000d,
                          500d,
                          200d,
                          100d,
                           50d,
                           20d,
                           10d,
                            5d,
                            2d,
                            1d
                ), -3);
        contexts.put("NiceScales".toUpperCase(), niceScales);
        canonicalNames.add("NiceScales");
    }
    
    final Set<String> canonicalNames;
    final Map<String, ZoomContext> contexts;
    
    @Override
    public @Nullable ZoomContext get(String name) {
        return contexts.get(name.toUpperCase());
    }

    @Override
    public Set<String> getNames() {
        return contexts.keySet();
    }

    @Override
    public Set<String> getCanonicalNames() {
        return Collections.unmodifiableSet(canonicalNames);
    }
    
}
