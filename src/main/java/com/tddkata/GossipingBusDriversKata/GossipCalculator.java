package com.tddkata.GossipingBusDriversKata;

import java.util.List;

public class GossipCalculator {

    public static final int MAX_WORKDAY_IN_MINUTES = 480;

    public String whenShareAllGossips(final List<BusDriver> busDrivers) {
        initializeBusDrivers(busDrivers);

        for (int minute = 0; minute < MAX_WORKDAY_IN_MINUTES; minute++) {
            shareGossipsWithAllDriversByMinute(busDrivers, minute);

            if (isAllGossipsShared(busDrivers)) {
                return String.valueOf(minute + 1);
            }
        }
        return "never";
    }

    private void shareGossipsWithAllDriversByMinute(final List<BusDriver> busDrivers, final int minute) {
        for (BusDriver busDriver : busDrivers) {
            getGossipsFromOtherDrivers(busDriver, busDrivers, minute);
        }
    }

    private void getGossipsFromOtherDrivers(final BusDriver busDriver, final List<BusDriver> busDrivers, final int minute) {
        for (BusDriver otherDriver : busDrivers) {
            if (driversCanSharedGossips(busDriver, otherDriver, minute)) {
                busDriver.getGossips().addAll(otherDriver.getGossips());
            }
        }
    }

    private boolean driversCanSharedGossips(final BusDriver busDriver, final BusDriver otherDriver, final int minute) {
        return busDriver.getBusStopAtMinute(minute).equals(
                otherDriver.getBusStopAtMinute(minute));
    }

    private boolean isAllGossipsShared(final List<BusDriver> busDrivers) {
        for (BusDriver busDriver : busDrivers) {
            if (busDriver.getGossips().size() != busDrivers.size()) {
                return false;
            }
        }
        return true;
    }

    private void initializeBusDrivers(final List<BusDriver> busDrivers) {
        for (int driverNumber = 0; driverNumber < busDrivers.size(); driverNumber++) {
            final BusDriver busDriver = busDrivers.get(driverNumber);
            busDriver.getGossips().add(driverNumber);
        }
    }

}
