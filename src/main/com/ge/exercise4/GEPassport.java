package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GEPassport {
    private static final Logger logger = LogManager.getLogger(GEPassport.class);

    private static final String ENGINE_MODEL = GEPassport.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 0;
    public final double flightHoursBeforeRebuild = 50_000;
    public final double dryWeight = 4_505;
    public final double wetWeight = 5_230;
    public final double takeoffThrust = 20_650;

    private double flightHours;
    private int numRebuilds;

    public GEPassport(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GEPassport(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GEPassport(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    public double thrustToWeightRatio() {
        return takeoffThrust / wetWeight;
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }

}
