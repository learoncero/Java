package at.fhv.itb.lro3572.Media;

import java.time.LocalDate;

import at.fhv.itb.lro3572.Person.Role;

public class Lending {
	private Role _userRole;
	private Media _media;
	private LocalDate _startDate;
	private LocalDate _dueDate;
	private int _extensions;
	
	public Lending (Role userRole, Media media, int lendingPeriod_weeks) {
		_userRole = userRole;
		_media = media;
		_startDate = LocalDate.now();
		_dueDate = LocalDate.now().plusWeeks(lendingPeriod_weeks);
		_extensions = 0;
	}
	
//	getters and setters
	public Role getUserRole() {
		return _userRole;
	}

	public void setUserRole(Role userRole) {
		_userRole = userRole;
	}

	public Media getMedia() {
		return _media;
	}

	public void setMedia(Media media) {
		_media = media;
	}

	public LocalDate getDueDate() {
		return _dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		_dueDate = dueDate;
	}
	
	public LocalDate getStartDate() {
		return _startDate;
	}

	public void setStartDate(LocalDate startDate) {
		_startDate = startDate;
	}

	public int getExtensions() {
		return _extensions;
	}

	public void setExtensions(int extensions) {
		_extensions = extensions;
	}
}
