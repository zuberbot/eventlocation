/**
 * Event
 */
package springmvc.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Chuck
 * 
 */
@Entity
@Table(name = "events")
public class Event implements Serializable {

	private static final long serialVersionUID = 7600772918555933400L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "active")
	private String active;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "event")
	private String event;

	@Column(name = "event_id_timestamp")
	private String eventIdTimestamp;

	/**
	 * 
	 */
	public Event() {
		this.id = 0;
		this.createdDate = null;
		this.updatedDate = null;
		this.active = null;
		this.userId = 0;
		this.event = null;
		this.eventIdTimestamp = null;
	}

	/**
	 * @param userId
	 * @param event
	 */
	public Event(int id, Timestamp createdDate, Timestamp updatedDate,
			String active, int userId, String event, String eventIdTimestamp) {

		this.id = id;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.active = active;
		this.userId = userId;
		this.event = event;
		this.eventIdTimestamp = eventIdTimestamp;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [id=" + id + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", active=" + active
				+ ", userId=" + userId + ", event=" + event
				+ ", eventIdTimestamp=" + eventIdTimestamp + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result
				+ ((eventIdTimestamp == null) ? 0 : eventIdTimestamp.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + userId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Event)) {
			return false;
		}
		Event other = (Event) obj;
		if (active == null) {
			if (other.active != null) {
				return false;
			}
		} else if (!active.equals(other.active)) {
			return false;
		}
		if (createdDate == null) {
			if (other.createdDate != null) {
				return false;
			}
		} else if (!createdDate.equals(other.createdDate)) {
			return false;
		}
		if (event == null) {
			if (other.event != null) {
				return false;
			}
		} else if (!event.equals(other.event)) {
			return false;
		}
		if (eventIdTimestamp == null) {
			if (other.eventIdTimestamp != null) {
				return false;
			}
		} else if (!eventIdTimestamp.equals(other.eventIdTimestamp)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (updatedDate == null) {
			if (other.updatedDate != null) {
				return false;
			}
		} else if (!updatedDate.equals(other.updatedDate)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

}
