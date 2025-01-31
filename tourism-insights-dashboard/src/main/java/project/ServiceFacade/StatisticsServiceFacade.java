package project.ServiceFacade;

import java.util.List;
import project.Common.IDataService;
import project.Model.TripDataAndDuration;
import project.Model.TripStatistics;
import project.Model.VisitorStatistics;
import project.Service.TripsAndDurationDataService;
import project.Service.TripsByDestinationDataService;
import project.Service.VisitorStatisticsDataService;

/**
 * The StatisticsServiceFacade class is a facade that provides a unified interface for accessing various data services 
 * related to statistical information on trips and visitors. It encapsulates the interaction with different services 
 * that handle trip statistics, visitor statistics, and trip duration data.
 * 
 * By using the StatisticsServiceFacade, clients can access the statistical data from these different services 
 * through a single interface without the need to manage each individual service separately.
 * 
 */
public class StatisticsServiceFacade{
    private IDataService<TripStatistics> tripsByDestinationService;
    private IDataService<VisitorStatistics> visitorStatService;
    private IDataService<TripDataAndDuration> tripsAndDurationService;

    public StatisticsServiceFacade() {
        this.tripsByDestinationService = new TripsByDestinationDataService();
        this.visitorStatService = new VisitorStatisticsDataService();
        this.tripsAndDurationService = new TripsAndDurationDataService();
    }

    /**
     * Retrieves all trip statistics grouped by destination.
     */
    public List<TripStatistics> getTripsByDestination() {
        return tripsByDestinationService.processData();
    }

    /**
     * Retrieves all visitor statistics.
     */
    public List<VisitorStatistics> getVisitorStatistics() {
        return visitorStatService.processData();
    }

    /**
     * Retrieves all trip data including destination, duration, and visitor count.
     */
    public List<TripDataAndDuration> getTripsAndDuration() {
        return tripsAndDurationService.processData();
    }

    /**
     * Filters trip statistics by the selected season.
     */
    public List<TripStatistics> getTripsBySeason(List<TripStatistics> tripDataList, String selectedSeason) {
        return tripsByDestinationService.filterData(tripDataList, selectedSeason);
    }

    /**
     * Filters visitor statistics by the selected trip type.
     */
    public List<VisitorStatistics> getVisitorsByTripType(List<VisitorStatistics> visitorDataList, String tripType) {
        return visitorStatService.filterData(visitorDataList, tripType);
    }

    /**
     * Filters trip data by the selected year.
     */
    public List<TripDataAndDuration> getTripsByYear(List<TripDataAndDuration> tripDataList, String selectedYear) {
        return tripsAndDurationService.filterData(tripDataList, selectedYear);
    }
}
