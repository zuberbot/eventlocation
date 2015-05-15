/**
 * EventLocationInfo
 */
package springmvc.model.beans;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * @author Chuck
 *
 */
@Component
public class EventLocationInfo {

	private int userId;

	private int eventId;

	private int locationId;

	private String event;

	private String latitude;

	private String longitude;

	private String altitude;
	
	private String eventIdTimestamp;

	private Timestamp createdDate;

	private Timestamp updatedDate;

	/**
	 * 
	 */
	public EventLocationInfo() {
		this.userId = 0;
		this.eventId = 0;
		this.locationId = 0;
		this.event = "";
		this.latitude = "";
		this.longitude = "";
		this.altitude = "";
		this.eventIdTimestamp = "";
		this.createdDate = null;
		this.updatedDate = null;
	}

	/**
	 * @param userId
	 * @param eventId
	 * @param locationId
	 * @param event
	 * @param latitude
	 * @param longitude
	 * @param altitude
	 * @param filetimeEventId
	 * @param createdDate
	 * @param updatedDate
	 */
	public EventLocationInfo(int userId, int eventId, int locationId,
			String event, String latitude, String longitude, String altitude,
			String eventIdTimestamp, Timestamp createdDate, Timestamp updatedDate) {
		
		this.userId = userId;
		this.eventId = eventId;
		this.locationId = locationId;
		this.event = event;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.eventIdTimestamp = eventIdTimestamp;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the altitude
	 */
	public String getAltitude() {
		return altitude;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the eventIdTimestamp
	 */
	public String getEventIdTimestamp() {
		return eventIdTimestamp;
	}

	/**
	 * @param eventIdTimestamp the eventIdTimestamp to set
	 */
	public void setEventIdTimestamp(String eventIdTimestamp) {
		this.eventIdTimestamp = eventIdTimestamp;
	}

	
}
